package com.example.demo.product.exceptions;

public class UserException extends Exception {

    static final long serialVersionUID = -3387516993124229948L;

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
