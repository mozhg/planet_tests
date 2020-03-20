package tests.tcs;

import models.Planet;
import org.junit.Test;
import tests.BaseTest;

public class TC1Tatooine extends BaseTest {


    /**
     * Выбираем планету «Tatooine» и проверяем, происходят ли какие действия на планете «Tatooine» в 4 серии фильма.
     */
    @Test
    public void isThereSomeActionOnTatooineInEpisode4Test() {
        //Выбираем планету «Tatooine» и выводим в логи
        Planet planet = getPlanet("1");
        System.out.println(planet);


    }
}
