package com.sv.complaints.controllers;

import com.sv.complaints.Utils.CommonUtils;
import com.sv.complaints.dtos.ComplaintDto;
import com.sv.complaints.response.ServiceResponse;
import com.sv.complaints.services.ComplaintServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

@RestController
@RequestMapping("/complaint")
public class Complaint {

    @Autowired
    ComplaintServices complaintServices;

    @RequestMapping(value = "/submitComplaint", method = RequestMethod.POST)
    public ServiceResponse submitComplaint(@Context HttpServletRequest context,  @RequestBody final String complaintRequest )
    {
        ComplaintDto complaint =  complaintServices.createComplaint(complaintRequest);
        return CommonUtils.buildServiceResponse(complaint, null);
    }
    @RequestMapping(value = "/searchComplaint", method = RequestMethod.POST)
    public ServiceResponse searchComplaint(@Context HttpServletRequest context, String seachCriteria )
    {
        ComplaintDto complainSearchresult =  complaintServices.searchComplaint(seachCriteria);
        return CommonUtils.buildServiceResponse(complainSearchresult, null);
    }
}
