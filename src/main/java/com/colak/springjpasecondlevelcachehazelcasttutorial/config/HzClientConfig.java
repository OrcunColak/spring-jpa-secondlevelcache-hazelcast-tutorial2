package com.colak.springjpasecondlevelcachehazelcasttutorial.config;

import com.hazelcast.client.config.ClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HzClientConfig {

    @Bean
    public ClientConfig clientConfig() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setInstanceName("my-client");
        return clientConfig;
    }
}
