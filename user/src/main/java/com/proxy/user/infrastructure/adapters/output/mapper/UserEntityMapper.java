package com.proxy.user.infrastructure.adapters.output.mapper;

import com.proxy.user.domain.User;
import com.proxy.user.infrastructure.adapters.output.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);
    List<User> toUsers(List<UserEntity> userEntities);

}
