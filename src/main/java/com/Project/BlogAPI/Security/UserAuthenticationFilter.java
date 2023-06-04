package com.Project.BlogAPI.Security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;

public class UserAuthenticationFilter extends AuthenticationFilter {
    public  UserAuthenticationFilter(TokenService tokenService){
        super(new UserAuthenticationManager(tokenService), new BearerTokenAuthenticationConverter());

        this.setSuccessHandler((request, response, authentication) -> {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        });
    }
    static class BearerTokenAuthenticationConverter  implements AuthenticationConverter{

        @Override
        public Authentication convert(HttpServletRequest request) {
            if(request.getHeader("Authorization")!=null) {
                String token = request.getHeader("Authorization").replace("Bearer","");
                return new UserAuthentication(token);
            }
            return  null;
        }
    }

    static class UserAuthenticationManager implements AuthenticationManager{
        private final TokenService tokenService;
        public UserAuthenticationManager(TokenService tokenService){
            this.tokenService = tokenService;
        }
        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            if(authentication instanceof  UserAuthentication){
                UserAuthentication userAuthentication = (UserAuthentication) authentication;
                var username = tokenService.getUserNameFromToken( userAuthentication.getCredentials());
                if(username != null){
                    userAuthentication.setUser(username);
                    return userAuthentication;
                }
            }
            return null;
        }
    }
}
