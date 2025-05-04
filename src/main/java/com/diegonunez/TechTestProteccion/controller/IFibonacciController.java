package com.diegonunez.TechTestProteccion.controller;

import com.diegonunez.TechTestProteccion.dto.request.FibonacciRequestDTO;
import com.diegonunez.TechTestProteccion.dto.response.APIResponseDTO;
import com.diegonunez.TechTestProteccion.dto.response.FibonacciResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IFibonacciController {


    @PostMapping(produces = "application/json")
    @Operation(summary = "Creates a fibonacci series", description = "Returns a fibonacci series in descendant order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fibonacci series generated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters", content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error", content = @Content)
    })
    ResponseEntity<APIResponseDTO<List<Long>>> getFibonacciSeries(@Valid @RequestBody FibonacciRequestDTO time);

    @GetMapping(produces = "application/json" )
    @Operation(summary = "Retrieve fibonacci series from database", description = "Returns the fibonacci series list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fibonacci series retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters", content = @Content()),
            @ApiResponse(responseCode = "500", description = "Server error", content = @Content)
    })
    ResponseEntity<APIResponseDTO<List<FibonacciResponseDTO>>> getAllFibonacciSeries();
}
