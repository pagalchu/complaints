package com.sv.complaints.services;

import com.sv.complaints.dtos.ComplaintDto;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServices {

    public ComplaintDto createComplaint(String complaint)
    {
        return new ComplaintDto();

    }

    public ComplaintDto searchComplaint(String searchCriteria)
    {
        return new ComplaintDto();
    }
}
