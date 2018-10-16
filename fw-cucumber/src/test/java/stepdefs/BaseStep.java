package stepdefs;

import com.qt.core.config.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import static com.qt.core.config.element.factory.ElementFactory.initElements;

class BaseStep {

    private static WebDriver webDriver = WebDriverFactory.instance().getWebDriver();

    static final pages.LoginPage loginPage = initElements(webDriver, pages.LoginPage.class);
}
