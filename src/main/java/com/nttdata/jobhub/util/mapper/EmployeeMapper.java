package com.nttdata.jobhub.util.mapper;

import com.nttdata.jobhub.dto.CreateEmployeeDto;
import com.nttdata.jobhub.dto.EmployeeDto;
import com.nttdata.jobhub.dto.UpdateEmployeeDto;
import com.nttdata.jobhub.model.Employee;
import org.modelmapper.ModelMapper;

import java.util.List;

public class EmployeeMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private EmployeeMapper() {
    }

    public static List<EmployeeDto> entityListToEmployeeDtoList(List<Employee> employeeList) {
        return employeeList.stream()
                .map(EmployeeMapper::entityToEmployeeDto)
                .toList();
    }

    public static EmployeeDto entityToEmployeeDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public static Employee createEmployeeToEntity(CreateEmployeeDto createEmployeeDto) {
        return modelMapper.map(createEmployeeDto, Employee.class);
    }
}
