package com.ibs.service.business;

import com.ibs.service.domain.entity.Employee;
import org.slf4j.Logger;

public class GreetingsServiceImpl implements GreetingsService {

    private final Logger log;

    public GreetingsServiceImpl(Logger log) {
        this.log = log;
    }

    @Override
    public void sayHello(Employee employee) {
        log.info("Hello " + employee);
    }
}
