package com.qg.blog.exception.user;

/**
 * Created by hunger on 2016/10/24.
 */
public class LoginNotExitUserException extends RuntimeException {

    public LoginNotExitUserException(String message) {
        super(message);
    }

    public LoginNotExitUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
