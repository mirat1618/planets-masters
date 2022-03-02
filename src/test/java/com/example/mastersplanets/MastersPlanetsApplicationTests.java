package com.example.mastersplanets;

import com.example.mastersplanets.model.Master;
import com.example.mastersplanets.model.Planet;
import com.example.mastersplanets.service.MasterService;
import com.example.mastersplanets.service.PlanetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class MastersPlanetsApplicationTests {
	Planet newPlanet = null;
	Master newMaster = null;

	@Autowired
	MasterService masterService;

	@Autowired
	PlanetService planetService;

	@BeforeEach
	public void createPlanetInstance() {
		newPlanet = new Planet("Plunge");
	}

	@BeforeEach
	public void createMasterInstance() {
		newMaster = new Master("Tyler", 22);
	}

	@Test
	public void testPlanetCreation() {
		Planet planet = planetService.createPlanet(newPlanet);
		Planet theSamePlanet = planetService.findPlanetById(planet.getId());
		assert(planet.getTitle().equals(theSamePlanet.getTitle()));
		assertNotNull(planetService.findPlanetById(planet.getId()));
	}

	@Test
	public void testMasterCreation() {
		Master master = masterService.createMaster(newMaster);
		Master theSameMaster = masterService.findMasterById(master.getId());
		assert(master.getName().equals(theSameMaster.getName()));
		assertNotNull(masterService.findMasterById(master.getId()));
	}

	@Test
	public void testMasterAssignment() {
		Planet planet = planetService.createPlanet(newPlanet);
		Master master = masterService.createMaster(newMaster);

		assertNull(planet.getMaster());

		planet.setMaster(master);

		assertNotNull(planet.getMaster());
		assert(planet.getMaster().getId() == master.getId());
	}

	@Test
	public void testPlanetDestruction() {
		Planet planet = planetService.createPlanet(newPlanet);
		assert(planet.getTitle().equals(planet.getTitle()));
		assertNotNull(planetService.findPlanetById(planet.getId()));

		planetService.deletePlanet(planet.getId());

		assertNull(planetService.findPlanetById(planet.getId()));
	}

	@Test
	public void testFindingUnoccupiedMasters() {

	}



}
