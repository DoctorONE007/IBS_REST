package com.ibs.service.business;

import com.ibs.service.domain.DepartmentRepository;
import com.ibs.service.domain.EmployeeRepository;
import com.ibs.service.domain.entity.Department;
import com.ibs.service.domain.entity.Employee;
import com.ibs.service.dto.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private BossService bossService;

    public Optional<com.ibs.service.dto.Employee> maxSalaryEmployeeInDepartment(Long departmentId) {
        Optional<Department> departmentOpt = repository.findById(departmentId);
        if (departmentOpt.isEmpty() || departmentOpt.get().getEmployees().isEmpty()) {
            return Optional.empty();
        }
        Employee employee = departmentOpt.get().getEmployees().stream()
                .max(Comparator.comparing(Employee::getMonthSalary)).get();

        return Optional.of(mapper.toDto(employee));

    }

    public Optional<List<com.ibs.service.dto.Employee>> employeesHigherSalaryThanBoss() {
        List<com.ibs.service.dto.Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> bossService.getBossById(employee.getId()).ifPresentOrElse(value -> {
            if (employee.getMonthSalary() > value.getMonthSalary())
                employeeList.add(mapper.toDto(employee));
        }, () -> employeeList.add(mapper.toDto(employee))));
        return Optional.of(employeeList);
    }

}
