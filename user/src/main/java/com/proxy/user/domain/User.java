package com.proxy.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private String email;
}
