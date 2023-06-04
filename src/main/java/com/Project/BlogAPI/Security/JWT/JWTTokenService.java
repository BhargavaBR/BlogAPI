package com.Project.BlogAPI.Security.JWT;

import com.Project.BlogAPI.Security.TokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.security.AlgorithmConstraints;
import java.util.Date;

public class JWTTokenService implements TokenService {

    private final Algorithm algorithm;

    private final String signingKey ="A long Key is to sign tokens";
    private final long TOKEN_EXPIRE_MILLIS = 1000*60*60*24;
    private  final String ISSUER = "blog-api";

    public JWTTokenService(){
        this.algorithm = Algorithm.HMAC256(signingKey);
    }


    @Override
    public String createToken(String userName) {
        return JWT.create()
                .withSubject(userName)
                .withIssuer(ISSUER)
                .withIssuedAt(new java.util.Date())
                .withExpiresAt(new java.util.Date(System.currentTimeMillis() + TOKEN_EXPIRE_MILLIS))
                .sign(algorithm);
    }

    @Override
    public String getUserNameFromToken(String token) {
        var verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build();

        var decodedToken = verifier.verify(token);
        return decodedToken.getSubject();
    }
}
