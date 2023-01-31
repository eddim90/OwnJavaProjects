package hu.progmatic.swaglabs;

import hu.progmatic.driverfactory.DriverBaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ProductScreenTests extends DriverBaseTest {

    @BeforeMethod
    public void createSession() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        login();
    }

    @Test
    public void defaultSortOptionTest() throws InterruptedException {
        WebElement selectedFilterOption = driver.findElement(By.xpath("//div[@class='right_component']//span[@class='active_option']"));
        Assert.assertEquals("NAME (A TO Z)", selectedFilterOption.getText());
    }

    @Test
    public void firstItemInAToZDraftTest() throws InterruptedException {
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        String firstItemTitle = items.get(0).getText();
        Assert.assertEquals("Sauce Labs Backpack", firstItemTitle);
    }

    @Test
    public void firstItemInAToZTest() throws InterruptedException {
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        /*for (WebElement item : items) {
            System.out.println(item.getText());
        }*/
        String firstItemTitle = items.get(0).getText();
        Assert.assertEquals("Sauce Labs Backpack", firstItemTitle);
    }

    @Test
    public void firstItemInZToATest() throws InterruptedException {
        Select sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByVisibleText("Name (Z to A)");
        Thread.sleep(2000);
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        String firstItemTitle = items.get(0).getText();
        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", firstItemTitle);
    }

    @Test
    public void firstItemInZToAV2Test() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.cssSelector("option[value='za']"));
        dropdownElement.click();
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        String firstItemTitle = items.get(0).getText();
        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", firstItemTitle);
    }

    @Test
    public void firstItemInZToAV3Test() throws InterruptedException {
        Select selectByValue = new Select(driver.findElement(By.className("product_sort_container")));
        selectByValue.selectByValue("za");
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        String firstItemTitle = items.get(0).getText();
        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", firstItemTitle);
    }

    @Test
    public void firstItemInZToAV4Test() throws InterruptedException {
        WebElement drowdown = driver.findElement(By.xpath("//select/option[2]"));
        drowdown.click();
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        String firstItemTitle = items.get(0).getText();
        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)", firstItemTitle);
    }

    @Test
    public void firstItemInLowToHighTest() throws InterruptedException {
        Select sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByVisibleText("Price (low to high)");
        Thread.sleep(2000);
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        String firstItemTitle = items.get(0).getText();
        Assert.assertEquals("Sauce Labs Onesie", firstItemTitle);
    }

    @Test
    public void firstItemInHighToLowTest() throws InterruptedException {
        Select sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByVisibleText("Price (high to low)");
        Thread.sleep(2000);
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        String firstItemTitle = items.get(0).getText();
        Assert.assertEquals("Sauce Labs Fleece Jacket", firstItemTitle);
    }

    @Test
    public void clickOnItemPictureAndRedirectTest() throws InterruptedException {
        WebElement itemPicture = driver.findElement(By.cssSelector("img[alt='Sauce Labs Backpack']"));
        itemPicture.click();
        Assert.assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", driver.getCurrentUrl());
    }

    @Test
    public void clickOnItemTitleAndRedirectTest() throws InterruptedException {
        WebElement itemPicture = driver.findElement(By.linkText("Sauce Labs Backpack"));
        itemPicture.click();
        //WebElement backToProductsButton = driver.findElement(By.id("back-to-products"));
        //WebElement backToProductsButton = driver.findElement(By.cssSelector("button[data-test='back-to-products']"));
        //WebElement backToProductsButton = driver.findElement(By.name("back-to-products"));
        WebElement backToProductsButton = driver.findElement(By.xpath("//*[@id='back-to-products']"));
        Assert.assertTrue(backToProductsButton.isDisplayed());
    }

    @Test
    public void addMultipleItemsToCartBadgeTest() {
        WebElement backpackAddButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        backpackAddButton.click();
        WebElement onesieAddButton = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        onesieAddButton.click();
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        //System.out.println(cartBadge.getText());
        //String badgeValue = cartBadge.getText();
        Assert.assertEquals("2", cartBadge.getText());

    }

    @Test
    public void checkAddToCartButtonTextChangeOnClick() {
        WebElement backpackAddButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        backpackAddButton.click();
        WebElement itemFirstCartRemoveButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        Assert.assertEquals("REMOVE", itemFirstCartRemoveButton.getText());
    }

    @Test
    public void checkCartIconChangesBackToOriginalOnItemRemoval() {
        WebElement backpackAddButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        backpackAddButton.click();
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertEquals("1", cartIcon.getText());
        WebElement itemFirstCartRemoveButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        itemFirstCartRemoveButton.click();
        Assert.assertEquals("", cartIcon.getText());
    }

    @Test
    public void checkNumberOfItemsOnCartIconDecreaseOnItemRemoval() {
        WebElement backpackAddButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        backpackAddButton.click();
        WebElement bikeLighAddButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        bikeLighAddButton.click();

        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertEquals("2", cartIcon.getText());

        WebElement itemFirstCartRemoveButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        itemFirstCartRemoveButton.click();
        Assert.assertEquals("1", cartIcon.getText());
    }

    @Test
    public void cartPageDoesNotShowRemovedItem() {
        WebElement backpackAddButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        backpackAddButton.click();
        WebElement bikeLighAddButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        bikeLighAddButton.click();

        WebElement itemFirstCartRemoveButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        itemFirstCartRemoveButton.click();
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        Assert.assertEquals(1, cartItems.size());
        WebElement cartItem = cartItems.get(0).findElement(By.className("inventory_item_name"));
        Assert.assertEquals("Sauce Labs Bike Light", cartItem.getText());
    }

    @Test
    public void cartIconNavigationTest() {
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());
    }

    @Test
    public void allItemMenuitemTest() {
        WebElement itemPicture = driver.findElement(By.linkText("Sauce Labs Backpack"));
        itemPicture.click();
        WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
        menu.click();
        WebElement allItemsMenuItem = driver.findElement(By.id("inventory_sidebar_link"));
        allItemsMenuItem.click();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
    }

    private void login() throws InterruptedException {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        WebElement pwdInput = driver.findElement(By.id("password"));
        pwdInput.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        // check landing page
        Thread.sleep(2000);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

}
