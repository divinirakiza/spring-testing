package com.practice.springtest.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class APIException {
    private final String message;
    private final Throwable throwable;
    private  final HttpStatus httpStatus;
    private String details;
    private Date timestamp;

    public APIException(String message, Throwable throwable, HttpStatus httpStatus, String details, Date timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
