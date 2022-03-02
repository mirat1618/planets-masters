package com.example.mastersplanets.service;

import com.example.mastersplanets.model.Master;
import com.example.mastersplanets.model.Planet;
import com.example.mastersplanets.repo.MasterRepo;
import com.example.mastersplanets.repo.PlanetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {
    private PlanetRepo planetRepo;
    private MasterRepo masterRepo;

    @Autowired
    public PlanetService(PlanetRepo planetRepo, MasterRepo masterRepo) {
        this.planetRepo = planetRepo;
        this.masterRepo = masterRepo;
    }

    public List<Planet> findAllPlanets() {
        return planetRepo.findAllByOrderByIdAsc();
    }

    public Planet findPlanetById(Long id) {
        return planetRepo.findById(id).orElse(null);
    }

    public Planet createPlanet(Planet planet) {
        return planetRepo.save(planet);
    }

    public Planet updatePlanet(Planet planet) {
        return planetRepo.save(planet);
    }

    public void deletePlanet(Long id) {
        planetRepo.deleteById(id);
    }

    public Planet assignMaster(Long planetId, Long masterId) {
        Planet planet = planetRepo.findById(planetId).orElse(null);
        Master master = masterRepo.findById(masterId).orElse(null);

        if(planet != null && master != null) {
            planet.setMaster(master);
            planet = planetRepo.save(planet);
            return planet;
        }

        return null;
    }
}
