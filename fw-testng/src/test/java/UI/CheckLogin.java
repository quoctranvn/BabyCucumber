package UI;

import com.qt.core.config.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;

public class CheckLogin extends BasePage {

    @Test
    public void test() {
        WebDriver webDriver = WebDriverFactory.instance().getWebDriver();
        webDriver.get("http://automationpractice.com/index.php");

        loginPage.clickLogin();

        loginPage.enterUserNamedAndPassWord();
        loginPage.clickSubmit();

        loginPage.verifyInfo();
    }
}
