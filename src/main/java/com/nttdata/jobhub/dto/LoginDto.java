package com.nttdata.jobhub.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class LoginDto {
    @NotBlank
    private String dni;
    @NotBlank
    private String password;
}