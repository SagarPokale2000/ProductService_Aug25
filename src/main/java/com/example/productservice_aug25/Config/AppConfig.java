package com.example.productservice_aug25.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //spring will create object
public class AppConfig {

    @Bean //Special method spring will automatically call this
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
