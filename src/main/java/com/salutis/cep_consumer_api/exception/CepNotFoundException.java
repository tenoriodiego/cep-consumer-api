package com.salutis.cep_consumer_api.exception;

public class CepNotFoundException extends RuntimeException {

    public CepNotFoundException() {
        super("CEP não encontrado.");
    }

    public CepNotFoundException(String message) {
        super(message);
    }

    public CepNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CepNotFoundException(Throwable cause) {
        super(cause);
    }
}