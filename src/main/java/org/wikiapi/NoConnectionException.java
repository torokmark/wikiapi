package org.wikiapi;

public class NoConnectionException extends RuntimeException {

    private static final long serialVersionUID = 5086502187231669144L;

    public NoConnectionException() {

    }

    public NoConnectionException(final String message) {
        super(message);
    }
}
