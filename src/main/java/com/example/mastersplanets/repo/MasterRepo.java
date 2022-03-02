package com.example.mastersplanets.repo;

import com.example.mastersplanets.model.Master;
import com.example.mastersplanets.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MasterRepo extends JpaRepository<Master, Long> {
    public List<Master> findAllByOrderByIdAsc();
    public List<Master> findTop10ByOrderByAge();
    public List<Master> findByPlanetsIsNull();
}
