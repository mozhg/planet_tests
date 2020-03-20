package tests.tcs;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import models.Planet;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.logging.Logger;

public class TC3Naboo extends BaseTest {
    private static Logger logger = Logger.getLogger(String.valueOf(TC3Naboo.class));


    @Test
    @Description("Проверяем жителей на планете Naboo, чтобы количество резидентов было равно 11")
    @Story("TC3: Naboo")
    public void isNabooResidentsQuantityEquals11Test() {
        logger.info("Выбираем планету «Naboo» и выводим");
        Planet planet = getPlanet("8");
        logger.info(String.valueOf(planet));

        checkIsResidentQuantityEqualsNumber(planet, 11);
    }
}
