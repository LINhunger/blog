package com.qg.blog.exception.user;

/**
 * Created by hunger on 2016/10/21.
 */
public class UserException extends  RuntimeException{

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
