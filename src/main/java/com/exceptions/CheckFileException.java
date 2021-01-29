package com.exceptions;

public class CheckFileException extends RuntimeException{

     private String message;

     public CheckFileException(String message) {
         super(message);
         this.message = message;
     }

    @Override
    public String getMessage() {
        return message;
    }
}
