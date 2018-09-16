package com.example.lucas.deliva.business;

/**
 * BusinessException, Exception used to describe errors occurred when try to use
 * in business layer.
 */
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

    /**
     * Hold error code retrieve from web server
     */
    private final BusinessErrorCode mErrorCode;
    private final String mErrorMessage;


    /**
     * BusinessException constructor
     *
     * @param errorMessage error message retrieved from IBA server
     * @param errorCode    error code retrieved from IBA server
     */
    public BusinessException(String errorMessage, BusinessErrorCode errorCode) {
        super(errorMessage);
        mErrorCode = errorCode;
        mErrorMessage = errorMessage;
    }

    public BusinessException(BusinessErrorCode errorCode) {
        this("", errorCode);
    }

    /**
     * Retrieve the error code inside exception
     *
     * @return error code
     */
    public BusinessErrorCode getErrorCode() {
        return mErrorCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }
}