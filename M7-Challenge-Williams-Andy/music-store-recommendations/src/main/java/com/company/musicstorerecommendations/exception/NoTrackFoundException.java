package com.company.musicstorerecommendations.exception;

public class NoTrackFoundException extends RuntimeException {
    public NoTrackFoundException(String message) { super(message); }
    public NoTrackFoundException() {super();}
}
