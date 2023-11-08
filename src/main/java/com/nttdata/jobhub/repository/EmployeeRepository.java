package com.nttdata.jobhub.repository;

import com.nttdata.jobhub.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByDni(String dni);
}
