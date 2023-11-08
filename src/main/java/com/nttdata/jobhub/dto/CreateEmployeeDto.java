package com.nttdata.jobhub.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateEmployeeDto {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^(\\+\\d{1,3}[- .]*)?\\d{6,14}$", message = "Invalid phone number format")
    private String phoneNumber;

    @NotBlank(message = "DNI is required")
    @Pattern(regexp = "^[0-9]{7,8}$", message = "Invalid DNI format")
    private String dni;

    @NotBlank(message = "Address is required")
    @Size(min = 10, max = 200, message = "Address must be between 10 and 200 characters")
    private String address;

    @NotBlank(message = "Birthdate is required")
    private String birthdate;
}
