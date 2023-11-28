package com.db.userdb.mapper;

import com.db.userdb.domain.User;
import com.db.userdb.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTOs(List<User> user);

    User toUser(UserDTO userDTO);
}
