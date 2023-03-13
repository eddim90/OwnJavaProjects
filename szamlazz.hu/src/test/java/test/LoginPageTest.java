package test;

import driverbase.DriverBase;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends DriverBase {

    LoginPage loginPage;

    @Test
    public void loginPageLoad() throws InterruptedException {
        loginPage = new LoginPage(driver, wait, actions);
        loginPage.loginButtonTest();
    }

    @Test(description = "Login Page test with wrong inputs, both username and password", groups = {"login"})
    public void loginWithWrongInputs() throws InterruptedException {
        loginPage = new LoginPage(driver, wait, actions);
        loginPage.loginTryWithWrongUsernameAndWrongPwd();

    }

    @Test(description = "Login page test for google account login with google button", groups = {"login","smoke"})
    public void googleLogin() {
        loginPage = new LoginPage(driver, wait, actions);
        loginPage.loginWithGoogleAccount();
    }

    @Test(description = "Login page test for facebook account login with facebook button", groups = {"login","smoke"})
    public void facebookLogin() throws InterruptedException {
        loginPage = new LoginPage(driver, wait, actions);
        loginPage.loginWithFbAccount();
    }

    @Test(description = "Login page test for correct/ valid username but with wrong password", groups = {"login"})
    public void correctUserWrongPwd() throws InterruptedException {
        loginPage = new LoginPage(driver, wait, actions);
        loginPage.loginWithCorrectUsernameWrongPwd();
    }

    @Test(description = "Login page test for incorrect/ invalid username but with valid password", groups = {"login"})
    public void wrongUserCorrectPwd() throws InterruptedException {
        loginPage = new LoginPage(driver, wait, actions);
        loginPage.loginWithWrongUsernameCorrectPwd();
    }

    @Test(description = "Login page test for registration button, if it redirects to the registration page", groups = {"login"})
    public void registrationButton() throws InterruptedException {
        loginPage = new LoginPage(driver, wait, actions);
        loginPage.registrationButtonTest();
    }
}
