package pages;

import driverbase.LogWriter;
import jsonDTO.LoginData;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class LoginPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    LogWriter fileLogging;
    By userLoginName = By.id("usrloginname");
    By userPwd = By.id("usrpassword");

    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }
    public void loginButtonTest() throws InterruptedException {
        driver.get("https://www.szamlazz.hu/szamla/main");
        WebElement belepes = driver.findElement(By.xpath("/html/body/header/div/div[1]/div/div/div[2]/a"));
        belepes.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.szamlazz.hu/szamla/login");
        }
    public void loginTryWithWrongUsernameAndWrongPwd() throws InterruptedException {

        driver.get("https://www.szamlazz.hu/szamla/login");
        WebElement user = driver.findElement(userLoginName);
        user.sendKeys("WrongUser");
        WebElement pwd = driver.findElement(userPwd);
        pwd.sendKeys("WrongPwd");
        WebElement button = driver.findElement(By.id("myCaptchaButton"));
        button.click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/form/div[1]"));
        Assert.assertEquals(errorMessage.getText(),"Sikertelen bejelentkezés.");
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + " method: loginTryWithWrongUsernameAndWrongPwd"+ "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }
    public void loginWithGoogleAccount(){
        driver.get("https://www.szamlazz.hu/szamla/login");
        WebElement googleButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div/a[3]"));
        googleButton.click();
        WebElement headerElement = driver.findElement(By.xpath("//*[@id=\"initialView\"]/div[2]/div/div[1]/div/div[2]"));
        Assert.assertTrue(headerElement.isDisplayed());
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + " method: loginWithGoogleAccount" + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }
    public void loginWithFbAccount() throws InterruptedException {
        driver.get("https://www.szamlazz.hu/szamla/login");
        WebElement facebookButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div/a[2]"));
        facebookButton.click();
        Thread.sleep(1000);
        WebElement facebookLogoLink = driver.findElement(By.partialLinkText("Facebook"));
        Assert.assertTrue(facebookLogoLink.isDisplayed());
        fileLogging = new LogWriter();
        String feedback =": Execution finished -- " + getClass() + " method: loginWithFbAccount" + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }
    public void loginWithCorrectUsernameWrongPwd() throws InterruptedException {
        driver.get("https://www.szamlazz.hu/szamla/login");
        WebElement user = driver.findElement(userLoginName);
        user.sendKeys("demo");
        WebElement pwd = driver.findElement(userPwd);
        pwd.sendKeys("wrong");
        WebElement button = driver.findElement(By.id("myCaptchaButton"));
        button.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/form/div[1]"));
        Assert.assertEquals(errorMessage.getText(),"Sikertelen bejelentkezés.");
        fileLogging = new LogWriter();
        String feedback =": Execution finished -- " + getClass() + " method: loginWithCorrectUsernameWrongPwd" + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }
    public void loginWithWrongUsernameCorrectPwd() throws InterruptedException {
        driver.get("https://www.szamlazz.hu/szamla/login");
        WebElement user = driver.findElement(userLoginName);
        user.sendKeys("wrongUserName");
        WebElement pwd = driver.findElement(userPwd);
        pwd.sendKeys("demo");
        WebElement button = driver.findElement(By.id("myCaptchaButton"));
        button.click();
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/form/div[1]"));
        Assert.assertEquals(errorMessage.getText(),"Sikertelen bejelentkezés.");
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + " method: loginWithCorrectUsernameWrongPwd" + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }
    public void loginWithCorrectUsernameCorrectPwd(String userName, String password) throws InterruptedException {
        driver.get("https://www.szamlazz.hu/szamla/login");
        WebElement user = driver.findElement(userLoginName);
        user.sendKeys(userName);
        WebElement pwd = driver.findElement(userPwd);
        pwd.sendKeys(password);
        WebElement button = driver.findElement(By.id("myCaptchaButton"));
        button.click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.szamlazz.hu/szamla/");
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + " method: loginWithWrongUsernameCorrectPwd" + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);

    }
    public void registrationButtonTest() throws InterruptedException {
        driver.get("https://www.szamlazz.hu/szamla/login");
        WebElement reg = driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]/a"));
        Thread.sleep(2000);
        reg.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.szamlazz.hu/szamla/?page=regisztracio");
        Thread.sleep(2000);
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + " method: loginWithWrongUsernameCorrectPwd" + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }
    public LoginData json() throws IOException {
        Path filePath = Path.of("src/test/resources/loginData.json");
        String content = Files.readString(filePath);
        System.out.println(content);
        Gson g = new Gson();
        return g.fromJson(content, LoginData.class);
    }
}
