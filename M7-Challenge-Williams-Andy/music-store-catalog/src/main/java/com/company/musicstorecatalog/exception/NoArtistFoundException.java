package com.company.musicstorecatalog.exception;

public class NoArtistFoundException extends RuntimeException {
    public NoArtistFoundException(String message) { super(message); }
    public NoArtistFoundException() {super();}
}
