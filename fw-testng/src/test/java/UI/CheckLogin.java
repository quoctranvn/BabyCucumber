package UI;

import com.qt.core.config.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static pages.BasePage.loginPage;

public class CheckLogin {

    private WebDriver webDriver;

    @BeforeTest
    @Parameters("browser")
    private void beforeTest(String browser) {
        webDriver = WebDriverFactory.instance().createWebDriver(browser);
    }

    @AfterTest
    private void afterTest() {
        WebDriverFactory.instance().disposeWebDriver();
    }

    @Test
    public void test() {
        webDriver.get("http://automationpractice.com/index.php");

        loginPage.clickLogin();

        loginPage.enterUserNamedAndPassWord();
        loginPage.clickSubmit();

        loginPage.verifyInfo();
    }
}
