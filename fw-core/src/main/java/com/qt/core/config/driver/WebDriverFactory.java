package com.qt.core.config.driver;

import com.qt.core.config.driver.selenium.browsers.ChromeDriverConfig;
import com.qt.core.config.driver.selenium.browsers.FirefoxDriverConfig;
import com.qt.core.config.driver.selenium.browsers.IEDriverConfig;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    private volatile static WebDriverFactory webDriverFactory;
    private Map<Long, WebDriver> driverStorage = new HashMap<>();
    private WebDriver webDriver;

    private WebDriverFactory() { }

    public static WebDriverFactory instance() {
        if(webDriverFactory == null) {
            synchronized(WebDriverFactory.class) {
                if(webDriverFactory == null)
                    webDriverFactory = new WebDriverFactory();
            }
        }
        return webDriverFactory;
    }

    public WebDriver createWebDriver(String browserName) {
        switch (browserName.toLowerCase().trim()) {
            case "ie":
                webDriver = new IEDriverConfig().createDriver();
                break;
            case "firefox":
                webDriver = new FirefoxDriverConfig().createDriver();
                break;
            default:
                webDriver = new ChromeDriverConfig().createDriver();
        }

        setDriverStorage(webDriver);

        return webDriver;
    }

    private void setDriverStorage(WebDriver webDriver) {
        driverStorage.put(Thread.currentThread().getId(), webDriver);
    }

    public WebDriver getWebDriver() {
        if (driverStorage.size() == 0)
            System.out.println("*****Error in creating Thread id " + Thread.currentThread().getId() + "\n");

        if (driverStorage.containsKey(Thread.currentThread().getId()))
            return driverStorage.get(Thread.currentThread().getId());

        return driverStorage.get(0);
    }

    public void disposeWebDriver() {
        if (driverStorage.containsKey(Thread.currentThread().getId())) {
            System.out.println("-------------------- Disposing Thread ID " + Thread.currentThread().getId());
            driverStorage.get(Thread.currentThread().getId()).quit();
        }
        driverStorage.remove(Thread.currentThread().getId());
    }

    public void disposeAllDriver() {
        System.out.println("-------------------- Disposing ALL");
        for (Map.Entry<Long, WebDriver> driver : driverStorage.entrySet()) {
            WebDriver value = driver.getValue();
            value.quit();
        }
    }
}

