package com.sv.complaints.services;

import com.sv.complaints.Utils.CommonUtils;
import com.sv.complaints.Utils.Constants;
import com.sv.complaints.dtos.ComplaintDto;
import com.sv.complaints.dtos.ESDto;
import com.sv.complaints.es.ComplaintsRepository;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    public  List<ComplaintDto> searchComplaint(String searchCriteria)
    {
        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery(searchCriteria).field(Constants.ES_FIELD_JSONOBJECT);
        Iterable<ESDto> searchList = complaintsRepository.search(queryBuilder);

        if(searchList==null)
        {
            return null;
        }

        List<ComplaintDto> complaints = new ArrayList<>();

        for (ESDto searchResult: searchList ) {
            ComplaintDto complaint = new ComplaintDto();
            complaint.setCreateDate(searchResult.getCreatDate());
            complaint.setJsonObject(searchResult.getJsonObject());
            complaints.add(complaint);
        }

        return complaints;

    }


}
