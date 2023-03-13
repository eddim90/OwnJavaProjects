package pages;

import driverbase.LogWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class WebPageLoad {
    WebDriver driver;
    WebDriverWait wait;
    LogWriter fileLogging;
    By header = By.id("topButtonRow");

    public WebPageLoad(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadingIn() {
        driver.get("https://szamlazz.hu");
        WebElement headerElement = driver.findElement(header);
        Assert.assertTrue(headerElement.isDisplayed());
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }

}
