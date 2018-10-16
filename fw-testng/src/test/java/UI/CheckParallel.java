package UI;

import com.qt.core.config.driver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckParallel {

    public WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    private void beforeTest(String browser) {
        driver = WebDriverFactory.instance().createWebDriver(browser);
        driver.get("http://www.store.demoqa.com");
    }

    @AfterTest
    private void afterTest() {
        WebDriverFactory.instance().disposeWebDriver();
    }

    @Test
    public void test() {
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        driver.findElement(By.id("log")).sendKeys("testuser_1");
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
        driver.findElement(By.id("login")).click();
    }
}
