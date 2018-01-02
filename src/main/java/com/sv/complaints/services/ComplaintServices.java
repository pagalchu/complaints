package com.sv.complaints.services;


import com.fasterxml.jackson.databind.JsonNode;
import com.sv.complaints.Utils.CommonUtils;
import com.sv.complaints.dtos.ComplaintDto;

import netscape.javascript.JSObject;
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
    public ComplaintDto createComplaint(String complaint)
    {
        try
        {
            String indexAndId = CommonUtils.getIndexInfo() + "/"+CommonUtils.getTimeInMillis();
            HttpEntity entity = new NStringEntity(complaint, ContentType.APPLICATION_JSON);
            restClient.performRequest("PUT", indexAndId, Collections.<String, String>emptyMap(), entity);
        }
        catch (Exception e)
        {
            System.out.println("failed with " +e.getMessage());
        }
        return null;
    }

   public String searchComplaint(String searchCriteria)
    {
        try
        {
            HttpEntity entity = new NStringEntity(CommonUtils.buildSearchQuery(searchCriteria));
            String info = "/complaints/_search";
            Response response = restClient.performRequest("GET",info, Collections.singletonMap("pretty", "true"), entity);
            String fullContents = EntityUtils.toString(response.getEntity());
            System.out.println(fullContents);
            JSONObject fullContentJSON = new JSONObject(fullContents);
            JSONArray hits = (fullContentJSON.getJSONObject("hits")).getJSONArray("hits");
            JSONObject finalResult = new JSONObject();
           for( int i=0; i<hits.length(); i++)
           {
               JSONObject source = (hits.optJSONObject(i)).getJSONObject("_source");
               finalResult.accumulate("finalResult",source);

           }
           return finalResult.get("finalResult").toString();

        }
        catch (Exception e)
        {
            System.out.println("failed with " +e.getMessage());
        }

        return null;
    }





}
