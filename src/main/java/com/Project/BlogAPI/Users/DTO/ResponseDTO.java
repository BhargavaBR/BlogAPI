package com.Project.BlogAPI.Users.DTO;

import com.Project.BlogAPI.Users.UsersEntity;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    String Success;
    UsersEntity usersEntity;

}
