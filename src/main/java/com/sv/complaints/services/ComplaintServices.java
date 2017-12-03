package com.sv.complaints.services;

import com.sv.complaints.Utils.CommonUtils;
import com.sv.complaints.dtos.ComplaintDto;
import com.sv.complaints.dtos.ESDto;
import com.sv.complaints.es.ComplaintsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintServices {

    @Autowired
    private ComplaintsRepository complaintsRepository;
    public ComplaintDto createComplaint(String complaint)
    {
        ESDto dto = new ESDto();
        dto.setId(""+CommonUtils.getTimeInMillis());
        dto.setCreatDate(CommonUtils.getCurrentDateTime());
        dto.setUser("Default");
        dto.setJsonObject(complaint);
        complaintsRepository.save(dto);
        return new ComplaintDto();

    }

    public ComplaintDto searchComplaint(String searchCriteria)
    {
        return new ComplaintDto();
    }


}
