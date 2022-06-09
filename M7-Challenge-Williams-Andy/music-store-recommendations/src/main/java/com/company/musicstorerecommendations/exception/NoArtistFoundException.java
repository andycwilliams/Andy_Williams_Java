package com.company.musicstorerecommendations.exception;

public class NoArtistFoundException extends RuntimeException {
    public NoArtistFoundException(String message) { super(message); }
    public NoArtistFoundException() {super();}
}
