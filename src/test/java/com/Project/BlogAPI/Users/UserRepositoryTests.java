package com.Project.BlogAPI.Users;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UsersRepository usersRepository;



    @Test
    public void createUser(){
        UsersEntity usersEntity = UsersEntity.builder()
                .username("bhargava")
                .email("bhargav@gmail.com")
                .password("bg123")
                .build();
        var user = usersRepository.save(usersEntity);
        Assertions.assertNotNull(user);
    }

    @Test
    public void findByUserName(){
        UsersEntity user1 = UsersEntity.builder()
                .username("bhargav1")
                .email("bg1@gmail.com")
                .password("bg@123")
                .build();

        UsersEntity user2 = UsersEntity.builder()
                .username("bhargav2")
                .email("bg2@gmail.com")
                .password("bg@123")
                .build();

        usersRepository.save(user1);
        usersRepository.save(user2);

        var savedUser1 = usersRepository.findByUsername("bhargav1");
        var savedUser2 = usersRepository.findByUsername("bhargav2");
        System.out.println("Password of User 1 is"+user1.getPassword());
        Assertions.assertEquals("bg1@gmail.com",savedUser1.getEmail());
        Assertions.assertEquals("bg2@gmail.com",savedUser2.getEmail());
        Assertions.assertEquals("bg@123",savedUser1.getPassword());

    }



}
