package com.sv.complaints.es;

import com.sv.complaints.dtos.ESDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ComplaintsRepository extends ElasticsearchRepository<ESDto, String> {

}
