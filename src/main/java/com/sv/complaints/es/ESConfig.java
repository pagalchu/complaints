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
        System.out.println("=== start es===");
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http")).build();
        System.out.println("=== end es===");
        return restClient;

    }


}
