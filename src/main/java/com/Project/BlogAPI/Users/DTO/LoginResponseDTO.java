package com.Project.BlogAPI.Users.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDTO {
    String username;
    String message;
    int status;
}
