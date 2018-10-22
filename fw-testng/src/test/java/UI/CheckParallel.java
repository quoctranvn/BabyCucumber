package UI;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;

public class CheckParallel extends BasePage {

    @Test
    public void test() {
        webDriver.get("http://www.store.demoqa.com");
        webDriver.findElement(By.xpath(".//*[@id='account']/a")).click();
        webDriver.findElement(By.id("log")).sendKeys("testuser_1");
        webDriver.findElement(By.id("pwd")).sendKeys("Test@123");
        webDriver.findElement(By.id("login")).click();
    }
}
