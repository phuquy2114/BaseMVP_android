package com.kasoft.androidbase.exceptions;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public class ServerException extends Throwable {

    private int statusCode;
    private String message;

    public ServerException(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
