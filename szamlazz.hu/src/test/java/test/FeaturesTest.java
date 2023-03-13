package test;

import driverbase.DriverBase;
import jsonDTO.NewInvoiceData;
import jsonDTO.LoginData;
import pages.LoginPage;
import pages.NewInvoicePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class FeaturesTest extends DriverBase {

    NewInvoicePage newInvoicePage;
    LoginPage loginPage;

    @Test(description = "E2E test for login, code: DD-T34", groups = {"feature","smoke"})
    public void LoginWithCorrectPwdAndUsr() throws InterruptedException, IOException {
        loginPage = new LoginPage(driver, wait, actions);
        LoginData data = loginPage.json();
        loginPage.loginWithCorrectUsernameCorrectPwd(data.getUserName(), data.getPassword());
        System.out.println("Login completed.");
    }

    @Test(description = "E2E test for new invoice making, code: DD-T34", groups = {"feature","smoke"})
    public void NewInvoiceMakingTest() throws InterruptedException, IOException {
        newInvoicePage = new NewInvoicePage(driver, wait);
        NewInvoiceData data = newInvoicePage.json();
        newInvoicePage.loadTheNewInvoicePage();
        newInvoicePage.fillTheCompanyName(data.getCompanyName());
        newInvoicePage.fillTheCity(data.getCity());
        newInvoicePage.fillTheAdress(data.getAdressName());
        newInvoicePage.fillTheItemName(data.getItemName());
        newInvoicePage.chooseTaxAAM();
        newInvoicePage.fillQty(data.getQty());
        newInvoicePage.fillPrice(data.getPrice());
        newInvoicePage.pushTheCreateInvoiceButton();
        Thread.sleep(4000);
        newInvoicePage.invoicePopUpCleaner();
        Thread.sleep(6000);
        newInvoicePage.exitButtonClick();
        WebElement newInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable
                (driver.findElement(By.xpath("//*[@id=\"inner-content\"]/div[3]/div/a"))));
        Assert.assertTrue(newInvoiceButton.isDisplayed());
        System.out.println("The invoice is ready.");
    }

    @Test(description = "E2E test for new proforma invoice making, code: DD-T49", groups = {"feature","smoke"})
    public void NewProformaMakingTest() throws InterruptedException, IOException {
        newInvoicePage = new NewInvoicePage(driver, wait);
        NewInvoiceData data = newInvoicePage.json();
        newInvoicePage.loadTheNewInvoicePage();
        newInvoicePage.changeProformaButton();
        newInvoicePage.fillTheCompanyName(data.getCompanyName());
        newInvoicePage.fillTheCity(data.getCity());
        newInvoicePage.fillTheAdress(data.getAdressName());
        newInvoicePage.fillTheItemName(data.getItemName());
        newInvoicePage.chooseTaxAAM();
        newInvoicePage.fillQty(data.getQty());
        newInvoicePage.fillPrice(data.getPrice());
        newInvoicePage.pushTheCreateInvoiceButton();
        Thread.sleep(4000);
        newInvoicePage.invoicePopUpCleaner();
        Thread.sleep(6000);
        newInvoicePage.exitButtonClick();
        WebElement newInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"inner-content\"]/div[3]/div/a"))));
        Assert.assertTrue(newInvoiceButton.isDisplayed());
        System.out.println("The Proforma invoice is ready.");
    }
    @Test(description = "E2E test for new deposite invoice making, code: DD-T49", groups = {"feature","smoke"})
    public void NewDepositeMakingTest() throws InterruptedException, IOException {
        newInvoicePage = new NewInvoicePage(driver, wait);
        NewInvoiceData data = newInvoicePage.json();
        newInvoicePage.loadTheNewInvoicePage();
        newInvoicePage.changeDepositeButton();
        newInvoicePage.fillTheCompanyName(data.getCompanyName());
        newInvoicePage.fillTheCity(data.getCity());
        newInvoicePage.fillTheAdress(data.getAdressName());
        newInvoicePage.fillTheItemName(data.getItemName());
        newInvoicePage.chooseTaxAAM();
        newInvoicePage.fillQty(data.getQty());
        newInvoicePage.fillPrice(data.getPrice());
        newInvoicePage.pushTheCreateInvoiceButton();
        Thread.sleep(4000);
        newInvoicePage.invoicePopUpCleaner();
        Thread.sleep(6000);
        newInvoicePage.exitButtonClick();
        WebElement newInvoiceButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"inner-content\"]/div[3]/div/a"))));
        Assert.assertTrue(newInvoiceButton.isDisplayed());
        System.out.println("The Deposite invoice is ready.");
    }
}
