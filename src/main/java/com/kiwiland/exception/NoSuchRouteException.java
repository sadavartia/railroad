package com.kiwiland.exception;

public class NoSuchRouteException extends Exception {
    public NoSuchRouteException() {
    }

    public NoSuchRouteException(String message) {
        super(message);
    }

    public NoSuchRouteException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchRouteException(Throwable cause) {
        super(cause);
    }

    public NoSuchRouteException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
