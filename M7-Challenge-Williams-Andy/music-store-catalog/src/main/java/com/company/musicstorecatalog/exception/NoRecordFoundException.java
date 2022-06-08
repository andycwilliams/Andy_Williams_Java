package com.company.musicstorecatalog.exception;

public class NoRecordFoundException extends RuntimeException {
    public NoRecordFoundException(String message) { super(message); }
    public NoRecordFoundException() {super();}
}
