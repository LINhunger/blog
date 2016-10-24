package com.qg.blog.exception.user;

/**
 * Created by hunger on 2016/10/21.
 */
public class SendFormatterException extends  UserException{
    public SendFormatterException(String message) {
        super(message);
    }

    public SendFormatterException(String message, Throwable cause) {
        super(message, cause);
    }
}
