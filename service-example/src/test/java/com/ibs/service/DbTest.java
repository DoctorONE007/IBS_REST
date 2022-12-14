package com.ibs.service;

import com.ibs.service.domain.EmployeeRepository;
import com.ibs.service.domain.entity.Course;
import com.ibs.service.domain.entity.Department;
import com.ibs.service.domain.entity.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
//@ActiveProfiles("test")
class DbTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setup() {
        Department department = new Department(null, "IT");
        Course course = new Course(null, "REST service");
        Employee emp = new Employee(null,"a","b", LocalDate.now(),department, 400000, List.of(course));

        em.persist(department);
        em.persist(course);
        em.persist(emp);
    }

    @Test
    void test() {
        Assert.assertEquals(1, em.createQuery("FROM Department").getResultList().size());
        Employee emp = em.createQuery("FROM Employee", Employee.class).setMaxResults(1).getResultList().get(0);
        Assert.assertEquals("REST service",emp.getCourses().get(0).getName());
    }
    @Test
    void test2(){
       Employee emp = employeeRepository.findAllByFirstName("a").get(0);
        Assert.assertEquals("REST service",emp.getCourses().get(0).getName());
    }
}
