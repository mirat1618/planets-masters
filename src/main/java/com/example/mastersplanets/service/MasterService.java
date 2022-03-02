package com.example.mastersplanets.service;

import com.example.mastersplanets.model.Master;
import com.example.mastersplanets.model.Planet;
import com.example.mastersplanets.repo.MasterRepo;
import com.example.mastersplanets.repo.PlanetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterService {
    private MasterRepo masterRepo;

    @Autowired
    public MasterService(MasterRepo repo) {
        this.masterRepo = repo;
    }

    public List<Master> findAllMasters() {
        return masterRepo.findAllByOrderByIdAsc();
    }

    public List<Master> findTop10ByAge() { return masterRepo.findTop10ByOrderByAge(); }

    public List<Master> findUnoccupied() { return masterRepo.findByPlanetsIsNull(); }

    public Master findMasterById(Long id) {
        return masterRepo.findById(id).orElse(null);
    }

    public Master createMaster(Master master) {
        return masterRepo.save(master);
    }

    public Master updateMaster(Master master) {
        return masterRepo.save(master);
    }

    public void deleteMaster(Long id) {
        masterRepo.deleteById(id);
    }


}
