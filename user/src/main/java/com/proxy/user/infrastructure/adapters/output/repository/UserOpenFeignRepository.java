package com.proxy.user.infrastructure.adapters.output.repository;

import com.proxy.user.infrastructure.adapters.output.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url = "http://localhost:8090", name = "userOpenFeignRepository")
public interface UserOpenFeignRepository {


    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserEntity>> findAll();

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserEntity> save(@RequestBody UserEntity userEntity);
}
