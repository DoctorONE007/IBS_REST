package com.ibs.service.business;

import com.ibs.service.domain.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class GreetingsServiceImplTest {

    @Autowired
    GreetingsService gs;

    @Autowired
    Employee employee;

    @Test
    void sayHello() {
        gs.sayHello(employee);
    }
}