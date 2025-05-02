package com.diegonunez.TechTestProteccion.service;

import com.diegonunez.TechTestProteccion.dto.request.FibonacciRequestDTO;
import com.diegonunez.TechTestProteccion.dto.response.FibonacciResponseDTO;

import java.util.List;

public interface IFibonacciService {
    List<Long> getFibonacciSeries(FibonacciRequestDTO time);

    List<FibonacciResponseDTO> getAllFibonacciSeries();

    //Integer x1, Integer x2, Integer size
}