package com.Project.BlogAPI.Users;


import com.Project.BlogAPI.Articles.AtricleEntity;
import com.Project.BlogAPI.Commons.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)

@Getter
@Setter
@Entity(name = "users")
public class UsersEntity extends BaseEntity {
    @Column(nullable = false,length = 100,unique = true)
    String username;
    @Column(nullable = false,length = 100,unique = true)
    String email;
    @Column(nullable = false)
    String password;
    @Column(length=200)
    String bio;

    @ManyToMany(targetEntity = UsersEntity.class,mappedBy = "following")
    List<UsersEntity> followers;
    @ManyToMany()
    List<UsersEntity> following;
    @ManyToMany(targetEntity = AtricleEntity.class,mappedBy = "likes")
    List<AtricleEntity> favorites;

}
