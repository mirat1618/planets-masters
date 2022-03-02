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
    private MasterRepo repo;

    @Autowired
    public MasterService(MasterRepo repo) {
        this.repo = repo;
    }

    public List<Master> findAllMasters() {
        return repo.findAllByOrderByIdAsc();
    }

    public List<Master> findTop10ByAge() { return repo.findTop10ByOrderByAge(); }

    public List<Master> findUnoccupied() { return repo.findByPlanetsIsNull(); }

    public Master findMasterById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Master createMaster(Master master) {
        return repo.save(master);
    }

    public Master updateMaster(Master master) {
        return repo.save(master);
    }

    public void deleteMaster(Long id) {
        repo.deleteById(id);
    }


}
