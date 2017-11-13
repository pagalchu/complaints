package com.sv.complaints.response;

public class ServiceResponse {

    private int responseCode = 0;
    private String responseDescription = "";
    private boolean  isRetryable = false;
    private Object result;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isRetryable() {
        return isRetryable;
    }

    public void setRetryable(boolean retryable) {
        isRetryable = retryable;
    }
}
