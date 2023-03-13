package test;

import driverbase.DriverBase;
import pages.PwdReminderPage;
import org.testng.annotations.Test;

public class PwdReminderTest extends DriverBase {

    PwdReminderPage pwdReminder;

    @Test(description = "Password reminder button test", groups = {"pwdTest","smoke"})
    public void pwdReminderButton() throws InterruptedException {
        pwdReminder = new PwdReminderPage(driver, wait, actions);
        pwdReminder.forgotPageLoadIn();
    }
    @Test(description = "Testing the e-mail format input field, if the format is not correct", groups = {"pwdTest"})
    public void pwdReminderWrongEmailFormat() throws InterruptedException {
        pwdReminder = new PwdReminderPage(driver, wait, actions);
        pwdReminder.forgotPageLoadIn();
        pwdReminder.wrongEmailFormatType();
    }
    @Test(description = "Email field is empty", groups = {"pwdTest"})
    public void emailReminderEmptyfield() throws InterruptedException {
        pwdReminder = new PwdReminderPage(driver, wait, actions);
        pwdReminder.forgotPageLoadIn();
        pwdReminder.emptyEmailField();
    }    @Test(description = "Check if the home page button works and redirects", groups = {"pwdTest"})
    public void pwdReminderPageBackToHomePageButton() throws InterruptedException {
        pwdReminder = new PwdReminderPage(driver, wait, actions);
        pwdReminder.forgotPageLoadIn();
        pwdReminder.returnBackToHomePageButton();
    }
}
