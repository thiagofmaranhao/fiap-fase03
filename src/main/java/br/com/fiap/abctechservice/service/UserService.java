package br.com.fiap.abctechservice.service;

import br.com.fiap.abctechservice.model.dto.AuthDTO;
import br.com.fiap.abctechservice.model.dto.JwtDTO;
import br.com.fiap.abctechservice.model.dto.UserCreateDTO;
import br.com.fiap.abctechservice.model.dto.UserDTO;

public interface UserService {

    UserDTO create(UserCreateDTO userCreateDTO);

    JwtDTO login(AuthDTO authDTO);

    UserDTO findByUsername(String username);

}