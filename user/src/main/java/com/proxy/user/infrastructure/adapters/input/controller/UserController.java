package com.proxy.user.infrastructure.adapters.input.controller;

import com.proxy.user.application.ports.input.UserIPort;
import com.proxy.user.domain.User;
import com.proxy.user.infrastructure.adapters.input.dto.UserDTO;
import com.proxy.user.infrastructure.adapters.input.mapper.UserDTOMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users-proxy")
@RequiredArgsConstructor
public class UserController {

    private final UserIPort userIPort;
    private final UserDTOMapper userDTOMapper;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers() throws FeignException{
        return ResponseEntity.ok().body(userDTOMapper.toUserDTOs(userIPort.findAll()));

    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) throws FeignException{
        User user = userDTOMapper.toUser(userDTO);
        return new ResponseEntity<>(userDTOMapper.toUserDTO(userIPort.save(user)), HttpStatus.CREATED);
    }

}
