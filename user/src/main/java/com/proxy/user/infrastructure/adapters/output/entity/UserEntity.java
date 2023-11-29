package com.proxy.user.infrastructure.adapters.output.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    private Integer id;

    private String name;

    private Integer age;

    private String email;
}
