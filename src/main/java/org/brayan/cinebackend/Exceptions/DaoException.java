package org.brayan.cinebackend.Exceptions;

public class DaoException extends Exception{

    private static final long serialVersionUID = 1L;

    public DaoException(String message) {
        super(message);
    }

    public DaoException() {
        super();
    }

}
