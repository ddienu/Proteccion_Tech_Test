package com.diegonunez.TechTestProteccion.exception.global;

import com.diegonunez.TechTestProteccion.dto.response.APIResponseDTO;
import com.diegonunez.TechTestProteccion.exception.custom.FibonacciZeroBeansException;
import com.diegonunez.TechTestProteccion.exception.custom.NoSeriesFoundException;
import com.diegonunez.TechTestProteccion.exception.custom.SeriesLengthException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSeriesFoundException.class)
    public ResponseEntity<APIResponseDTO<Object>> noSeriesFoundExceptionHandler(NoSeriesFoundException e){
        return ResponseEntity.ok().body(
                new APIResponseDTO<>(
                        e.getMessage(),
                        null
                )
        );
    }

    @ExceptionHandler(SeriesLengthException.class)
    public ResponseEntity<APIResponseDTO<Object>> seriesLengthExceptionHandler(SeriesLengthException e){
        return ResponseEntity.badRequest().body(
                new APIResponseDTO<>(
                        e.getMessage(),
                        null
                )
        );
    }

    @ExceptionHandler(FibonacciZeroBeansException.class)
    public ResponseEntity<APIResponseDTO<Object>> fibonacciZeroBeansExceptionHandler(FibonacciZeroBeansException e){
        return ResponseEntity.badRequest().body(
                new APIResponseDTO<>(
                        e.getMessage(),
                        null
                )
        );
    }
}
