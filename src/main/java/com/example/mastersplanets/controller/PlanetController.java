package com.example.mastersplanets.controller;

import com.example.mastersplanets.model.Planet;
import com.example.mastersplanets.service.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {
    private PlanetService planetService;

    public PlanetController(PlanetService service) {
        this.planetService = service;
    }

    @GetMapping
    public List<Planet> findAllPlanets() {
        return planetService.findAllPlanets();
    }

    @GetMapping("/{id}")
    public Planet findPlanet(@PathVariable("id") Long id) {
        return planetService.findPlanetById(id);
    }

    @PostMapping
    public Planet createPlanet(@RequestBody Planet planet) {
        return planetService.createPlanet(planet);
    }

    @PostMapping("/{planetId}/master/{masterId}")
    public Planet assignMaster(@PathVariable("planetId") Long planetId, @PathVariable("masterId") Long masterId) {
        return planetService.assignMaster(planetId, masterId);
    }

    @PutMapping("/{id}")
    public Planet updatePlanet(@PathVariable("id") Long id, @RequestBody Planet planet) {
        planet.setId(id);
        return planetService.updatePlanet(planet);
    }

    @DeleteMapping("/{id}")
    public void deletePlanet(@PathVariable("id") Long id) {
        planetService.deletePlanet(id);
    }
}
