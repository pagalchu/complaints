package com.sv.complaints.es;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.sv.complaints")
public class ESConfig {

    @Bean
    public RestClient client()
    {
        RestClient restClient = RestClient.builder(
                new HttpHost("127.0.0.1", 9200, "http")).build();
        return restClient;

    }


}
