package com.Project.BlogAPI.Users.DTO;

import lombok.Data;
import lombok.NonNull;
@Data
public class LoginUserDTO {
    @NonNull
    String username;
    @NonNull
    String password;
}
