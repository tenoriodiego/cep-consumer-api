package com.salutis.cep_consumer_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampoVazioException extends RuntimeException {
    public CampoVazioException(String message) {
        super(message);
    }
}