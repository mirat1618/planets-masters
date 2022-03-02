package com.example.mastersplanets;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.mastersplanets.controller.MasterController;
import com.example.mastersplanets.controller.PlanetController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureMockMvc
public class MastersPlanetsWebTest {
    @Autowired
    private PlanetController planetController;

    @Autowired
    private MasterController masterController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(planetController).isNotNull();
        assertThat(masterController).isNotNull();
    }

}
