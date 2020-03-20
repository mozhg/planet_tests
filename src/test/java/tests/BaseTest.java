package tests;

import io.qameta.allure.Step;
import models.Planet;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.logging.Logger;

public class BaseTest {
    RestTemplate restTemplate;
    private static Logger logger = Logger.getLogger(String.valueOf(BaseTest.class));


    @Step("Получем планету {planetNumber}")
    protected Planet getPlanet(String planetNumber) {
        Planet planet = null;
        try {
            restTemplate = new RestTemplate();
            planet = restTemplate.getForObject("https://swapi.co/api/planets/" + planetNumber, Planet.class);
        } catch (Exception e) {
            logger.warning("Не удалось получить планету");
        }
        return planet;
    }

    @Step("Проверяем, происходят ли какие действия на планете {planet} в {episode} серии фильма")
    protected void printIsThereSomeActionOnAPlanetXInEpisodeY(Planet planet, Integer episode) {
        if (isThereSomeActionOnAPlanetXInEpisodeY(planet, episode)) {
            logger.info("Действия на планете "
                    + planet.getName() + " происходят в эпизоде " + episode);
        } else {
            logger.info("Действия на планете "
                    + planet.getName() + " НЕ происходят в эпизоде " + episode);
        }
    }

    public Boolean isThereSomeActionOnAPlanetXInEpisodeY(Planet planet, Integer episode) {
        String[] filmsWithPlanet = planet.getFilms();
        logger.info("Список фильмов с планетой " + planet.getName() + " " + Arrays.toString(planet.getFilms()));
        int i = 0;
        while (i < filmsWithPlanet.length) {
            if (filmsWithPlanet[i].contains("/films/" + episode + "/")) return true;
            i++;
        }
        return false;
    }
}
