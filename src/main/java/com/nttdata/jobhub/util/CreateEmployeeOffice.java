package com.nttdata.jobhub.util;

import com.nttdata.jobhub.model.Employee;
import com.nttdata.jobhub.model.Office;
import com.nttdata.jobhub.repository.EmployeeRepository;
import com.nttdata.jobhub.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
@Order(3)
public class CreateEmployeeOffice implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;

    @Override
    public void run(String... args) {
        Employee employee1 = employeeRepository.findById(1L).orElse(null);

        Office office1 = officeRepository.findById(1L).orElse(null);
        Office office2 = officeRepository.findById(2L).orElse(null);

        if (employee1 != null && office1 != null && office2 != null) {
            employee1.getOffices().add(office1);
            employee1.getOffices().add(office2);

            employeeRepository.save(employee1);

            log.info("Relaciones entre empleados y oficinas creadas.");
        } else {
            log.warn("No se pudieron encontrar los empleados u oficinas necesarios para crear las relaciones.");
        }
    }
}
