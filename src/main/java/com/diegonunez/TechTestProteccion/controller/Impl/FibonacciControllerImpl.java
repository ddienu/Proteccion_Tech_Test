package com.diegonunez.TechTestProteccion.controller.Impl;

import com.diegonunez.TechTestProteccion.controller.IFibonacciController;
import com.diegonunez.TechTestProteccion.dto.request.FibonacciRequestDTO;
import com.diegonunez.TechTestProteccion.dto.response.APIResponseDTO;
import com.diegonunez.TechTestProteccion.dto.response.FibonacciResponseDTO;
import com.diegonunez.TechTestProteccion.service.IFibonacciService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/fibonacci")
@CrossOrigin(origins = "*")
public class FibonacciControllerImpl implements IFibonacciController {

    private final IFibonacciService fibonacciService;

    public FibonacciControllerImpl(IFibonacciService fibonacciService){
        this.fibonacciService = fibonacciService;
    }

    @Override
    public ResponseEntity<APIResponseDTO<List<Long>>> getFibonacciSeries(FibonacciRequestDTO time) {
        List<Long> response = fibonacciService.getFibonacciSeries(time);
        return ResponseEntity.ok().body(
                new APIResponseDTO<List<Long>>(
                        "Fibonacci series generated successfully",
                        response
                )
        );
    }

    @Override
    public ResponseEntity<APIResponseDTO<List<FibonacciResponseDTO>>> getAllFibonacciSeries() {
        List<FibonacciResponseDTO> response = fibonacciService.getAllFibonacciSeries();
        return ResponseEntity.ok().body(
                new APIResponseDTO<List<FibonacciResponseDTO>>(
                        "Fibonacci series retrieved successfully",
                        response
                )
        );
    }
}
