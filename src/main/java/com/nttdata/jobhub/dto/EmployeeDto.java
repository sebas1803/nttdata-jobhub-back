package com.nttdata.jobhub.dto;

import com.nttdata.jobhub.model.Office;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private String dni;
    private String address;
    private String birthdate;
    private boolean isRemote;
    private List<Office> offices;
}