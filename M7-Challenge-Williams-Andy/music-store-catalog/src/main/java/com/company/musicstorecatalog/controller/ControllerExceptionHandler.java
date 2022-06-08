package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.exception.*;
import com.company.musicstorecatalog.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseEntity<CustomErrorResponse> handleInvalidRequest(InvalidRequestException e) {
        CustomErrorResponse error = new CustomErrorResponse(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value= NoRecordFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleNoRecordFound(NoRecordFoundException e) {
        CustomErrorResponse error = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value= NoAlbumFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleNoAlbumFound(NoAlbumFoundException e) {
        CustomErrorResponse error = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value= NoArtistFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleNoArtistFound(NoArtistFoundException e) {
        CustomErrorResponse error = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
    @ExceptionHandler(value= NoLabelFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleNoLabelFound(NoLabelFoundException e) {
        CustomErrorResponse error = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value= NoTrackFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleNoTrackFound(NoTrackFoundException e) {
        CustomErrorResponse error = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        ResponseEntity<CustomErrorResponse> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    // java.sql.SQLIntegrityConstraintViolationException: Column 'album_id' cannot be null
    // Return 422
}
