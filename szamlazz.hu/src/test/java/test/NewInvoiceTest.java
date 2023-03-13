package test;

import driverbase.DriverBase;
import jsonDTO.NewInvoiceData;
import pages.NewInvoicePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class NewInvoiceTest extends DriverBase {
    NewInvoicePage newInvoicePage;


    @Test(description = "Test with missing company name, code: DD-T28", groups = {"newInvoice"})
    public void missingCompanyNameTest() throws InterruptedException {
        newInvoicePage = new NewInvoicePage(driver, wait);
        newInvoicePage.loadTheNewInvoicePage();
        newInvoicePage.chooseTaxAAM();
        newInvoicePage.pushTheCreateInvoiceButton();
        Thread.sleep(2000);
        newInvoicePage.popUpCleaner("partnername");
        Thread.sleep(2000);
        newInvoicePage.logWriter();

    }

    @Test(description = "Test with missing City, code: DD-T47", groups = {"newInvoice"})
    public void missingCityNameTest() throws InterruptedException, IOException {
        newInvoicePage = new NewInvoicePage(driver, wait);
        NewInvoiceData data = newInvoicePage.json();
        newInvoicePage.loadTheNewInvoicePage();
        newInvoicePage.fillTheCompanyName(data.getCompanyName());
        newInvoicePage.chooseTaxAAM();
        newInvoicePage.pushTheCreateInvoiceButton();
        Thread.sleep(2000);
        newInvoicePage.popUpCleaner("partnercity");
        newInvoicePage.logWriter();
    }

    @Test(description = "Test with missing street, code: DD-T48", groups = {"newInvoice"})
    public void missingStreetNameTest() throws InterruptedException, IOException {
        newInvoicePage = new NewInvoicePage(driver, wait);
        NewInvoiceData data = newInvoicePage.json();
        newInvoicePage.loadTheNewInvoicePage();
        newInvoicePage.fillTheCompanyName(data.getCompanyName());
        newInvoicePage.fillTheCity(data.getCity());
        newInvoicePage.chooseTaxAAM();
        newInvoicePage.pushTheCreateInvoiceButton();
        Thread.sleep(2000);
        newInvoicePage.popUpCleaner("partneraddr2");
        newInvoicePage.logWriter();
    }

    @Test(description = "Test with missing Item name, code: DD-T29", groups = {"newInvoice"})
    public void missingItemNameTest() throws InterruptedException, IOException {
        newInvoicePage = new NewInvoicePage(driver, wait);
        NewInvoiceData data = newInvoicePage.json();
        newInvoicePage.loadTheNewInvoicePage();
        newInvoicePage.fillTheCompanyName(data.getCompanyName());
        newInvoicePage.fillTheCity(data.getCity());
        newInvoicePage.fillTheAdress(data.getAdressName());
        newInvoicePage.chooseTaxAAM();
        newInvoicePage.pushTheCreateInvoiceButton();
        Thread.sleep(2000);
        newInvoicePage.popUpCleaner("item_1");
        newInvoicePage.logWriter();
    }


    @Test(description = "Test with missing quantity, code: DD-T30", groups = {"newInvoice"})
    public void missingQtyTest() throws InterruptedException, IOException {
        newInvoicePage = new NewInvoicePage(driver, wait);
        NewInvoiceData data = newInvoicePage.json();
        newInvoicePage.loadTheNewInvoicePage();
        newInvoicePage.fillTheCompanyName(data.getCompanyName());
        newInvoicePage.fillTheCity(data.getCity());
        newInvoicePage.fillTheAdress(data.getAdressName());
        newInvoicePage.fillTheItemName(data.getItemName());
        newInvoicePage.chooseTaxAAM();
        Thread.sleep(2000);
        newInvoicePage.emptyQty();
        newInvoicePage.pushTheCreateInvoiceButton();
        Thread.sleep(2000);
        newInvoicePage.popUpCleaner("menny_1");
        newInvoicePage.logWriter();
    }

    @Test(description = "Test the preview button work, code: DD-T45", groups = {"newInvoice","smoke"})
    public void previewButtonTest() throws InterruptedException, IOException {
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
        Thread.sleep(2000);
        newInvoicePage.previewButtonClick();
        Thread.sleep(4000);
        newInvoicePage.returnButtonClick();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.szamlazz.hu/szamla/?page=szamlaszerkeszto");
        System.out.println("The return button works, and we can continue the invoice fill.");
        newInvoicePage.logWriter();
    }

    @Test(description = "Test the draft button work, code: DD-T45", groups = {"newInvoice"})
    public void draftButtonTest() throws InterruptedException, IOException {
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
        newInvoicePage.draftButtonClick();
        Thread.sleep(2000);
        newInvoicePage.draftSaveButtonClick();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.szamlazz.hu/szamla/?page=piszkozatkereso");
        System.out.println("The return button works, and we can continue the invoice fill.");
        newInvoicePage.logWriter();
    }

    @Test(description = "Test for choosing an other type of invoice, code: DD-T36", groups = {"newInvoice"})
    public void invoiceTypeChooserTest() {
        newInvoicePage = new NewInvoicePage(driver, wait);
        newInvoicePage.loadTheNewInvoicePage();
        newInvoicePage.invoiceTypeChooser();
    }

    @Test(description = "Test for the unitprice changer, code: DD-T45", groups = {"newInvoice"})
    public void unitPriceChangerTest() {
        newInvoicePage = new NewInvoicePage(driver, wait);
        newInvoicePage.loadTheNewInvoicePage();
        newInvoicePage.unitPriceChanger();
    }


}
