package com.ibs.service.business;

import com.ibs.service.domain.EmployeeRepository;
import com.ibs.service.dto.Employee;
import com.ibs.service.dto.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BossService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeMapper mapper;

    public List<Optional<Employee>> findAllByBossId(Long id) {
        List<com.ibs.service.domain.entity.Employee> employees = repository.findAllByBossId(id);
        return employees.stream().map(employee -> Optional.of(mapper.toDto(employee))).toList();
    }

    public Optional<com.ibs.service.dto.Employee> getBossById(@PathVariable Long id) {
        return Optional.ofNullable(mapper.toDto(repository.findById(id).get().getBoss()));
    }
}
