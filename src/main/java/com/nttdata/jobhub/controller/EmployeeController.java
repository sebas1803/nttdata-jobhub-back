package com.nttdata.jobhub.controller;

import com.nttdata.jobhub.dto.CreateEmployeeDto;
import com.nttdata.jobhub.dto.EmployeeDto;
import com.nttdata.jobhub.dto.UpdateEmployeeDto;
import com.nttdata.jobhub.model.Employee;
import com.nttdata.jobhub.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Employee", description = "Endpoints for employee management")
@RequestMapping("api/v1/employees")
@SecurityRequirement(name = "bearerAuth")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Get all employees", description = "Retrieve a list of all registered employees.")
    @ApiResponse(responseCode = "200", description = "List of employees successfully retrieved.", content = @Content)
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeList = employeeService.getAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @Operation(summary = "Get employee by ID", description = "Retrieve a specific employee by their ID.")
    @ApiResponse(responseCode = "200", description = "Employee successfully retrieved.")
    @ApiResponse(responseCode = "404", description = "Employee with the given ID not found.")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employee = employeeService.getById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @Operation(summary = "Create a new employee", description = "Create a new employee with the provided data in the request body.")
    @ApiResponse(responseCode = "201", description = "Employee successfully created.")
    @ApiResponse(responseCode = "400", description = "Invalid request data.")
    @PostMapping
    public ResponseEntity<Void> createEmployee(@RequestBody CreateEmployeeDto createEmployeeDTO) {
        employeeService.create(createEmployeeDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Update employee by ID", description = "Update the data of a specific employee by their ID.")
    @ApiResponse(responseCode = "200", description = "Employee successfully updated.")
    @ApiResponse(responseCode = "404", description = "Employee with the given ID not found.")
    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeDto updateEmployeeDto) {
        EmployeeDto updatedEmployee = employeeService.update(id, updateEmployeeDto);
        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEmployee);
    }

    @Operation(summary = "Delete employee by ID", description = "Delete a specific employee by their ID.")
    @ApiResponse(responseCode = "204", description = "Employee successfully deleted.")
    @ApiResponse(responseCode = "404", description = "Employee with the given ID not found.")
    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable Long id) {
        EmployeeDto employee = employeeService.delete(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }
}
