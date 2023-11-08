package com.nttdata.jobhub.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.nttdata.jobhub.dto.CreateEmployeeDto;
import com.nttdata.jobhub.dto.EmployeeDto;
import com.nttdata.jobhub.dto.UpdateEmployeeDto;
import com.nttdata.jobhub.model.Employee;
import com.nttdata.jobhub.repository.EmployeeRepository;
import com.nttdata.jobhub.repository.OfficeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private OfficeRepository officeRepository;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeServiceImpl(employeeRepository, officeRepository);
    }

    @Test
    public void testGetAllEmployees() {
        // Given
        List<Employee> mockEmployees = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setName("John Doe");
        employee1.setPhoneNumber("123-456-7890");
        employee1.setDni("ABC123456");
        employee1.setPassword("secretpassword");
        employee1.setAddress("123 Main St");
        employee1.setBirthdate("1990-01-01");
        employee1.setRemote(false);
        mockEmployees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setId(2L);
        employee2.setName("John Doe");
        employee2.setPhoneNumber("123-456-7890");
        employee2.setDni("ABC123456");
        employee2.setPassword("secretpassword");
        employee2.setAddress("123 Main St");
        employee2.setBirthdate("1990-01-01");
        employee2.setRemote(false);
        mockEmployees.add(employee2);

        when(employeeRepository.findAll()).thenReturn(mockEmployees);

        // When
        List<EmployeeDto> result = employeeService.getAll();

        // Then
        assertEquals(mockEmployees.size(), result.size());
    }

    @Test
    public void testGetEmployeeById() {
        Long employeeId = 1L;
        Employee mockEmployee = new Employee();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(mockEmployee));

        EmployeeDto result = employeeService.getById(employeeId);

        assertNotNull(result);
    }

    @Test
    public void testCreateEmployee() {
        CreateEmployeeDto createEmployeeDto = new CreateEmployeeDto();
        Employee mockEmployee = new Employee();

        when(employeeRepository.save(any(Employee.class))).thenReturn(mockEmployee);

        EmployeeDto result = employeeService.create(createEmployeeDto);

        assertNotNull(result);
    }

    @Test
    public void testUpdateEmployee() {
        Long employeeId = 1L;
        UpdateEmployeeDto updateEmployeeDto = new UpdateEmployeeDto();
        Employee mockEmployee = new Employee();

        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(mockEmployee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(mockEmployee);

        EmployeeDto result = employeeService.update(employeeId, updateEmployeeDto);

        assertNotNull(result);
    }

    @Test
    public void testDeleteEmployee() {
        Long employeeId = 1L;
        Employee mockEmployee = new Employee();

        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(mockEmployee));

        EmployeeDto result = employeeService.delete(employeeId);

        assertNotNull(result);
    }
}
