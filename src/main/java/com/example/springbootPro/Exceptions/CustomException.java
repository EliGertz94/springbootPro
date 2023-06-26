package com.example.springbootPro.Exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception{

   private HttpStatus httpStatus;
    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
