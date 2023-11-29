package com.proxy.user.application.service;

import com.proxy.user.application.ports.input.UserIPort;
import com.proxy.user.application.ports.output.UserOPort;
import com.proxy.user.domain.User;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserIPort {

    private final UserOPort userOPort;

    @Override
    public List<User> findAll() throws FeignException {
        return userOPort.findAll();
    }

    @Override
    public User save(User user) throws FeignException{
        return userOPort.save(user);
    }
}
