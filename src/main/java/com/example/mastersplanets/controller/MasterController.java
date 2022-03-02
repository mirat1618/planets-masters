package com.example.mastersplanets.controller;

import com.example.mastersplanets.model.Master;
import com.example.mastersplanets.model.Planet;
import com.example.mastersplanets.service.MasterService;
import com.example.mastersplanets.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/masters")
public class MasterController {
    private MasterService masterService;
    private PlanetService planetService;

    @Autowired
    public MasterController(MasterService masterService, PlanetService planetService) {
        this.masterService = masterService;
        this.planetService = planetService;

    }

    @GetMapping
    public List<Master> findAllMasters() {
        return masterService.findAllMasters();
    }

    @GetMapping("/top/{topNumber}")
    public List<Master> findTop10ByAge(@PathVariable("topNumber") Long topNumber) {
        if(topNumber == 10)
            return masterService.findTop10ByAge();
        return masterService.findAllMasters();
    }

    @GetMapping("/unoccupied")
    public List<Master> findUnoccupied() {
        return masterService.findUnoccupied();
    }


//    @GetMapping("/{id}")
//    public Master findMaster(@PathVariable("id") Long id) {
//        return service.findMasterById(id);
//    }

    @PostMapping
    public Master createMaster(@RequestBody Master master) {
        return masterService.createMaster(master);
    }

    @PostMapping("{masterId}/planet/{planetId}")
    public Master assignPlanet(@PathVariable("masterId") Long masterId, @PathVariable("planetId") Long planetId) {
        Planet planet = planetService.assignMaster(planetId, masterId);
        return planet.getMaster();
    }

//    @PutMapping("/{id}")
//    public Master updateMaster(@PathVariable("id") Long id, @RequestBody Master master) {
//        master.setId(id);
//        return service.updateMaster(master);
//    }

    @DeleteMapping("/{id}")
    public void deleteMaster(@PathVariable("id") Long id) {
        masterService.deleteMaster(id);
    }
}
