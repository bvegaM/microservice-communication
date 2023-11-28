package com.db.userdb.service.impl;

import com.db.userdb.domain.User;
import com.db.userdb.dto.UserDTO;
import com.db.userdb.mapper.UserMapper;
import com.db.userdb.repository.UserRepository;
import com.db.userdb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUserDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        return userMapper.toUserDTO(userRepository.save(user));
    }
}
