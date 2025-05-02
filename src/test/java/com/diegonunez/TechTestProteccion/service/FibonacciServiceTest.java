package com.diegonunez.TechTestProteccion.service;

import com.diegonunez.TechTestProteccion.dto.request.FibonacciRequestDTO;
import com.diegonunez.TechTestProteccion.dto.response.FibonacciResponseDTO;
import com.diegonunez.TechTestProteccion.exception.custom.FibonacciZeroBeansException;
import com.diegonunez.TechTestProteccion.exception.custom.NoSeriesFoundException;
import com.diegonunez.TechTestProteccion.exception.custom.SeriesLengthException;
import com.diegonunez.TechTestProteccion.model.entity.Fibonacci;
import com.diegonunez.TechTestProteccion.repository.IFibonacciRepository;
import com.diegonunez.TechTestProteccion.service.Impl.FibonacciServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FibonacciServiceTest {

    private IFibonacciRepository fibonacciRepository;
    private FibonacciServiceImpl fibonacciService;
    private FibonacciRequestDTO time;
    private Fibonacci entity;

    @BeforeEach
    void setUp() {
        time = new FibonacciRequestDTO();
        entity = new Fibonacci();
        fibonacciRepository = mock(IFibonacciRepository.class);
        fibonacciService = new FibonacciServiceImpl(fibonacciRepository);
    }

    @Test
    void generateFibonacciSuccess(){
        time.setTime(LocalTime.of(12, 23, 04));

        List<Long> result = fibonacciService.getFibonacciSeries(time);

        List<Long> expected = List.of(21L, 13L, 8L, 5L, 3L, 2L);

        assertEquals(expected, result);
    }

    @Test
    void generateFibonacciThrowsSeriesLengthException(){
        time.setTime(LocalTime.of(12, 23, 00));

        Exception exception = assertThrows(SeriesLengthException.class, () -> {
            fibonacciService.getFibonacciSeries(time);
        });

        assertTrue(exception.getMessage().contains("The series length is 0"));
    }

    @Test
    void generateFibonacciThrowsFibonacciZeroBeansException(){
        time.setTime(LocalTime.of(12, 00, 01));

        Exception exception = assertThrows(FibonacciZeroBeansException.class, () -> {
            fibonacciService.getFibonacciSeries(time);
        });

        assertTrue(exception.getMessage().contains("Impossible to run the fibonacci because there are no numbers to sum"));
    }

    @Test
    void getAllFibonacciSuccess(){
        entity.setFibonacciId(1);
        entity.setDate(LocalTime.of(12, 23, 04));
        entity.setBeans("23");
        entity.setLength(4);
        entity.setFibonacciCreated("[21, 13, 8, 5, 3, 2]");

        when(fibonacciRepository.findAll()).thenReturn(List.of(entity));

        List<FibonacciResponseDTO> result = fibonacciService.getAllFibonacciSeries();

        assertNotNull(result);
        assertEquals(1, result.size());

    }

    @Test
    void getAllFibonacciThrowsNoSeriesFoundException(){
        when(fibonacciRepository.findAll()).thenReturn(List.of());

        assertThrows(NoSeriesFoundException.class, () -> {
            fibonacciService.getAllFibonacciSeries();
        });

        verify(fibonacciRepository, times(1)).findAll();
    }

}
