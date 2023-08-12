package com.escola.projeto.infrastructure.exceptions;

import lombok.Getter;

public class ApiException extends RuntimeException {

    @Getter
    private Object object;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Object object) {
        super(message);
        this.getObject().equals(object);
    }


}
