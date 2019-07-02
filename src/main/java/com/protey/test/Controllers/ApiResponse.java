package com.protey.test.Controllers;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {

    private HttpStatus status;
    private T result;

    public ApiResponse(HttpStatus status, T result) {
        this.status = status;
        this.result = result;
    }

    public ApiResponse(HttpStatus status) {
        this.status = status;
        this.result = null;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
