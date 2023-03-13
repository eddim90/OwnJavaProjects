package pages;

import driverbase.LogWriter;
import jsonDTO.NewInvoiceData;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewInvoicePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    LogWriter fileLogging;
    By createInvoiceButton = By.id("button_ment");
    By taxAAM = By.xpath("//*[@id=\"dk_container_afak_1\"]/div/ul/li[5]/a");

    By errorPopUpOkButton = By.xpath("/html/body/div[11]/div[3]/div/button");
    By invoicePopUpOkButton = By.xpath("/html/body/div[11]/div[3]/div/button[2]/span");

    By tryItButton = By.xpath("/html/body/main/section[1]/div/div/div[1]/div[1]/div[3]/a/span");
    By newInvoice = By.xpath("//*[@id=\"inner-content\"]/div[2]/div[1]/a");
    By taxDropdownBy = By.id("dk_container_afak_1");
    By summary = By.id("inv-summary");
    By partnerN = By.id("partnername");
    By city = By.id("partnercity");

    By adress = By.id("partneraddr2");

    By item = By.id("item_1");
    By qty = By.id("menny_1");

    By nPrice = By.id("nettegysar_1");
    By bPrice = By.id("brutegysar_1");
    By bnChangeButton = By.id("switch_nettegysar_brutegysar_title");

    By preview = By.id("button_elonezet");

    By returnB = By.xpath("//*[@id=\"szamlaNezetElonezetGombsor\"]/a[1]");

    By draft = By.id("button_piszkozat");
    By exit = By.id("buttonPdfPreviewBezarom");

    By draftSave = By.xpath("//*[@id=\"szamla-piszkozat-button-ment\"]");

    public NewInvoicePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        actions = new Actions(driver);
    }

    public void logWriter() {
        fileLogging = new LogWriter();
        String feedback = ": Execution finished -- " + getClass() + "\n";
        fileLogging.dataWriter(feedback);
        System.out.println(feedback);
    }

    public void chooseTaxAAM() throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement summaryHead = driver.findElement(summary);
        js.executeScript("arguments[0].scrollIntoView(true);", summaryHead);
        WebElement taxChooser = driver.findElement(taxDropdownBy);
        taxChooser.click();
        WebElement aamTax = driver.findElement(taxAAM);
        aamTax.click();
        System.out.println("selected tax is AAM");
    }

    public void pushTheCreateInvoiceButton() {
        WebElement newInvoiceButton = driver.findElement(createInvoiceButton);
        newInvoiceButton.click();
    }

    public void popUpCleaner(String byThing) {
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(errorPopUpOkButton)));
        okButton.click();
        driver.findElement(By.id(byThing)).equals(driver.switchTo().activeElement());
        System.out.println("Error popup window ready. The cursor jump the excepted field.");
    }
    public void invoicePopUpCleaner() {
        WebElement popUp = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[10]"))));
        Assert.assertTrue(popUp.isDisplayed());
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(invoicePopUpOkButton)));
        okButton.click();
        System.out.println("The invoice made by szamlazz.hu ");
    }

    public void loadTheNewInvoicePage() {
        driver.get("https://szamlazz.hu");
        WebElement tryButton = driver.findElement(tryItButton);
        tryButton.click();
        WebElement newInvoiceButton = driver.findElement(newInvoice);
        newInvoiceButton.click();
    }

    public void fillTheCompanyName(String companyName) {
        WebElement partnerName = driver.findElement(partnerN);
        partnerName.sendKeys(companyName);
    }

    public void fillTheCity(String cityName) {
        WebElement partnerCity = driver.findElement(city);
        partnerCity.sendKeys(cityName);
    }

    public void fillTheAdress(String adressName) {
        WebElement adressField = driver.findElement(adress);
        adressField.sendKeys(adressName);
    }

    public void fillTheItemName(String itemName) {
        WebElement itemField = driver.findElement(item);
        itemField.sendKeys(itemName);
    }

    public void emptyQty() {
        WebElement qtyField = driver.findElement(qty);
        qtyField.clear();
    }

    public void fillQty(String quantity) {
        WebElement qtyField = driver.findElement(qty);
        qtyField.clear();
        qtyField.sendKeys(quantity);
    }

    public void fillPrice(String itemPrice) {
        String button;
        WebElement nettoBruttoChangerButton = driver.findElement(bnChangeButton);
        button = nettoBruttoChangerButton.getText();
        if (button.equals("Bruttó egységár")) {
            WebElement priceField = driver.findElement(bPrice);
            priceField.sendKeys(itemPrice);
        } else {
            WebElement priceField = driver.findElement(nPrice);
            priceField.sendKeys(itemPrice);
        }
    }

    public void previewButtonClick() {
        WebElement previewButton = driver.findElement(preview);
        previewButton.click();
    }

    public void returnButtonClick() {
        WebElement returnButton = driver.findElement(returnB);
        returnButton.click();
    }

    public void draftButtonClick() {
        WebElement draftButton = driver.findElement(draft);
        draftButton.click();
    }
    public void exitButtonClick() {
        WebElement exitButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(exit)));
        exitButton.click();
    }

    public void draftSaveButtonClick() {
        WebElement draftSaveButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(draftSave)));

        draftSaveButton.click();
    }

    public void invoiceTypeChooser() {
        WebElement invoiceTypeChooser = driver.findElement(By.xpath("//*[@id=\"dk_container_szfejeszamla\"]/a"));
        invoiceTypeChooser.click();
        WebElement eInvoice = driver.findElement(By.xpath("//*[@id=\"dk_container_szfejeszamla\"]/div/ul/li[2]/a"));
        eInvoice.click();
        System.out.println("selected invoice type is e-Invoice");
    }

    public void unitPriceChanger() {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement summaryHead = driver.findElement(summary);
        js.executeScript("arguments[0].scrollIntoView(true);", summaryHead);
        String button;
        WebElement nettoBruttoChangerButton = driver.findElement(bnChangeButton);
        button = nettoBruttoChangerButton.getText();
        if (button.equals("Bruttó egységár")) {
            WebElement priceField = driver.findElement(bPrice);
            priceField.click();
            System.out.println("The default was 'Bruttó egységár', and changed 'Nettó egységár'");
        } else {
            WebElement priceField = driver.findElement(nPrice);
            priceField.click();
            System.out.println("The default was 'Nettó egységár', and changed 'Bruttó egységár'");
        }

    }
    public void changeProformaButton(){
        WebElement proformaChangerButton = driver.findElement(By.id("typeD"));
        proformaChangerButton.click();
    }

    public void changeDepositeButton(){
        WebElement depositeChangeButton = driver.findElement(By.id("typeES"));
        depositeChangeButton.click();
    }

    public NewInvoiceData json() throws IOException {
        Path filePath = Path.of("src/test/resources/data.json");
        String content = Files.readString(filePath);
        System.out.println(content);
        Gson g = new Gson();
        return g.fromJson(content, NewInvoiceData.class);
    }

}
