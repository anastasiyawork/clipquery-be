package com.clipquery.clipquery_api.exception;

public class InvalidUserEmail extends RuntimeException {
    public InvalidUserEmail(String message) {
        super(message);
    }

    public InvalidUserEmail(String message, Throwable cause) {
        super(message, cause);
    }
}
