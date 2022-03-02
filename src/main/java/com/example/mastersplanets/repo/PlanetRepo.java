package com.example.mastersplanets.repo;

import com.example.mastersplanets.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanetRepo extends JpaRepository<Planet, Long> {
    public List<Planet> findAllByOrderByIdAsc();
}
