package com.Project.BlogAPI.Users.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class CreateUserDTO {
    @NonNull
    String username;
    @NonNull
    String email;
    @NonNull
    String password;
    String bio;
}