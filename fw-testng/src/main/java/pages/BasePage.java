package pages;

import com.qt.core.base.BaseExecutionTestNG;
import com.qt.core.config.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import static com.qt.core.config.element.factory.ElementFactory.initElements;

public class BasePage extends BaseExecutionTestNG {

    public static WebDriver webDriver = WebDriverFactory.instance().createWebDriver("chrome");

    public static pages.LoginPage loginPage = initElements(webDriver, pages.LoginPage.class);

}
