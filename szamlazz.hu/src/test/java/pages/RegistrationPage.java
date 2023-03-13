package pages;

import jsonDTO.RegistrationData;
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
import java.util.List;

public class RegistrationPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    By registracionB = By.xpath("/html/body/main/section[1]/div/div/div[1]/div[1]/div[1]/a");
    By registButton = By.id("myCaptchaReg");

    By fname = By.id("usrvezeteknev");

    By sname = By.id("usrkeresztnev");

    By emailf = By.id("usremail");
    By pwd = By.id("usrpassword1");
    By pwd2 = By.id("usrpassword2");
    By szamlazz = By.xpath("//*[@id=\"container\"]/header/div/div/a[1]/img");

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        actions = new Actions(driver);
    }

    public void goToTheRegistrationPage() {
        driver.get("https://www.szamlazz.hu/szamla/main");
        WebElement registrationButton = driver.findElement(registracionB);
        registrationButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.szamlazz.hu/szamla/regisztracio");
    }

    public void clickToRegistrationButton() {
        WebElement registrationButton = driver.findElement(registButton);
        // az én gépemen görgetni kell itt a kijelzőt
        registrationButton.click();
    }

    public void allTheErrorMessageIsHere() {
        List<WebElement> errorMessages = driver.findElements(By.className("input-errorMessage"));
        Assert.assertEquals(10, errorMessages.size());
        System.out.println("The error messages detected.");
    }
    public void fillFirstNameField(String firstName){
        WebElement firstNameField = driver.findElement(fname);
        firstNameField.sendKeys(firstName);
    }
    public void fillSecondNameField(String secondName){
        WebElement secondNameField = driver.findElement(sname);
        secondNameField.sendKeys(secondName);
    }

    public void fillEmailField(String email){
        WebElement emailField = driver.findElement(emailf);
        emailField.sendKeys(email);
    }
    public void fillPWDField(String password){
        WebElement pwdField = driver.findElement(pwd);
        pwdField.sendKeys(password);
    }

    public void fillPWDField2(String password){
        WebElement pwdField2 = driver.findElement(pwd2);
        pwdField2.sendKeys(password);
    }

    public void clickSzamlazzHuButton(){
        WebElement szamlazzButton = driver.findElement(szamlazz);
        szamlazzButton.click();
    }

    public RegistrationData json() throws IOException {
        Path filePath = Path.of("src/test/resources/registrationData.json");
        String content = Files.readString(filePath);
        System.out.println(content);
        Gson g = new Gson();
        return g.fromJson(content, RegistrationData.class);
    }

}
