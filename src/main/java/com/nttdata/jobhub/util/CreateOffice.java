package com.nttdata.jobhub.util;

import com.nttdata.jobhub.model.Office;
import com.nttdata.jobhub.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@Order(1)
public class CreateOffice implements CommandLineRunner {
    private final OfficeRepository officeRepository;

    @Override
    public void run(String... args) {
        if (officeRepository.count() == 0) {
            List<Office> offices = new ArrayList<>();
            offices.add(new Office("Sede Miraflores"));
            offices.add(new Office("Sede San Isidro"));
            offices.add(new Office("Sede Surco"));
            offices.add(new Office("Sede Chorrillos"));

            officeRepository.saveAll(offices);
        } else {
            log.info("Oficinas ya creadas");
        }
    }
}