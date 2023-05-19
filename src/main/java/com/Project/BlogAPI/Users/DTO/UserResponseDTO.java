package com.Project.BlogAPI.Users.DTO;

import lombok.*;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class UserResponseDTO {
    @NonNull
    String username;
    @NonNull
    String email;
    String bio;
    String token;
}
