package com.nttdata.jobhub.service.impl;

import com.nttdata.jobhub.dto.CreateEmployeeDto;
import com.nttdata.jobhub.dto.EmployeeDto;
import com.nttdata.jobhub.dto.UpdateEmployeeDto;
import com.nttdata.jobhub.exception.ResourceNotFoundException;
import com.nttdata.jobhub.model.Employee;
import com.nttdata.jobhub.model.Office;
import com.nttdata.jobhub.repository.EmployeeRepository;
import com.nttdata.jobhub.repository.OfficeRepository;
import com.nttdata.jobhub.service.EmployeeService;
import com.nttdata.jobhub.util.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeMapper.entityListToEmployeeDtoList(employees);
    }

    @Override
    public EmployeeDto getById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró un empleado con el ID: " + employeeId));
        return EmployeeMapper.entityToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto create(CreateEmployeeDto createEmployeeDto) {
        return EmployeeMapper.entityToEmployeeDto(employeeRepository.save(EmployeeMapper.createEmployeeToEntity(createEmployeeDto)));
    }

    @Override
    public EmployeeDto update(Long employeeId, UpdateEmployeeDto request) {
        Optional<Employee> employeeEntity = employeeRepository.findById(employeeId);

        if (employeeEntity.isPresent()) {
            Employee employee = employeeEntity.get();

            if (request.getName() != null) {
                employee.setName(request.getName());
            }
            if (request.getPhoneNumber() != null) {
                employee.setPhoneNumber(request.getPhoneNumber());
            }
            if (request.getDni() != null) {
                employee.setDni(request.getDni());
            }
            if (request.getAddress() != null) {
                employee.setAddress(request.getAddress());
            }

            if (request.getOfficeIds() == null || request.getOfficeIds().isEmpty()) {
                employee.setOffices(Collections.emptyList());
            } else {
                if (request.isRemote()) {
                    employee.setOffices(Collections.emptyList());
                    employee.setRemote(true);
                } else {
                    List<Office> officesToLink = officeRepository.findAllById(request.getOfficeIds());
                    employee.setOffices(officesToLink);
                    employee.setRemote(false);
                }
            }

            Employee updatedEmployee = employeeRepository.save(employee);
            return EmployeeMapper.entityToEmployeeDto(updatedEmployee);
        } else {
            throw new ResourceNotFoundException("No se encontró un empleado con el ID: " + employeeId);
        }
    }

    @Override
    public EmployeeDto delete(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró un empleado con el ID: " + employeeId));
        employeeRepository.delete(employee);
        return EmployeeMapper.entityToEmployeeDto(employee);
    }
}
