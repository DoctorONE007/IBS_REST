package com.ibs.service.config;

import com.ibs.service.business.GreetingsService;
import com.ibs.service.business.GreetingsServiceImpl;
import com.ibs.service.business.GreetingsServiceImpl2;
import com.ibs.service.domain.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class GreetingsServiceConfig {

    @Bean
    @Profile("!test")
    GreetingsService getGSImpl() {
        return new GreetingsServiceImpl(log);
    }

    @Bean
    @Profile("test")
    GreetingsService getGSImpl2() {
        return new GreetingsServiceImpl2(log);
    }

    @Bean
    Employee makeDefEmployee() {
        return new Employee(null, "Andy", null, null, null, null, null);
    }


}
