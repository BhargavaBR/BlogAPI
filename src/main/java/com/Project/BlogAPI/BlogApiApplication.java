
package com.Project.BlogAPI;

import com.Project.BlogAPI.Security.JWT.JWTTokenService;
import com.Project.BlogAPI.Security.TokenService;
import com.Project.BlogAPI.Users.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

	@Bean
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


	@Bean
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public PasswordEncoder passwordEncoder(){

		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return bcryptPasswordEncoder.encode(rawPassword);
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return bcryptPasswordEncoder.matches(rawPassword, encodedPassword);
			}
		};
	}

	@Bean
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public TokenService tokenService(
		@Autowired UsersRepository usersRepository
	){
		return  new JWTTokenService();
	}
}
