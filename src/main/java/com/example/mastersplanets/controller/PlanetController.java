package com.example.mastersplanets.controller;

import com.example.mastersplanets.model.Planet;
import com.example.mastersplanets.service.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {
    private PlanetService service;

    public PlanetController(PlanetService service) {
        this.service = service;
    }

    @GetMapping
    public List<Planet> findAllPlanets() {
        return service.findAllPlanets();
    }

    @GetMapping("/{id}")
    public Planet findPlanet(@PathVariable("id") Long id) {
        return service.findPlanetById(id);
    }

    @PostMapping
    public Planet createPlanet(@RequestBody Planet planet) {
        return service.createPlanet(planet);
    }

    @PostMapping("/{planetId}/master/{masterId}")
    public Planet assignMaster(@PathVariable("planetId") Long planetId, @PathVariable("masterId") Long masterId) {
        return service.assignMaster(planetId, masterId);
    }

    @PutMapping("/{id}")
    public Planet updatePlanet(@PathVariable("id") Long id, @RequestBody Planet planet) {
        planet.setId(id);
        return service.updatePlanet(planet);
    }

    @DeleteMapping("/{id}")
    public void deletePlanet(@PathVariable("id") Long id) {
        service.deletePlanet(id);
    }
}
