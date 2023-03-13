package test;

import driverbase.DriverBase;
import jsonDTO.RegistrationData;
import pages.NewInvoicePage;
import pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class RegistrationTest extends DriverBase {
    RegistrationPage registrationPage;
    NewInvoicePage newInvoicePage;


    @Test(description = "Test for the empty registration page, code: DD-T20", groups = {"registration", "smoke"})
    public void emptyAllTheFieldRegistrationTest() {
        registrationPage = new RegistrationPage(driver, wait);
        newInvoicePage = new NewInvoicePage(driver, wait);
        registrationPage.goToTheRegistrationPage();
        registrationPage.clickToRegistrationButton();
        registrationPage.allTheErrorMessageIsHere();
        newInvoicePage.logWriter();
    }

    @Test(description = "Test missing second name registration page, code: DD-T52", groups = {"registration"})
    public void missingSecondNameRegistrationTest() throws InterruptedException, IOException {
        registrationPage = new RegistrationPage(driver, wait);
        newInvoicePage = new NewInvoicePage(driver, wait);
        RegistrationData data = registrationPage.json();
        registrationPage.goToTheRegistrationPage();
        registrationPage.fillFirstNameField(data.getFirstName());
        registrationPage.clickToRegistrationButton();
        Thread.sleep(5000);
        List<WebElement> errorMessages = driver.findElements(By.className("input-errorMessage"));
        Assert.assertEquals("Add meg a keresztneved!", errorMessages.get(1).getText());
        newInvoicePage.logWriter();
    }

    @Test(description = "Test missing email registration page, code: DD-T24", groups = {"registration"})
    public void missingEmailRegistrationTest() throws InterruptedException, IOException {
        registrationPage = new RegistrationPage(driver, wait);
        newInvoicePage = new NewInvoicePage(driver, wait);
        RegistrationData data = registrationPage.json();
        registrationPage.goToTheRegistrationPage();
        registrationPage.fillFirstNameField(data.getFirstName());
        registrationPage.fillSecondNameField(data.getSecondName());
        registrationPage.clickToRegistrationButton();
        Thread.sleep(5000);
        List<WebElement> errorMessages = driver.findElements(By.className("input-errorMessage"));
        Assert.assertEquals("Érvénytelen email cím!", errorMessages.get(2).getText());
        newInvoicePage.logWriter();
    }

    @Test(description = "Test wrong email registration page, code: DD-T25", groups = {"registration"})
    public void wrongEmailRegistrationTest() throws InterruptedException, IOException {
        registrationPage = new RegistrationPage(driver, wait);
        newInvoicePage = new NewInvoicePage(driver, wait);
        RegistrationData data = registrationPage.json();
        registrationPage.goToTheRegistrationPage();
        registrationPage.fillFirstNameField(data.getFirstName());
        registrationPage.fillSecondNameField(data.getSecondName());
        registrationPage.fillEmailField(data.getWrongEmail());
        registrationPage.clickToRegistrationButton();
        Thread.sleep(5000);
        List<WebElement> errorMessages = driver.findElements(By.className("input-errorMessage"));
        Assert.assertEquals("Ez nem tűnik valós e-mail címnek.", errorMessages.get(2).getText());
        newInvoicePage.logWriter();
    }

    @Test(description = "Test missing pwd registration page, code: DD-T23", groups = {"registration"})
    public void missingPWDRegistrationTest() throws InterruptedException, IOException {
        registrationPage = new RegistrationPage(driver, wait);
        newInvoicePage = new NewInvoicePage(driver, wait);
        RegistrationData data = registrationPage.json();
        registrationPage.goToTheRegistrationPage();
        registrationPage.fillFirstNameField(data.getFirstName());
        registrationPage.fillSecondNameField(data.getSecondName());
        registrationPage.fillEmailField(data.getEmail());
        registrationPage.clickToRegistrationButton();
        Thread.sleep(5000);
        List<WebElement> errorMessages = driver.findElements(By.className("input-errorMessage"));
        Assert.assertEquals("Add meg a jelszót!", errorMessages.get(3).getText());
        newInvoicePage.logWriter();
    }

    @Test(description = "Test missing ASZF registration page, code: DD-T26", groups = {"registration"})
    public void missingASZFCheckBoxRegistrationTest() throws InterruptedException, IOException {
        registrationPage = new RegistrationPage(driver, wait);
        newInvoicePage = new NewInvoicePage(driver, wait);
        RegistrationData data = registrationPage.json();
        registrationPage.goToTheRegistrationPage();
        registrationPage.fillFirstNameField(data.getFirstName());
        registrationPage.fillSecondNameField(data.getSecondName());
        registrationPage.fillEmailField(data.getEmail());
        registrationPage.fillPWDField(data.getPWD());
        registrationPage.fillPWDField2(data.getPWD());
        registrationPage.clickToRegistrationButton();
        Thread.sleep(3000);
        List<WebElement> errorMessages = driver.findElements(By.className("input-errorMessage"));
        Assert.assertEquals("Kérjük, fogadd el az ÁSZF-et és az adatvédelmi tájékoztatót!", errorMessages.get(5).getText());
        newInvoicePage.logWriter();
    }
    @Test(description = "Test with not equal pwd registration page, code: DD-T51", groups = {"registration"})
    public void notEqualPWDsRegistrationTest() throws InterruptedException, IOException {
        registrationPage = new RegistrationPage(driver, wait);
        newInvoicePage = new NewInvoicePage(driver, wait);
        RegistrationData data = registrationPage.json();
        registrationPage.goToTheRegistrationPage();
        registrationPage.fillFirstNameField(data.getFirstName());
        registrationPage.fillSecondNameField(data.getSecondName());
        registrationPage.fillEmailField(data.getEmail());
        registrationPage.fillPWDField(data.getPWD());
        registrationPage.fillPWDField2(data.getPWD2());
        registrationPage.clickToRegistrationButton();
        Thread.sleep(3000);
        List<WebElement> errorMessages = driver.findElements(By.className("input-errorMessage"));
        Assert.assertEquals("A két jelszó nem egyezik meg.", errorMessages.get(4).getText());
        newInvoicePage.logWriter();
    }

    @Test(description = "Te Szamlazz.hu button return the home page, code: DD-T27", groups = {"registration"})
    public void theSzamlazzButtonReturnBackToTheHomePage(){
        registrationPage = new RegistrationPage(driver, wait);
        newInvoicePage = new NewInvoicePage(driver, wait);
        registrationPage.goToTheRegistrationPage();
        registrationPage.clickSzamlazzHuButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.szamlazz.hu/szamla/main");
        newInvoicePage.logWriter();
    }
}
