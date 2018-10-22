package UI;

import org.testng.annotations.Test;
import pages.BasePage;

public class CheckLogin extends BasePage {

    @Test
    public void test() {
        webDriver.get("http://automationpractice.com/index.php");

        loginPage.clickLogin();

        loginPage.enterUserNamedAndPassWord();
        loginPage.clickSubmit();

        loginPage.verifyInfo();
    }
}
