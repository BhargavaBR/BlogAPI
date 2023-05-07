package com.Project.BlogAPI.Users;


import com.Project.BlogAPI.Commons.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.CreatedDate;

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


}
