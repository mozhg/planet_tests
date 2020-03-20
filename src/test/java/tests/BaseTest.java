package tests;

import models.Planet;
import org.junit.BeforeClass;
import org.springframework.web.client.RestTemplate;

public class BaseTest {
    RestTemplate restTemplate;


    @BeforeClass
    public static void setUp() {
    }

    public Planet getPlanet(String planetNumber) {
        restTemplate = new RestTemplate();
        Planet planet = restTemplate.getForObject("https://swapi.co/api/planets/" + planetNumber, Planet.class);
        return planet;
    }
}
