package com.hungpham.common.exception;

public class DataNotFoundException extends RuntimeException {

    private final boolean stackTraceDesired;

    public DataNotFoundException(String message, boolean stackTraceDesired) {
        super(message);
        this.stackTraceDesired = stackTraceDesired;
    }

    public boolean isStackTraceDesired() {
        return stackTraceDesired;
    }
}
