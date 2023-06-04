package com.Project.BlogAPI.Security;

import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    String createToken(String userName);

    String getUserNameFromToken(String token);
}
