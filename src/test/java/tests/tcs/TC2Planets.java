package tests.tcs;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import models.Film;
import models.Planet;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.logging.Logger;

public class TC2Planets extends BaseTest {
    private static Logger logger = Logger.getLogger(String.valueOf(TC2Planets.class));


    @Test
    @Description("Из 4 серии выбираем все планеты, где происходят действия в фильме и сравниваем с массивом Planets {Naboo, Coruscant, Tatooine, Endor}")
    @Story("TC2: Planets")
    public void chooseAllPlanetsFromEpisode4AndCompareWithPlanetsArrayTest() {
        logger.info("Выбираем четвертый эпизод и выводим");
        Film film = getFilm("4");
        logger.info(String.valueOf(film));

        logger.info("выбираем все планеты, где происходят действия в фильме и сравниваем с массивом Planets {Naboo, Coruscant, Tatooine, Endor}");
        String[] planetsApi = film.getPlanets();
        String[] planetsListToCompare = {"Naboo", "Coruscant", "Tatooine", "Endor"};
        if (isPlanetsEqualsList(planetsApi, planetsListToCompare)) {
            logger.info("В фильме есть все планеты из массива Planets");
        } else {
            logger.warning("В фильме есть НЕ все планеты из массива Planets");
            throw new AssertionError("В фильме есть НЕ все планеты из массива Planets");
        }
    }
}
