package hu.progmatic.exampletests;

import hu.progmatic.driverfactory.DriverBaseTest;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabsProductionPage extends DriverBaseTest {


    @BeforeMethod
    private void login()throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void firstElementCheck() throws InterruptedException {

        WebElement sorting= driver.findElement(By.id("item_4_img_link"));
        sorting.click();
        WebElement backButton= driver.findElement(By.id("back-to-products"));
        Assert.assertEquals("BACK TO PRODUCTS",backButton.getText());
        backButton.click();

    }

}
