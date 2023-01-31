package hu.progmatic.exampletests;

import hu.progmatic.driverfactory.DriverBaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TutorialsPointTest extends DriverBaseTest {

    @Test
    public void formTest() throws InterruptedException {
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        WebElement acceptCookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Consent')]")));
        acceptCookieButton.click();

        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        firstNameInput.sendKeys("Zsolt");

        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys("Szurovecz");

        WebElement maleRadio = driver.findElement(By.cssSelector("input[value='Male']"));
        maleRadio.click();

        WebElement experienceRadio = driver.findElement(By.cssSelector("input[name='exp'][value='7']"));
        experienceRadio.click();

        WebElement dateInputField = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div/form/table/tbody/tr[5]/td[2]/input"));
        dateInputField.sendKeys("2023-01-28");

        WebElement professionCheckbox = driver.findElement(By.cssSelector("input[value='Automation Tester']"));
        professionCheckbox.click();

        WebElement fileUploadInput = driver.findElement(By.name("photo"));
        // MACOS esetén:
        fileUploadInput.sendKeys("/Users/zsszurovecz/Desktop/progmaticjrta/ProgmaticTAF/src/test/resources/uploadexample.txt");
        // WINDOWS esetén:
        //fileUploadInput.sendKeys("C:\\Users\\zsszurovecz\\Desktop\\progmaticjrta\\ProgmaticTAF\\src\\test\\resources\\uploadexample.txt");

        WebElement flavourOfSeleniumCheckbox = driver.findElement(By.cssSelector("input[value='Selenium Webdriver']"));
        flavourOfSeleniumCheckbox.click();

        Select continentsDropdown = new Select(driver.findElement(By.cssSelector("select[name='continents']")));
        continentsDropdown.selectByVisibleText("Europe");

        Select seleniumcommandsDropdown = new Select(driver.findElement(By.cssSelector("select[name='selenium_commands']")));
        seleniumcommandsDropdown.selectByVisibleText("WebElement Commands");

        WebElement acceptBannerCookieButton =  wait.until(ExpectedConditions.elementToBeClickable(By.id("banner-accept")));
        acceptBannerCookieButton.click();

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
        // Actions actions = new Actions(driver);
        //jelenleg a DriverSetup metodusban hoztuk létre az actions változót és protected mivolta miatt tudjuk itt használni
        actions.moveToElement(submitButton);
        actions.perform();
        submitButton.click();

        driver.switchTo().alert().dismiss(); // a felugró ablak Cancel gombjára kattint
        driver.switchTo().defaultContent(); // WebDriver-t visszaváltja az alapértelmezett ablakra
        Thread.sleep(2000);
    }
}
