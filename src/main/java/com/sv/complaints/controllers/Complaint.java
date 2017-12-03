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
import java.util.List;

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
    @RequestMapping(value = "/searchByKeywords", method = RequestMethod.POST)
    public ServiceResponse searchByKeywords(@Context HttpServletRequest context,  @RequestBody final String keywords )
    {
        List<ComplaintDto> complainSearchResult =  complaintServices.searchComplaint(keywords);
        return CommonUtils.buildServiceResponse(complainSearchResult, null);
    }
}
