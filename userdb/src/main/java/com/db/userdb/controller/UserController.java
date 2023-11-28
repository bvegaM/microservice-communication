package com.db.userdb.controller;

import com.db.userdb.dto.UserDTO;
import com.db.userdb.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers() throws InterruptedException {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping()
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserDTO userDTO){
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }
}
