package com.protey.test.Controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class ApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime time;
    private String message;
    private List<String> errors;

    public ApiError() {
        this.time = LocalDateTime.now();
    }

    ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    ApiError(HttpStatus status, Throwable e) {
        this();
        this.status = status;
        this.message = "Unexpected error: " + e.getLocalizedMessage();
    }

    ApiError(HttpStatus status, String message, Throwable e) {
        this();
        this.status = status;
        this.message = message;
        //this.debug = e.getLocalizedMessage();
    }

    ApiError(HttpStatus status, String message, String error) {
        this();
        this.status = status;
        this.message = message;
        this.errors = Collections.singletonList(error);
    }

    ApiError(HttpStatus status, String message, List<String> error) {
        this();
        this.status = status;
        this.message = message;
        this.errors = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
