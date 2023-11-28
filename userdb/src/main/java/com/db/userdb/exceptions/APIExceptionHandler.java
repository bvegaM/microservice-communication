package com.db.userdb.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<Error> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<String> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        Error error = Error.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Error in validation params")
                .details(errors).build();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler({
            SQLException.class
    })
    public ResponseEntity<Error> sqlExceptionHelper(SQLException exception){
        Error error = Error.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Error with SQL transaction")
                .details(Collections.singletonList(exception.getMessage().split(":")[0])).build();
        return ResponseEntity.badRequest().body(error);
    }
}
