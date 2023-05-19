package com.Project.BlogAPI.Users;

import com.Project.BlogAPI.Users.DTO.CreateUserDTO;
import com.Project.BlogAPI.Users.DTO.LoginResponseDTO;
import com.Project.BlogAPI.Users.DTO.LoginUserDTO;
import com.Project.BlogAPI.Users.DTO.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(
            @Autowired UserService userService,
            @Autowired ModelMapper modelMapper
    ){
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/signup")
    ResponseEntity<UserResponseDTO> createUser(@RequestBody CreateUserDTO createUserDTO){
        UsersEntity createNewUser = modelMapper.map(createUserDTO,UsersEntity.class);
        UserResponseDTO savedUser = userService.createUser(createNewUser);
        return ResponseEntity.accepted().body(savedUser);

    }

    @PostMapping("/login")
    ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginUserDTO loginUserDTO) throws Exception {
        LoginResponseDTO respose  = userService.loginUser(loginUserDTO);
        return ResponseEntity.accepted().body(respose);
    }

}
