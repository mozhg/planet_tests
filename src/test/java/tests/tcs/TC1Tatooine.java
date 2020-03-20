package tests.tcs;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import models.Planet;
import org.junit.Test;
import tests.BaseTest;

import java.util.logging.Logger;

public class TC1Tatooine extends BaseTest {
    private static Logger logger = Logger.getLogger(String.valueOf(TC1Tatooine.class));
    private int episode;

    @Test
    @Description("Выбираем планету «Tatooine» и проверяем, происходят ли какие действия на планете «Tatooine» в 4 серии фильма")
    @Story("TC1: Tatooine")
    public void isThereSomeActionOnTatooineInEpisode4Test() {
        logger.info("Выбираем планету «Tatooine» и выводим");
        Planet planet = getPlanet("1");
        logger.info(String.valueOf(planet));

        episode = 4;
        printIsThereSomeActionOnAPlanetXInEpisodeY(planet, episode);
    }
}
