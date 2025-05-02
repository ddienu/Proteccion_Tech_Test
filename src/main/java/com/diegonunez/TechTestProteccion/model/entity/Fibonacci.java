package com.diegonunez.TechTestProteccion.model.entity;

import com.diegonunez.TechTestProteccion.model.enums.EmailSentEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fibonacci implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fibonacciId;
    private LocalTime date;
    private String beans;
    private Integer length;
    @Lob
    private String fibonacciCreated;
}
