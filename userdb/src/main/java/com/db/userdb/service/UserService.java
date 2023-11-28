package com.db.userdb.service;

import com.db.userdb.dto.UserDTO;

import java.util.List;

public interface UserService {


    List<UserDTO> findAll();

    UserDTO save(UserDTO userDTO);
}
