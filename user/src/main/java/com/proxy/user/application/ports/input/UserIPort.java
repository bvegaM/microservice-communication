package com.proxy.user.application.ports.input;

import com.proxy.user.domain.User;
import feign.FeignException;

import java.util.List;

public interface UserIPort {

    List<User> findAll() throws FeignException;

    User save(User user) throws FeignException;
}
