package com.survey.clientsurvey.security.util;




public class InvalidTokenException extends IllegalArgumentException {

    public InvalidTokenException(String s) {
        super(s);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
