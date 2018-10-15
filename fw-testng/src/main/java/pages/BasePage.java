package pages;

import org.openqa.selenium.WebDriver;

import static com.qt.core.config.driver.WebDriverFactory.getWebDriver;
import static com.qt.core.config.element.factory.ElementFactory.initElements;

public class BasePage {

    public static final WebDriver webDriver = getWebDriver();

    public static final pages.LoginPage loginPage = initElements(webDriver, pages.LoginPage.class);
}
