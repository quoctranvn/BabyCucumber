package pages;

import org.openqa.selenium.WebDriver;
import runner.TestRunner;

import static factory.ElementFactory.initElements;


public abstract class BasePage {
    private static WebDriver webDriver = TestRunner.webDriver;

    protected static LoginPage loginPage = initElements(webDriver, LoginPage.class);
}
