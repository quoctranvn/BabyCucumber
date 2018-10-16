package runner;

import com.qt.core.config.driver.WebDriverFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"stepdefs", "hooks"},
        plugin = {"pretty", "html:target/cucumber-html-reports"}
)

public class TestRunner {

    @BeforeClass
    public static void beforeSuite() {
        System.out.println("**************** BEFORE SUITE");
//        String browserName = System.getProperty("browser");//Get browser value from cmd
        String browserName = "chrome";
        WebDriverFactory.instance().createWebDriver(browserName);

    }

    @AfterClass
    public static void afterSuite() {
        System.out.println("**************** AFTER SUITE");
        WebDriverFactory.instance().disposeWebDriver();
    }
}
