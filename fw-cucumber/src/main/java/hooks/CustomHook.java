package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import runner.TestRunner;

public class CustomHook {
    private WebDriver webDriver = TestRunner.webDriver;

    @Before
    public void beforeScenario() {
        System.out.println("******** BEFORE SCENARIO");
        webDriver.get("http://automationpractice.com/index.php");
    }

    @After
    public void afterScenario() {
        System.out.println("******** AFTER SCENARIO");
        webDriver.close();
    }
}
