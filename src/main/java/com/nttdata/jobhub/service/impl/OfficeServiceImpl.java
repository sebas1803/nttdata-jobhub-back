package com.nttdata.jobhub.service.impl;

import com.nttdata.jobhub.dto.CreateOfficeDto;
import com.nttdata.jobhub.dto.OfficeDto;
import com.nttdata.jobhub.model.Office;
import com.nttdata.jobhub.repository.OfficeRepository;
import com.nttdata.jobhub.service.OfficeService;
import com.nttdata.jobhub.util.mapper.OfficeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    @Override
    public List<OfficeDto> getAll() {
        List<Office> offices = officeRepository.findAll();
        return OfficeMapper.entityListToOfficeDtoList(offices);
    }

    @Override
    public OfficeDto create(CreateOfficeDto createOfficeDto) {
        return OfficeMapper.entityToOfficeDto(officeRepository.save(OfficeMapper.createOfficeToEntity(createOfficeDto)));
    }
}
