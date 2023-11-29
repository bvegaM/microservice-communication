package com.proxy.user.infrastructure.adapters.input.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private String name;

    private Integer age;

    private String email;
}
