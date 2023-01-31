package hu.progmatic.exampletests;

import hu.progmatic.driverfactory.DriverBaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabsLoginPage extends DriverBaseTest {

    // TC1: valid username empty pwd
    @Test
    public void validUsernameEmptyPwdTest() throws InterruptedException {
       // driver.get("");
        driver.navigate().to("https://www.saucedemo.com");

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

    }

    // TC2: empty username valid pwd
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

    @Test
    public void emptyUsernameEmptyPwdTest() throws InterruptedException {

        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("");
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username is required", errorMessage.getText());
    }
    @Test
    public void validUsernameWrongPWDTest() throws InterruptedException {

        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("1234");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",
                errorMessage.getText());
    }

    @Test
    public void wrongUsernameValidPWDTest() throws InterruptedException {

        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_use1234r");
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",
                errorMessage.getText());
    }
    @Test
    public void wrongUsernameWrongPWDTest() throws InterruptedException {


        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));

        usernameInput.sendKeys("standard_use1234r");
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("secret_sauce1234");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",
                errorMessage.getText());

    }
    @Test
    public void wrongPlaceholder() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.getAttribute("Placeholder");

       // usernameInput.sendKeys("standard_use1234r");
        WebElement pwdInput = driver.findElement(By.id("password"));
       // pwdInput.sendKeys("secret_sauce1234");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals("Username",
                usernameInput.getAttribute("Placeholder"));;
    }
    @Test
    public void pWDMasked() throws InterruptedException {
        driver.get("https://www.saucedemo.com");

        WebElement pwdInput = driver.findElement(By.id("password"));

        Thread.sleep(2000);
        Assert.assertEquals("password",
                pwdInput.getAttribute("type"));;
    }
}
