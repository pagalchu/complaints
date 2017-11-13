package com.sv.complaints.exceptions;

import com.sv.complaints.response.ResponseCodes;

/**
 * Created Sunny
 */
public class ProcessingException extends Exception
{
    private ResponseCodes responseEnum;
    private String actualErrorMessage = "";
    private Object exceptionResult;

    private static final long serialVersionUID = -3103857515154217668L;

    public ProcessingException(ResponseCodes response)
    {
        super(response.getDescription());
        this.responseEnum = response;
    }

    public ProcessingException(ResponseCodes response, Object exceptionResult)
    {
        super(response.getDescription());
        this.responseEnum = response;
        this.exceptionResult = exceptionResult;
    }

    public ProcessingException(ResponseCodes response, String actualErrorMessage, Throwable cause)
    {
        super(actualErrorMessage, cause);
        this.actualErrorMessage = actualErrorMessage;
        this.responseEnum = response;
    }

    public ProcessingException(ResponseCodes response, String actualErrorMessage)
    {
        super(actualErrorMessage);
        this.actualErrorMessage = actualErrorMessage;
        this.responseEnum = response;
    }

    public ResponseCodes getResponseEnum()
    {
        return responseEnum;
    }

    public String getActualErrorMessage()
    {
        return actualErrorMessage;
    }

    public Object getExceptionResult()
    {
        return exceptionResult;
    }

}
