package com.proxy.user.infrastructure.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler({
            FeignException.class
    })
    public ResponseEntity<Error> feignException(FeignException exception) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ByteBuffer responseBody = exception.responseBody().orElse(null);

        assert responseBody != null;
        byte[] bytes = new byte[responseBody.remaining()];

        responseBody.get(bytes);

        String errorBody = new String(bytes, StandardCharsets.UTF_8);

        return ResponseEntity.badRequest().body(objectMapper.readValue(errorBody, Error.class));
    }
}
