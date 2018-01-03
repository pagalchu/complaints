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
            String token = CommonUtils.getToken();
            String indexAndId = CommonUtils.getIndexInfo() + "/"+CommonUtils.getTimeInMillis();
            HttpEntity entity = new NStringEntity(complaint, ContentType.APPLICATION_JSON);
            restClient.performRequest("PUT", indexAndId, Collections.<String, String>emptyMap(), entity);
            return token;
        }
        catch (Throwable e)
        {
            throw new ProcessingException(ResponseCodes.INTERNAL_ERROR, "error occured while performing save: "+  e.getMessage());
        }
    }

   public String searchComplaint(String searchCriteria) throws ProcessingException
    {
        try
        {
            HttpEntity entity = new NStringEntity(CommonUtils.buildSearchQuery(searchCriteria));
            Response response = restClient.performRequest("GET",CommonUtils.getSearchString(), Collections.singletonMap("pretty", "false"), entity);
            String fullContents = EntityUtils.toString(response.getEntity());
            System.out.println(fullContents);
            //convert full content to JSONObject
            JSONObject fullContentJSON = new JSONObject(fullContents);

            //from JSONObject, get inner level hits - this is format provided by ES.
            JSONArray hits = (fullContentJSON.getJSONObject("hits")).getJSONArray("hits");
            JSONObject finalResult = new JSONObject();
           for( int i=0; i<hits.length(); i++)
           {
               //loop over hits and get source. _source is the content provided by user
               JSONObject source = (hits.optJSONObject(i)).getJSONObject("_source");
               finalResult.accumulate("finalResult",source);

           }
           return finalResult.get("finalResult").toString();
        }
        catch (Throwable e)
        {
            System.out.println("failed with " +e.getMessage());
            throw new ProcessingException(ResponseCodes.INTERNAL_ERROR, "error occured while performing search: "+  e.getMessage());
        }
    }





}
