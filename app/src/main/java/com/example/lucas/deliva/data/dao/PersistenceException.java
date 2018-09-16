package com.example.lucas.deliva.data.dao;

public class PersistenceException extends Exception {

    private PersistenceErrorCode mErrorCode;
    private Exception innerException;

    public PersistenceException() {
        this("");
    }

    public PersistenceException(final String detailMessage) {
        super("Error instantiating a business class: " + detailMessage);
    }

    public PersistenceException(final String detailMessage, final Exception exception) {
        super("Error instantiating a business class: " + detailMessage);
        this.innerException = exception;
    }

    public Exception getInnerException() {
        return innerException;
    }

    public void setInnerException(Exception innerException) {
        this.innerException = innerException;
    }

    public PersistenceException(String errorMessage, PersistenceErrorCode errorCode) {
        super(errorMessage);
        mErrorCode = errorCode;
    }

    public PersistenceException(PersistenceErrorCode errorCode) {
        super(errorCode.name());
        mErrorCode = errorCode;
    }

    public PersistenceErrorCode getErrorCode() {
        return mErrorCode;
    }

}
