package hu.progmatic.swaglabs;

import hu.progmatic.driverfactory.DriverBaseTest;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginScreenTests extends DriverBaseTest {

    // TC1
    @Test
    public void validUsernameEmptyPwdTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");

        // megkeressük a username mezőt és kitöltjük helyes username-el
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        // megkeressük a password mezőt, pusztán azért, hogy ezáltal ellenőrzni tudjuk annak megjelenését
        WebElement pwdInput = driver.findElement(By.id("password"));

        // megkeressük a login gombot és rákattintunk
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // kattintás után várunk 2mp-et, hogy a szem le tudja követni mi történik (a teszeset végeztével törölendő, hogy gyorsabban fusson)
        Thread.sleep(2000);

        // megkeressük a hibaüzenetet a felületen (bármely olyan webelement, ahol a szöveg a html tag-ek között az, hogy Epic sadface: Password is required )
        // WebElement errorMessage = driver.findElement(By.xpath("//*[text()='Epic sadface: Password is required']"));
        // VAGY megkeressük a hibaüzenetet oly módon, hogy azon h3 html tag, amelyiknek a data-test attribútumának az értéke az, hogy "error"
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));

        // annak ellenőrzése, hogy az elvárt hibaüzenetet tartalmazza-e az errorMessage html element tag-ek közötti értéke
        Assert.assertEquals("Epic sadface: Password is required", errorMessage.getText());
        // VAGY annak ellenőrzése, hogy az előzetesen megkeresett hibát tartalmazó html element valóban megjelent-e a felületen vagy tovább navigált az oldal
        // Assert.assertTrue(errorMessage.isDisplayed());

        // PÉLDA assertek
        // Assert.assertEquals("alma","korte"); //failed
        // Assert.assertEquals("alma","alma"); //passed
        // Assert.assertTrue(5==7); // failed
        // Assert.assertTrue(7==7); // passed
    }

    // TC2
    @Test
    public void emptyUsernameValidPwdTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username is required", errorMessage.getText());
    }

    // TC3
    @Test
    public void emptyUsernameEmptyPwdTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement pwdInput = driver.findElement(By.id("password"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        WebElement loginButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));

        loginButton.click();

        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username is required", errorMessage.getText());
    }

    // TC4
    @Test
    public void validUsernameWrongPwdTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("wrongpassword");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage.getText());
    }

    // TC5
    @Test
    public void wrongUsernameValidPwdTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("wrongusername");
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage.getText());
    }

    // TC6
    @Test
    public void wrongUsernameWrongPwdTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("wrongusername");
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("wrongpassword");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage.getText());
    }

    // TC7
    @Test
    public void validUsernameValidPwdTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        String pageCurrentUrl = driver.getCurrentUrl();
        Thread.sleep(2000);

        Assert.assertEquals("https://www.saucedemo.com/inventory.html", pageCurrentUrl);
    }

    // TC8
    @Test
    public void emptyUsernameWrongPwdTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("wrongpassword");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username is required", errorMessage.getText());
    }

    // TC9 wrong username and empty pwd
    @Test
    public void wrongUsernameEmptyPwdTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("wrongpassword");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username is required", errorMessage.getText());
    }

    // TC10: username and pwd placeholder
    @Test
    public void usernameAndPwdPlaceholderTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        String usernamePlaceholderValue = usernameInput.getAttribute("placeholder");
        WebElement pwdInput = driver.findElement(By.id("password"));
        String pwdPlaceholderValue = pwdInput.getAttribute("placeholder");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Username", usernamePlaceholderValue);
        Assert.assertEquals("Password", pwdPlaceholderValue);
    }

    // TC11: username and pwd placeholder
    @Test
    public void isPasswordFieldPwdTypeTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement pwdInput = driver.findElement(By.id("password"));
        String pwdPlaceholderValue = pwdInput.getAttribute("type");
        Thread.sleep(2000);

        Assert.assertEquals("password", pwdPlaceholderValue);
    }
}
