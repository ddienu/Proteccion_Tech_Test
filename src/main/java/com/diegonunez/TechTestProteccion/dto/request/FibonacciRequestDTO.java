package com.diegonunez.TechTestProteccion.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FibonacciRequestDTO {

    @NotNull(message = "Time cannot be null or empty")
    @Schema(type = "string", example = "03:10:00", format = "time")
    private LocalTime time;
}
