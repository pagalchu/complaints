package com.sv.complaints.services;

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
        String json = "d";
        ESDto dto = new ESDto();
        dto.setId("1234");
        dto.setCreatDate("10/23/1977");
        dto.setUser("Jay Saraswati");
        dto.setJsonObject(json);
        complaintsRepository.save(dto);
        return new ComplaintDto();

    }

    public ComplaintDto searchComplaint(String searchCriteria)
    {
        return new ComplaintDto();
    }
}
