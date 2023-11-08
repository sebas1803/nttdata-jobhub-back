package com.nttdata.jobhub.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class UpdateEmployeeDto {
    private String name;
    private String phoneNumber;
    private String dni;
    private String address;
    private boolean isRemote;
    private List<Long> offices;
}
