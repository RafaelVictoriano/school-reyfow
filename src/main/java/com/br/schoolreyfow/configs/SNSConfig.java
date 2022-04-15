package com.br.schoolreyfow.configs;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SNSConfig {

    @Bean
    public AmazonSNSClient getAmazonSnsClient() {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard().build();
    }

}
