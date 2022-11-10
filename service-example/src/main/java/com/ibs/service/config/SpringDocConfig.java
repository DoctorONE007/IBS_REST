package com.ibs.service.config;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public GroupedOpenApi apiV1(){
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/v1/**")
                .packagesToScan("com.ibs.service.rest.v1")
                .build();
    }

    @Bean
    public GroupedOpenApi apiV2(){
        return GroupedOpenApi.builder()
                .group("v2")
                .pathsToMatch("/v2/**")
                .packagesToScan("com.ibs.service.rest.v2")
                .build();
    }
}
