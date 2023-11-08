package com.nttdata.jobhub.service;

import com.nttdata.jobhub.dto.CreateEmployeeDto;
import com.nttdata.jobhub.dto.EmployeeDto;
import com.nttdata.jobhub.dto.UpdateEmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAll();
    EmployeeDto getById(Long employeeId);
    EmployeeDto create(CreateEmployeeDto createEmployeeDto);
    EmployeeDto update(Long employeeId, UpdateEmployeeDto updateEmployeeDto);
    EmployeeDto delete(Long employeeId);
}
