package com.nttdata.jobhub.controller;

import com.nttdata.jobhub.dto.CreateOfficeDto;
import com.nttdata.jobhub.dto.OfficeDto;
import com.nttdata.jobhub.service.OfficeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Office", description = "Endpoints for offices management")
@RequestMapping("api/v1/offices")
@SecurityRequirement(name = "bearerAuth")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @Operation(summary = "Get all offices", description = "Retrieve a list of all registered offices.")
    @ApiResponse(responseCode = "200", description = "List of offices successfully retrieved.")
    @GetMapping
    public ResponseEntity<List<OfficeDto>> getAllOffices() {
        List<OfficeDto> officeList = officeService.getAll();
        return new ResponseEntity<>(officeList, HttpStatus.OK);
    }

    @Operation(summary = "Create a new office", description = "Create a new office with the provided data in the request body.")
    @ApiResponse(responseCode = "201", description = "Office successfully created.")
    @ApiResponse(responseCode = "400", description = "Invalid request data.")
    @PostMapping
    public ResponseEntity<Void> createOffice(@RequestBody CreateOfficeDto createOfficeDto) {
        officeService.create(createOfficeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}