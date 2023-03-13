package pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class PwdReminderPageForCucumber {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(30000));
        driver.manage().window().maximize();
        //Deleting all the cookies
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(30000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
        System.out.println("Test case execution started");
    }

    @After
    public void driverCleanUp() {
        driver.quit();
        System.out.println("Test case execution finished");
    }

    @Given("I am on the {string} site")
    public void loginPageLoadIn(String url) {
        driver.get(url);
    }

    @When("I click on the {string} button")
    public void clickOnButton(String button) throws InterruptedException {
        WebElement forgotPwdLink = driver.findElement(By.linkText(button));
        forgotPwdLink.click();
        Thread.sleep(1000);
    }

    @Then("It redirects to the {string}")
    public void validatePage(String url2) {
        Assert.assertEquals(driver.getCurrentUrl(), url2);
    }

    @Given("I am on the {string} page")
    public void pageload(String url) {
        driver.get(url);
    }

    @When("I try to {string} in wrong format")
    public void insertWrongType(String text) {
        WebElement userEmail = driver.findElement(By.id("usremail"));
        userEmail.sendKeys(text);
    }
    @When("the e-mail address field is {string} and I click on the send button")
    public void emptyEmailField(String text) throws InterruptedException {
        WebElement userEmail = driver.findElement(By.id("usremail"));
        userEmail.sendKeys(text);
        WebElement sendButton = driver.findElement(By.id("btnCaptchaSubmit"));
        sendButton.click();
    }
    @Then("the page {string} pops up")
    public void errorMessageCheck(String errorMessage) throws InterruptedException {
        WebElement sendButton = driver.findElement(By.id("btnCaptchaSubmit"));
        sendButton.click();
        Thread.sleep(1400);
        WebElement error = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[2]/div/div[2]"));
        Assert.assertEquals(error.getText(), errorMessage);
    }
    @When("I try to click on the 'Vissza a bejelentkezéshez' button")
    public void returnBackToHomePageButton() throws InterruptedException {
        WebElement returnBackToHomePage = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a"));
        returnBackToHomePage.click();
        Thread.sleep(1000);
    }
    @Then("the page redirects {string} site")
            public void validatePageButton(String url){
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
}
