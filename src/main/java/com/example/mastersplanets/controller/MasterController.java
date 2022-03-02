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
    private MasterService service;

    @Autowired
    public MasterController(MasterService service) {
        this.service = service;
    }

    @GetMapping
    public List<Master> findAllMasters() {
        return service.findAllMasters();
    }

    @GetMapping("/top/{topNumber}")
    public List<Master> findTop10ByAge(@PathVariable("topNumber") Long topNumber) {
        if(topNumber == 10)
            return service.findTop10ByAge();
        return service.findAllMasters();
    }

    @GetMapping("/unoccupied")
    public List<Master> findUnoccupied() {
        return service.findUnoccupied();
    }


//    @GetMapping("/{id}")
//    public Master findMaster(@PathVariable("id") Long id) {
//        return service.findMasterById(id);
//    }

    @PostMapping
    public Master createMaster(@RequestBody Master master) {
        return service.createMaster(master);
    }

//    @PutMapping("/{id}")
//    public Master updateMaster(@PathVariable("id") Long id, @RequestBody Master master) {
//        master.setId(id);
//        return service.updateMaster(master);
//    }

    @DeleteMapping("/{id}")
    public void deleteMaster(@PathVariable("id") Long id) {
        service.deleteMaster(id);
    }
}
