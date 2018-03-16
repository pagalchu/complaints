package com.sv.complaints.services;

import com.sv.complaints.Utils.CommonUtils;

import com.sv.complaints.exceptions.ProcessingException;
import com.sv.complaints.response.ResponseCodes;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ComplaintServices {

    @Autowired
    private RestClient restClient;
    public String createComplaint(String complaint) throws ProcessingException
    {
        try
        {
            JSONObject jsonComplaint = new JSONObject(complaint);
            String token = CommonUtils.getToken();
            CommonUtils.appendHeaderDetails(jsonComplaint, token);
            String indexAndId = CommonUtils.getIndexInfo() + "/"+CommonUtils.getTimeInMillis();
            HttpEntity entity = new NStringEntity(jsonComplaint.toString(), ContentType.APPLICATION_JSON);
            restClient.performRequest("PUT", indexAndId, Collections.<String, String>emptyMap(), entity);
            System.out.println("=== complaint created ===" +token);
            return token;
        }
        catch (Throwable e)
        {
            System.out.println("=== failure ===" +e.getMessage() +" date:" +CommonUtils.getCurrentDateTime() +" complaint object is: "+ complaint);
            throw new ProcessingException(ResponseCodes.INTERNAL_ERROR, "error occured while performing save: "+  e.getMessage());
        }
    }

   public String searchComplaint(String searchCriteria) throws ProcessingException
    {
        try
        {
            String searchQuery = CommonUtils.buildSearchQuery(searchCriteria);
            HttpEntity entity = new NStringEntity(searchQuery, ContentType.APPLICATION_JSON);
            String searchString = CommonUtils.getSearchString();
            Response response = restClient.performRequest("POST",searchString, Collections.singletonMap("pretty", "false"), entity);
            String fullContents = EntityUtils.toString(response.getEntity());
            JSONObject fullContentJSON = new JSONObject(fullContents);

            //from JSONObject, get inner level hits - this is format provided by ES.
            JSONArray hits = (fullContentJSON.getJSONObject("hits")).getJSONArray("hits");
            JSONObject finalResult = new JSONObject();
            System.out.println(hits.length());
           for( int i=0; i<hits.length(); i++)
           {
               //loop over hits and get source. _source is the content provided by user
               JSONObject source = (hits.optJSONObject(i)).getJSONObject("_source");
               //clean up data
               CommonUtils.cleanUpData(source);
               finalResult.accumulate("finalResult",source);

           }
           //if no results found, return empty set
           if(finalResult.length()==0)
           {
               return finalResult.toString();
           }
           return finalResult.get("finalResult").toString();

        }
        catch (Throwable e)
        {
            System.out.println("===failed with "+" date:" +CommonUtils.getCurrentDateTime() +"exception is: " +e.getMessage());
            throw new ProcessingException(ResponseCodes.INTERNAL_ERROR, "error occured while performing search: "+  e.getMessage());
        }
    }





}
