package com.diegonunez.TechTestProteccion.dto.response;

import com.diegonunez.TechTestProteccion.model.enums.EmailSentEnum;
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
    private LocalTime date;
    private String beans;
    private Integer length;
    private String fibonacciCreated;
}
