package com.proxy.user.infrastructure.adapters.input.mapper;

import com.proxy.user.domain.User;
import com.proxy.user.infrastructure.adapters.input.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {

    List<UserDTO> toUserDTOs(List<User> users);
    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);
}
