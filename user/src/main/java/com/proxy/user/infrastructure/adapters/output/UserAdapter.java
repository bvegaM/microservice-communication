package com.proxy.user.infrastructure.adapters.output;

import com.proxy.user.application.ports.output.UserOPort;
import com.proxy.user.domain.User;
import com.proxy.user.infrastructure.adapters.output.entity.UserEntity;
import com.proxy.user.infrastructure.adapters.output.mapper.UserEntityMapper;
import com.proxy.user.infrastructure.adapters.output.repository.UserOpenFeignRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAdapter implements UserOPort {

    private final UserOpenFeignRepository userOpenFeignRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public List<User> findAll() throws FeignException {
        ResponseEntity<List<UserEntity>> userEntities = userOpenFeignRepository.findAll();
        log.info(userEntities.toString());
        return userEntityMapper.toUsers(userEntities.getBody());
    }

    @Override
    public User save(User user) throws FeignException {
        UserEntity userEntity = userEntityMapper.toUserEntity(user);
        ResponseEntity<UserEntity> userEntityResponseEntity = userOpenFeignRepository.save(userEntity);
        log.info(userEntityResponseEntity.toString());
        return userEntityMapper.toUser(userEntityResponseEntity.getBody());
    }
}
