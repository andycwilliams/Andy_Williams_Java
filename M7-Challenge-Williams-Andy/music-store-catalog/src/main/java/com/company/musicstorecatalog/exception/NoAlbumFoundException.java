package com.company.musicstorecatalog.exception;

public class NoAlbumFoundException extends RuntimeException {
    public NoAlbumFoundException(String message) { super(message); }
    public NoAlbumFoundException() {super();}
}
