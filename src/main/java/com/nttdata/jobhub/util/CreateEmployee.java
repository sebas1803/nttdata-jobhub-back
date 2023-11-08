package com.nttdata.jobhub.util;

import com.nttdata.jobhub.model.Employee;
import com.nttdata.jobhub.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@Order(2)
public class CreateEmployee implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (employeeRepository.count() == 0) {
            List<Employee> employees = new ArrayList<>();

            Employee employee1 = new Employee();
            employee1.setName("Pedro Suarez Fernandez");
            employee1.setDni("12345678");
            String hashedPassword1 = passwordEncoder.encode("contra1");
            employee1.setPassword(hashedPassword1);
            employee1.setAddress("Avenida La Mar 432");
            employee1.setBirthdate("2001-05-25");
            employee1.setPhoneNumber("987654321");
            employee1.setRemote(false);

            Employee employee2 = new Employee();
            employee2.setName("Jimena Marquez Durango");
            employee2.setDni("78956123");
            String hashedPassword2 = passwordEncoder.encode("contra2");
            employee2.setPassword(hashedPassword2);
            employee2.setAddress("Jr. Huaricacha 123");
            employee2.setBirthdate("2000-06-24");
            employee2.setPhoneNumber("954231678");
            employee2.setRemote(true);

            Employee employee3 = new Employee();
            employee3.setName("Sebastian Alfaro Mendoza");
            employee3.setDni("65483198");
            String hashedPassword3 = passwordEncoder.encode("contra3");
            employee3.setPassword(hashedPassword3);
            employee3.setAddress("Avenida El Sol 2410");
            employee3.setBirthdate("2005-01-27");
            employee3.setPhoneNumber("965482361");
            employee3.setRemote(false);

            Employee employee4 = new Employee();
            employee4.setName("Jose de la Cruz Melo");
            employee4.setDni("65455521");
            String hashedPassword4 = passwordEncoder.encode("contra4");
            employee4.setPassword(hashedPassword4);
            employee4.setAddress("Avenida Salaverry 2294");
            employee4.setBirthdate("1999-09-01");
            employee4.setPhoneNumber("951362478");
            employee4.setRemote(false);

            Employee employee5 = new Employee();
            employee5.setName("Lorenzo Mendoza Lozano");
            employee5.setDni("78562211");
            String hashedPassword5 = passwordEncoder.encode("contra5");
            employee5.setPassword(hashedPassword5);
            employee5.setAddress("Calle San Juan 123");
            employee5.setBirthdate("1994-08-12");
            employee5.setPhoneNumber("963852741");
            employee5.setRemote(false);

            Employee employee6 = new Employee();
            employee6.setName("Ariel Palma Reategui");
            employee6.setDni("23239898");
            String hashedPassword6 = passwordEncoder.encode("contra6");
            employee6.setPassword(hashedPassword6);
            employee6.setAddress("Jiron Arcoiris 942");
            employee6.setBirthdate("1984-05-15");
            employee6.setPhoneNumber("963258741");
            employee6.setRemote(false);

            employees.add(employee1);
            employees.add(employee2);
            employees.add(employee3);
            employees.add(employee4);
            employees.add(employee5);
            employees.add(employee6);

            employeeRepository.saveAll(employees);
        } else {
            log.info("Empleados ya creados");
        }
    }
}
