package com.ibs.service.dto.mapper;


import com.ibs.service.dto.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    Employee toDto(com.ibs.service.domain.entity.Employee employee);

}
