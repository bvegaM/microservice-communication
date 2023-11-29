package com.proxy.user.application.ports.output;

import com.proxy.user.domain.User;
import feign.FeignException;

import java.util.List;

public interface UserOPort {

    List<User> findAll() throws FeignException;

    User save(User user) throws FeignException;
}
