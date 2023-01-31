package hu.progmatic.exampletests;

import hu.progmatic.driverfactory.DriverBaseTest;
import org.testng.annotations.Test;


public class GoogleHomeTest extends DriverBaseTest {

    @Test
    public void openGoogleHomeScreenTest() {
        driver.get("https://google.hu");
    }

    @Test
    public void openGoogleHomeScreen2Test() {
        driver.get("https://google.de");
    }
}
