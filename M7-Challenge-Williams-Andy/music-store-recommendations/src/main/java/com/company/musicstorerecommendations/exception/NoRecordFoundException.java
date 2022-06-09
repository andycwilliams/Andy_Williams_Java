package com.company.musicstorerecommendations.exception;

public class NoRecordFoundException extends RuntimeException {
    public NoRecordFoundException(String message) { super(message); }
    public NoRecordFoundException() {super();}

//    public NoAlbumFoundException(String message) { super(message); }
//    public NoAlbumFoundException() {super();}
//
//    public NoArtistFoundException(String message) { super(message); }
//    public NoArtistFoundException() {super();}
//
//    public NoLabelFoundException(String message) { super(message); }
//    public NoLabelFoundException() {super();}
//
//    public NoTrackFoundException(String message) { super(message); }
//    public NoTrackFoundException() {super();}

    // Can consolidate in several ways
    // 1. One exception with fields in it with each entity (e.g. not found, set thing kind of thing I could find (like album))
    // 2. Four separate exceptions that inherit from one kind of exception. So you can have one exception handler
}
