package com.company.MonthAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;

// THIS WILL WORK FOREVER, at least when it comes to this Boot Camp
public class CustomErrorResponse {
    // Custom error that we report to the user

    private String errorMsg;
    private int status;
    private String errorCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    // Tells the Jackson mapper that when it maps the thing to JSON, make it look like this

    public CustomErrorResponse(HttpStatus httpStatus, String errorMsg) {
        // Notice we don't have httpStatus above, but it has some of the things we want in here
        this.errorMsg = errorMsg;
        this.status = httpStatus.value();
        this.errorCode = httpStatus.getReasonPhrase();
        this.timestamp = LocalDateTime.now();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomErrorResponse that = (CustomErrorResponse) o;
        return status == that.status && Objects.equals(errorMsg, that.errorMsg) && Objects.equals(errorCode, that.errorCode) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMsg, status, errorCode, timestamp);
    }

    @Override
    public String toString() {
        return "CustomErrorResponse{" +
                "errorMsg='" + errorMsg + '\'' +
                ", status=" + status +
                ", errorCode='" + errorCode + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
