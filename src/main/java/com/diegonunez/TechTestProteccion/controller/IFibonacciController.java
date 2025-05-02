package com.diegonunez.TechTestProteccion.controller;

import com.diegonunez.TechTestProteccion.dto.request.FibonacciRequestDTO;
import com.diegonunez.TechTestProteccion.dto.response.APIResponseDTO;
import com.diegonunez.TechTestProteccion.dto.response.FibonacciResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IFibonacciController {

    @PostMapping()
    ResponseEntity<APIResponseDTO<List<Long>>> getFibonacciSeries(@Valid @RequestBody FibonacciRequestDTO time);

    @GetMapping()
    ResponseEntity<APIResponseDTO<List<FibonacciResponseDTO>>> getAllFibonacciSeries();
}
