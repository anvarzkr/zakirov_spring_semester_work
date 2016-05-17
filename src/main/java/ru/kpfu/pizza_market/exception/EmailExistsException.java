package ru.kpfu.pizza_market.exception;

/**
 * Created by Anvar on 06.05.16.
 */
public class EmailExistsException extends Exception {
    public EmailExistsException(){}
    public EmailExistsException(String message){
        super(message);
    }
    public EmailExistsException(String message, Throwable cause){
        super(message, cause);
    }
}
