package com.exceptions;

public class TripValidationException extends RuntimeException {

    private String message;

    public TripValidationException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
