package com.example.mastersplanets.seed;

import com.example.mastersplanets.model.Master;
import com.example.mastersplanets.model.Planet;
import com.example.mastersplanets.service.MasterService;
import com.example.mastersplanets.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private MasterService masterService;
    private PlanetService planetService;

    @Autowired
    public DatabaseSeeder(MasterService masterService, PlanetService planetService) {
        this.masterService = masterService;
        this.planetService = planetService;
    }

    @Override
    public void run(String[] args) {
        Master master1 = new Master("Nikita", 25);
        Master master2 = new Master("Finat", 26);
        Master master3 = new Master("Mirat", 25);

        masterService.createMaster(master1);
        masterService.createMaster(master2);
        masterService.createMaster(master3);

        Planet planet1 = new Planet("Phobos", master1);
        Planet planet2 = new Planet("Ghost", master2);
        Planet planet3 = new Planet("Dom", master2);
        Planet planet4 = new Planet("Ulitsa", master2);
        Planet planet5 = new Planet("Phonar", master3);
        Planet planet6 = new Planet("Apterka", master1);

        planetService.createPlanet(planet1);
        planetService.createPlanet(planet2);
        planetService.createPlanet(planet3);
        planetService.createPlanet(planet4);
        planetService.createPlanet(planet5);
        planetService.createPlanet(planet6);
    }
}
