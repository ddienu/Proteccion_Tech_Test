package com.diegonunez.TechTestProteccion.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FibonacciResponseDTO {
    private Integer fibonacciId;
    @Schema(type = "string", example = "03:10:00", format = "time")
    private LocalTime date;
    private String beans;
    private Integer length;
    private String fibonacciCreated;
}
