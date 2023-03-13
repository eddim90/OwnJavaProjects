package pages;

import driverbase.LogWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PwdReminderPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected LogWriter fileLogging;

    public PwdReminderPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }
    public void forgotPageLoadIn() throws InterruptedException {
        driver.get("https://www.szamlazz.hu/szamla/login");
        WebElement forgotPwdLink = driver.findElement(By.linkText("Elfelejtetted a jelszavad?"));
        forgotPwdLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.szamlazz.hu/szamla/?page=forgetpassword");
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + " method: forgotPageLoadIn" + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }

    public void wrongEmailFormatType() throws InterruptedException {
        WebElement userEmail = driver.findElement(By.id("usremail"));
        userEmail.sendKeys("WrongEmailFormat");
        WebElement sendButton = driver.findElement(By.id("btnCaptchaSubmit"));
        sendButton.click();
        Thread.sleep(1400);
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[2]/div/div[2]"));
        Assert.assertEquals(errorMessage.getText(), "Ez nem tűnik valós e-mail címnek.");
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + " method: wrongEmailFormatType" + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }

    public void emptyEmailField() throws InterruptedException {
        WebElement userEmail = driver.findElement(By.id("usremail"));
        userEmail.sendKeys("");
        WebElement sendButton = driver.findElement(By.id("btnCaptchaSubmit"));
        sendButton.click();
        Thread.sleep(1400);
        WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[2]/div/div[2]"));
        Assert.assertEquals(errorMessage.getText(), "Érvénytelen email-cím!");
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + " method: emptyEmailField" + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }

    public void returnBackToHomePageButton() throws InterruptedException {
        WebElement returnBackToHomePage = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a"));
        returnBackToHomePage.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.szamlazz.hu/szamla/?page=login");
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + " method: returnBackToHomePageButton" + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }
}
