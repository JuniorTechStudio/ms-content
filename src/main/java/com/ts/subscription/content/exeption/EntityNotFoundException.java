package com.ts.subscription.content.exeption;

public class EntityNotFoundException extends RuntimeException {

    private ErrorCode errorCode;

    public EntityNotFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
