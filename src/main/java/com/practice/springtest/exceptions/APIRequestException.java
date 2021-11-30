package com.practice.springtest.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class APIRequestException extends RuntimeException{
    public APIRequestException(String msg) {
        super(msg);
    }
    public APIRequestException(String msg,Throwable cause) {
        super(msg,cause);
    }
}
