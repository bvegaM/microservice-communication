package com.db.userdb.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
public class Error {

    private Integer status;
    private String message;
    private List<String> details;
}
