package debug;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.qt.core.config.driver.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class debug_1 {
    @Inject
    private WebDriver webDriver;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DriverModule());
        TestDriver testDriver = injector.getInstance(TestDriver.class);
        testDriver.openDriver();
        testDriver.closeDriver();
    }
}

class TestDriver {

    @Inject
    private WebDriver webDriver;

    public void openDriver () {
        System.out.println("============ Injecting openDriver: " + webDriver);
        webDriver.get("http://www.store.demoqa.com");
        webDriver.findElement(By.xpath(".//*[@id='account']/a")).click();
        webDriver.findElement(By.id("log")).sendKeys("testuser_1");
        webDriver.findElement(By.id("pwd")).sendKeys("Test@123");
        webDriver.findElement(By.id("login")).click();
    }

    public void closeDriver () {
        System.out.println("============ Injecting closeDriver: " + webDriver);
        webDriver.close();
    }
}

class DriverModule extends AbstractModule {
    WebDriver webDriver = WebDriverFactory.instance().createWebDriver("chrome");

    @Override
    public void configure() {
        System.out.println("=========== Binding: " + webDriver);
        bind(WebDriver.class).toInstance(webDriver);
    }
}