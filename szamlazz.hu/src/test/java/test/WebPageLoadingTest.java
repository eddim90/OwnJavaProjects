package test;

import driverbase.DriverBase;
import pages.WebPageLoad;
import org.testng.annotations.Test;

public class WebPageLoadingTest extends DriverBase {
    WebPageLoad webPageLoad;
    @Test(description = "baseline for webpage load", groups = {"smoke"})
    public void pageLoading() {
        webPageLoad = new WebPageLoad(driver, wait);
        webPageLoad.loadingIn();
    }
}
