package com.hungpham.dtos;
import com.hungpham.common.enums.ErrorCode;

public class ErrorMessageResponseDto {
    private ErrorCode errorCode;
    private String message;
    private long timestamp;
    public ErrorMessageResponseDto(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
