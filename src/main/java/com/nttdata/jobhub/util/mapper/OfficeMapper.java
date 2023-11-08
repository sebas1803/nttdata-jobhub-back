package com.nttdata.jobhub.util.mapper;

import com.nttdata.jobhub.dto.CreateOfficeDto;
import com.nttdata.jobhub.dto.OfficeDto;
import com.nttdata.jobhub.model.Office;
import org.modelmapper.ModelMapper;

import java.util.List;

public class OfficeMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private OfficeMapper() {
    }

    public static List<OfficeDto> entityListToOfficeDtoList(List<Office> officeList) {
        return officeList.stream()
                .map(OfficeMapper::entityToOfficeDto)
                .toList();
    }

    public static OfficeDto entityToOfficeDto(Office office) {
        return modelMapper.map(office, OfficeDto.class);
    }

    public static Office createOfficeToEntity(CreateOfficeDto createOfficeDto) {
        return modelMapper.map(createOfficeDto, Office.class);
    }
}