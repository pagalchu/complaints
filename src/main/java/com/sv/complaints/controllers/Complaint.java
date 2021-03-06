package com.sv.complaints.controllers;

import com.sv.complaints.Utils.CommonUtils;
import com.sv.complaints.Utils.Email;
import com.sv.complaints.exceptions.ProcessingException;
import com.sv.complaints.response.ResponseCodes;
import com.sv.complaints.response.ServiceResponse;
import com.sv.complaints.services.ComplaintServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.List;

@RestController
@RequestMapping("/complaint")
public class Complaint {

    @Autowired
    ComplaintServices complaintServices;

    @RequestMapping(value = "/submitComplaint", method = RequestMethod.POST)
    public ServiceResponse submitComplaint(@Context HttpServletRequest context,  @RequestBody final String complaintRequest )
    {
        try
        {
            if(complaintRequest==null || complaintRequest.trim().length()<80)
            {
                return CommonUtils.buildServiceResponse(ResponseCodes.INVALID_REQUEST, null);
            }
            String token =  complaintServices.createComplaint(complaintRequest);
            return CommonUtils.buildServiceResponse(token, null);
        }
        catch(ProcessingException e)
        {
            System.out.println("=== compaint exception ==="+e.getMessage());
            Email.sendEmail(e.getMessage() +"--->"+ complaintRequest);
            return CommonUtils.buildServiceResponse(e, null);
        }

    }
    @RequestMapping(value = "/searchByKeywords", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponse searchByKeywords(@Context HttpServletRequest context,  @RequestBody final String keywords )
    {
        try
        {
            if(keywords==null || keywords.trim().length()<4)
            {
                return CommonUtils.buildServiceResponse(ResponseCodes.NOT_ENOUGH_SEARCH_CRITERIA, null);
            }
            String complainSearchResult =  complaintServices.searchComplaint(keywords);
            return CommonUtils.buildServiceResponse(complainSearchResult, null);
        }
        catch(ProcessingException e)
        {
            System.out.println("=== compaint exception ==="+e.getMessage());
            Email.sendEmail(e.getMessage() +"--->"+ keywords);
            return CommonUtils.buildServiceResponse(e, null);
        }
    }

    @RequestMapping(value = "/submitContactUs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponse submitContactUs(@Context HttpServletRequest context,  @RequestBody final String contactUs )
    {
        try
        {
            if(contactUs==null || contactUs.trim().length()<10)
            {
                return CommonUtils.buildServiceResponse(ResponseCodes.INVALID_REQUEST, null);
            }
            complaintServices.submitContactUs(contactUs);
            return CommonUtils.buildServiceResponse("success", null);
        }
        catch(ProcessingException e)
        {
            System.out.println("=== submitContactUs exception ==="+e.getMessage());
            Email.sendEmail(e.getMessage()+"--->"+contactUs);
            return CommonUtils.buildServiceResponse(e, null);
        }

    }

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponse sendEMail(@Context HttpServletRequest context,  @RequestBody final String emailBody ) {
        Email.sendEmail(emailBody);
        return CommonUtils.buildServiceResponse("success", null);
    }
}
