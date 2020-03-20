package tests;

import io.qameta.allure.Step;
import models.Film;
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

    @Step("Получем эпизод {episodeNumber}")
    protected Film getFilm(String episodeNumber) {
        Film film = null;
        try {
            restTemplate = new RestTemplate();
            film = restTemplate.getForObject("https://swapi.co/api/films/" + episodeNumber, Film.class);
        } catch (Exception e) {
            logger.warning("Не удалось получить эпизод");
        }
        return film;
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

    @Step("Проверяем жителей на планете Naboo, чтобы количество резидентов на планете {planet} было равно {quantity}")
    protected void checkIsResidentQuantityEqualsNumber(Planet planet, Integer quantity) {
        if (planet.getResidents().length == quantity) {
            logger.info("Количество резидентов на планете "
                    + planet.getName() + " равно " + quantity);
        } else {
            logger.info("Количество резидентов на планете "
                    + planet.getName() + " НЕ равно " + quantity);
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

    @Step("Сравниваем планеты, хранимые в виде ссылок Api в массиве {planetsApi} с массивом Planets {planetsListToCompare}")
    public Boolean isPlanetsEqualsList(String[] planetsApi, String[] planetsListToCompare) {
        int i = 0;
        int j = 0;
        int eqq = 0;
        String[] planets = {""};
        while (i < planetsApi.length) {
            planets[i] = getPlanet(planetsApi[i]).getName();
            i++;
        }
        i = 0;
        while (i < planetsListToCompare.length) {
            while (j < planets.length) {
                if (planetsListToCompare[i].equals(planets[j])) {
                    eqq++;
                    break;
                }
                j++;
            }
            i++;
        }
        return eqq == planetsListToCompare.length;
    }
}
