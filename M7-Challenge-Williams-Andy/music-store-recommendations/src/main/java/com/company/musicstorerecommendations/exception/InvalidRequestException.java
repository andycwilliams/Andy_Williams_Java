package com.company.musicstorerecommendations.exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {super (message);}
    public InvalidRequestException() {super();}
}
