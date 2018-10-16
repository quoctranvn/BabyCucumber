package hooks;

import com.qt.core.config.driver.WebDriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class CustomHook {
    private WebDriver webDriver = WebDriverFactory.instance().getWebDriver();

    @Before
    public void beforeScenario() {
        System.out.println("******** BEFORE SCENARIO");
        webDriver.get("http://automationpractice.com/index.php");
    }

    @After
    public void afterScenario() {
        System.out.println("******** AFTER SCENARIO");
    }
}
