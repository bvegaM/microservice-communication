package com.db.userdb.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Integer id;

    @NotEmpty(message = "Property name should not be null or empty")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Property name contains numbers or specials characters")
    private String name;

    @Min(value = 18, message = "Property age must be a minimum value of 18")
    private Integer age;

    @NotEmpty(message = "Property email should not be null or empty")
    private String email;
}
