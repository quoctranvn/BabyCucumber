package UI;

import org.testng.annotations.Test;

import static pages.BasePage.loginPage;
import static pages.BasePage.webDriver;

public class CheckLogin {

    @Test
    public void user_is_on_homepage() {
        webDriver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void user_navigates_to_Login_Page() {
        loginPage.clickLogin();
    }

    @Test
    public void user_enters_username_and_Password() {
        loginPage.enterUserNamedAndPassWord();
        loginPage.clickSubmit();
    }

    @Test
    public void success_message_is_displayed() {
        loginPage.verifyInfo();
    }
}
