package com.Project.BlogAPI.Users;

import com.Project.BlogAPI.Users.DTO.LoginResponseDTO;
import com.Project.BlogAPI.Users.DTO.LoginUserDTO;
import com.Project.BlogAPI.Users.DTO.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserService(
            @Autowired UsersRepository usersRepository,
            @Autowired PasswordEncoder passwordEncoder,
            @Autowired ModelMapper modelMapper

    ){
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public UserResponseDTO createUser(UsersEntity createUser){
        createUser.setPassword(passwordEncoder.encode(createUser.getPassword()));
        usersRepository.save(createUser);
        UserResponseDTO savedUser = modelMapper.map(createUser,UserResponseDTO.class);
        return savedUser;
    }

    public LoginResponseDTO loginUser(LoginUserDTO loginUser) throws Exception {
        var loggedInUser = usersRepository.findByUsername(loginUser.getUsername());
        if(loggedInUser != null){
            if(passwordEncoder.matches(loginUser.getPassword(),loggedInUser.getPassword())){
                return LoginResponseDTO.builder()
                        .username(loginUser.getUsername())
                        .message("Login Successfully")
                        .status(400).build();
            }

        }
        throw new Exception("Login Failed, please try again");
    }



}
