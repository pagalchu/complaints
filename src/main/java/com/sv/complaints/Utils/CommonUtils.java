package com.sv.complaints.Utils;

import com.sv.complaints.exceptions.ProcessingException;
import com.sv.complaints.response.ResponseCodes;
import com.sv.complaints.response.ServiceResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CommonUtils {

    public static ServiceResponse buildServiceResponse(Object result, ServiceResponse serviceResponse) {
        ServiceResponse response = new ServiceResponse();

        // allows user to send in response without throwing exception
        if (result instanceof ResponseCodes) {
            ResponseCodes responseCodes = (ResponseCodes) result;
            response.setResponseCode(responseCodes.getCode());
            response.setResponseDescription(responseCodes.getDescription());
            response.setRetryable(responseCodes.isRetryable());

            if (serviceResponse != null) {
                response.setResult(serviceResponse.getResult());
            } else {
                response.setResult("");
            }

            return response;
        }

        // this is user populated exception
        if (result instanceof ProcessingException) {
            Object customResult = (((ProcessingException) result).getExceptionResult()) == null ? "" : (((ProcessingException) result).getExceptionResult());
            ResponseCodes responseCodeEnums = ((ProcessingException) result).getResponseEnum();
            response.setResult(customResult);
            response.setResponseCode(responseCodeEnums.getCode());
            String sAcutalErrorMsg = ((ProcessingException) result).getActualErrorMessage();
            response.setResponseDescription((null == sAcutalErrorMsg || sAcutalErrorMsg.isEmpty()) ? responseCodeEnums.getDescription() : responseCodeEnums.getDescription() + " " + sAcutalErrorMsg);
            response.setRetryable(responseCodeEnums.isRetryable());
            return response;
        }

        // this is when developer forgot to handle the exception
        if (result instanceof Throwable) {
            response.setResult("");
            response.setResponseCode(ResponseCodes.UNKNOWN_ERROR.getCode());
            response.setResponseDescription(((Throwable) result).getMessage() + " - " + ResponseCodes.UNKNOWN_ERROR.getDescription());
            response.setRetryable(false);
            return response;
        }

        // successful response
        response.setResult(result == null ? "" : result);
        response.setResponseCode(ResponseCodes.SUCCESS.getCode());
        response.setResponseDescription(ResponseCodes.SUCCESS.getDescription());
        response.setRetryable(ResponseCodes.SUCCESS.isRetryable());
        return response;

    }

    public static long getTimeInMillis()
    {
        try
        {
            Calendar cal = Calendar.getInstance();
            cal.setTimeZone(TimeZone.getTimeZone("EST"));
            return cal.getTime().getTime();
        }
        catch(Exception e)
        {
            return  System.currentTimeMillis();
        }

    }

    public static String getCurrentDateTime()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("EST"));
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
       return dateFormat.format(cal.getTime());
    }

    public static void main(String s[])
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("EST"));
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println(dateFormat.format(cal.getTime()));

    }
}
