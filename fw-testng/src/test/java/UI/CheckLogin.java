package UI;

import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LoginPage;

public class CheckLogin extends BaseTest{

    @Test
    public void test() {
        LoginPage loginPage = new LoginPage();
        loginPage.openHomePage();
        loginPage.clickLogin();
        loginPage.enterUserNamedAndPassWord();
        loginPage.clickSubmit();
        loginPage.verifyInfo();
    }
}
