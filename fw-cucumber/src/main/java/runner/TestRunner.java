package runner;


import com.qt.core.config.driver.WebDriverFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"stepdefs", "hooks"},
        plugin = { "pretty", "html:target/cucumber-html-reports"}
)

public class TestRunner {
    public static WebDriver webDriver = new WebDriverFactory().getWebDriver();

    @BeforeClass
    public static void beforeSuite() {
        System.out.println("**************** BEFORE SUITE");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void afterSuite() {
        System.out.println("**************** AFTER SUITE");
        webDriver.quit();
    }
}
