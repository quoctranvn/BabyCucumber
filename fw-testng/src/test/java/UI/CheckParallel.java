package UI;

import com.qt.core.config.driver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;

public class CheckParallel extends BasePage {

    @Test
    public void test() {
        WebDriver webDriver = WebDriverFactory.instance().getWebDriver();
        webDriver.get("http://www.store.demoqa.com");
        webDriver.findElement(By.xpath(".//*[@id='account']/a")).click();
        webDriver.findElement(By.id("log")).sendKeys("testuser_1");
        webDriver.findElement(By.id("pwd")).sendKeys("Test@123");
        webDriver.findElement(By.id("login")).click();
    }
}
