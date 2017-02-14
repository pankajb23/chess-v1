package com.dejected.exception;

/**
 * Created on 04/02/17 by dark magic.
 */
public class InValidMoveException extends RuntimeException {
    public InValidMoveException() {
    }

    public InValidMoveException(String message) {
        super(message);
    }
}
