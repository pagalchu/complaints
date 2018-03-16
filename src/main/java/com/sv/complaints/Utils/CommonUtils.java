package com.sv.complaints.Utils;

import com.sv.complaints.exceptions.ProcessingException;
import com.sv.complaints.response.ResponseCodes;
import com.sv.complaints.response.ServiceResponse;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class CommonUtils {


    //header related constants
    public static final String tokenKey = "token";
    public static final String createts = "createts";

    //reports
    public static final String reportsTypePath = "/complaints/reports";
    public static final String reportsTypeSearchPath = "/complaints/reports/_search";

    //contacts form
    public static final String contactsTypePath = "/complaints/contacts";


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
            System.out.println("=== failure in getTimeInMillis() ===" +e.getMessage());
            return  System.currentTimeMillis();
        }

    }

    public static String getCurrentDateTime()
    {
        try
        {
            Calendar cal = Calendar.getInstance();
            cal.setTimeZone(TimeZone.getTimeZone("EST"));
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            return dateFormat.format(cal.getTime());
        }
        catch(Exception e)
        {
            System.out.println("=== failure in getCurrentDateTime() ===" +e.getMessage());
            return "";
        }
    }
    public static String getReportsTypePath()
    {
        return reportsTypePath;
    }

    public static String getReportsSearchPath()
    {
        return reportsTypeSearchPath;
    }

    public static String getContactsTypePath()
    {
        return contactsTypePath;
    }

    public static String buildSearchQuery(String searchword)
    {
        String query =  "{\n" +
                "    \"query\": {\n" +
                "        \"query_string\": {\n" +
                "            \"query\": \"mendpara1023\",\n" +
                "            \"fields\": [\"desc\"]\n" +
                "        }\n" +
                "    },\n" +
                "\"size\":100\n" +
                "}";
        return query.replace("mendpara1023", searchword );
    }

    static public String getToken() {
        String CharSet = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        char randomChar=' ';

        String randomNumber;
        SecureRandom rand = new SecureRandom();
        try {
            randomChar = CharSet.charAt(new Random().nextInt(CharSet.length()));
            randomNumber =  ""+((rand.nextInt(49000) + rand.nextInt(49000)) + 2000);
        } catch (Throwable t) {
            System.out.println("=== failure in getToken() ===" +t.getMessage());
            randomNumber=  ""+rand.nextInt(1000);
        }

        return randomChar+randomNumber;
    }

    public static void appendHeaderDetails(JSONObject complaint, String tokenValue)
    {
        try
        {
            complaint.put(createts, ""+ getCurrentDateTime());
            complaint.put(tokenKey, tokenValue);
        }
        catch(Exception e)
        {
            System.out.println("=== failure in appendHeaderDetails() ===" +e.getMessage());
        }


    }

    public static void cleanUpData(JSONObject source)
    {
        if(source ==null)
        {
            return;
        }

       source.remove(tokenKey);

    }

  /* public static void main(String s[])
    {
        for (int i=9; i<50;i++)
        System.out.println(getToken());

    }*/

}
