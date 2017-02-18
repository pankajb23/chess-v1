package com.dejected.exception;

/**
 * Created on 18/02/17 by dark magic.
 */
public class NoKingAvilableException extends RuntimeException {
    public NoKingAvilableException() {
    }

    public NoKingAvilableException(String message) {
        super(message);
    }
}
