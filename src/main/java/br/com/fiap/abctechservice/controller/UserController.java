package br.com.fiap.abctechservice.controller;

import br.com.fiap.abctechservice.model.dto.AuthDTO;
import br.com.fiap.abctechservice.model.dto.JwtDTO;
import br.com.fiap.abctechservice.model.dto.UserCreateDTO;
import br.com.fiap.abctechservice.model.dto.UserDTO;
import br.com.fiap.abctechservice.service.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Profile("!dev")
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return userService.create(userCreateDTO);
    }

    @PostMapping("login")
    public JwtDTO login(@RequestBody AuthDTO authDTO) {
        return userService.login(authDTO);
    }
    
}