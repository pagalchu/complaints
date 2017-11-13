package com.sv.complaints.response;

/**
 *
 */
public enum ResponseCodes {


    SUCCESS(0, "Request was processed successfully", false),
    UNKNOWN_ERROR(101, "Unknown Error", true),
    DATABASE_ERROR(102, "Database Error", true),
    INTERNAL_ERROR(103, "Internal Error", true);


    private int code;
    private String description;
    private boolean isRetryable = false;

    ResponseCodes(int code, String description, boolean isRetryable) {
        this.code = code;
        this.description = description;
        this.isRetryable = isRetryable;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRetryable() {
        return this.isRetryable;
    }
}
