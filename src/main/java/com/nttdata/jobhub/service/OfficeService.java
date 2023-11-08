package com.nttdata.jobhub.service;

import com.nttdata.jobhub.dto.CreateOfficeDto;
import com.nttdata.jobhub.dto.OfficeDto;

import java.util.List;

public interface OfficeService {
    List<OfficeDto> getAll();
    OfficeDto create(CreateOfficeDto createOfficeDto);

}
