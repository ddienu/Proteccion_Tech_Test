package com.diegonunez.TechTestProteccion.repository;

import com.diegonunez.TechTestProteccion.model.entity.Fibonacci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFibonacciRepository extends JpaRepository<Fibonacci, Integer> {
}
