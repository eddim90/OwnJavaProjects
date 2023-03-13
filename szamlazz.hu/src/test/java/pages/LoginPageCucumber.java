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

public class LoginPageCucumber {

    WebDriver driver;
    WebDriverWait wait;
    By userLoginName = By.id("usrloginname");
    By userPwd = By.id("usrpassword");

    @Before
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe" );
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(30000));
        driver.manage().window().maximize();
        //Deleting all the cookies
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(30000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
        System.out.println("Test case execution started" );
    }

    @After
    public void driverCleanUp() {
        driver.quit();
        System.out.println("Test case execution finished" );
    }

    @Given("I go to the home {string} page" )
    public void loginPage(String url) {
        driver.get(url);
    }

    @When("I click on {string} button" )
    public void clickOnLoginButton(String button) throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/header/div/div[1]/div/div/div[2]/a" ));
        loginButton.click();
        Thread.sleep(1000);
    }

    @Then("it redirects me to {string} page" )
    public void validateLoginPage(String url2) {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.szamlazz.hu/szamla/login" );
    }

    @When("When I insert the {string} and {string} and click on the {string} button" )
    public void leaveFieldsEmpty(String username, String pwd, String button) throws InterruptedException {
        WebElement user = driver.findElement(userLoginName);
        user.sendKeys(username);
        WebElement passwordField = driver.findElement(userPwd);
        passwordField.sendKeys(pwd);
        WebElement buttonToFind = driver.findElement(By.id("myCaptchaButton"));
        buttonToFind.click();
        Thread.sleep(3000);
    }
    @Then("Then error message should be the following:{string}")
    public void validateAssert(String errorMessageText){
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/form/div[1]"));
        Assert.assertEquals(errorMessage.getText(),errorMessageText);
    }
    @When("I choose and click on the {string} button")
    public void googleButtonClick(String button){
        WebElement googleButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div/a[3]"));
        googleButton.click();
    }
    @Then("I should see the {string} in a new window")
    public void googleURLValidation(String google){
        WebElement headerElement = driver.findElement(By.xpath("//*[@id=\"initialView\"]/div[2]/div/div[1]/div/div[2]"));
        Assert.assertTrue(headerElement.isDisplayed());
    }

    @When("The user choose and click on the {string} button")
    public void facebookButtonClick(String facebook){
        WebElement facebookButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div/a[2]"));
        facebookButton.click();
    }
    @Then("I should see the facebook page {string} in a new window")
    public void facebookURLValidation(String facebookButton){
        WebElement facebookLogoLink = driver.findElement(By.partialLinkText("Facebook"));
        Assert.assertTrue(facebookLogoLink.isDisplayed());
    }

    @Then("The system should let the user in")
    public void validateLoginEnter(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.szamlazz.hu/szamla/");
    }
    @When("The user finds and click on {string} button")
    public void registrationButtonValidation(String button) throws InterruptedException {
        WebElement reg = driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]/a"));
        Thread.sleep(2000);
        reg.click();
    }
    @Then("The user should see the {string} after redirection")
    public void validateRegistrationPage(String url){
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

}

