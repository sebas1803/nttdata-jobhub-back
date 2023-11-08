package com.nttdata.jobhub.security;

import com.nttdata.jobhub.model.Employee;
import com.nttdata.jobhub.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public CustomUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByDni(dni);

        if (employee == null) {
            throw new UsernameNotFoundException("User not found with DNI: " + dni);
        }

        return new CustomUserDetails(employee);
    }
}
