package com.proxy.user.infrastructure.exception;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    private Integer status;
    private String message;
    private List<String> details;
}
