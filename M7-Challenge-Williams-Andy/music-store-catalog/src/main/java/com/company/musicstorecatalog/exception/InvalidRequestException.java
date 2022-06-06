package com.company.musicstorecatalog.exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {super (message);}
    public InvalidRequestException() {super();}
}
