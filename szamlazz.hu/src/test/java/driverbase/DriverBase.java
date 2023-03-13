package driverbase;

import jsonDTO.ConfigData;
import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class DriverBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    @BeforeMethod(alwaysRun = true)
    public void driverSetup() throws IOException {
        Path filePath = Path.of("src/test/resources/configuration.json");
        String content = Files.readString(filePath);
        System.out.println(content);
        Gson g = new Gson();
        ConfigData data = g.fromJson(content, ConfigData.class);
        if (data.getWebdriverConfig().equals(EnumData.ConfigurationEnumData.CHROME.toString())) {
            // browswer will open only in the background, not shown. IT is commented out for now to see if the driver runs.
            // Set it false, if you want to see the browser
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.setHeadless(false);
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver(options);
        } else if (data.getWebdriverConfig().equals(EnumData.ConfigurationEnumData.FIREFOX.toString())) {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();
        } else throw new IllegalArgumentException("Wrong browser type");
        wait = new WebDriverWait(driver, Duration.ofMillis(30000));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        System.out.println("Test case execution started");
    }

    @AfterMethod(alwaysRun = true)
    public void driverCleanUp() {
        driver.manage().deleteAllCookies();
        driver.quit();
        System.out.println("Test case execution finished");
    }
}
