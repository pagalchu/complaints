package com.sv.complaints.es;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetSocketAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.sv.complaints.es")
@ComponentScan("com.sv.complaints")
public class ESConfig {

    @Bean
    public Client client()
    {
        Client esClient = null;
        String esClusterName = "elasticsearch";
        String esHost = "35.185.121.190";
        int esPort = 9300;

        Settings esSettings = Settings.settingsBuilder()
                .put("cluster.name", esClusterName)
                .put("client.transport.ignore_cluster_name", true)
                .build();


            esClient = (TransportClient.builder().settings(esSettings).build()).addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(esHost, esPort)));

        return esClient;

    }


}
