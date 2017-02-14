package com.dejected.exception;

/**
 * Created on 04/02/17 by dark magic.
 */
public class NoSoldierPresentException extends RuntimeException {
    public NoSoldierPresentException() {
    }

    public NoSoldierPresentException(String message) {
        super(message);
    }
}
