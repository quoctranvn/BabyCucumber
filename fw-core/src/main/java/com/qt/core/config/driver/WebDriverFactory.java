package com.qt.core.config.driver;

import com.qt.core.config.driver.selenium.browsers.ChromeDriverConfig;
import com.qt.core.config.driver.selenium.browsers.FirefoxDriverConfig;
import com.qt.core.config.driver.selenium.browsers.IEDriverConfig;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private volatile static WebDriver webDriver;
    //    private String browserName = System.getProperty("browser");//Get browser value from cmd
    private static final String browserName = "chrome";

    private WebDriverFactory() { }

    public static WebDriver getWebDriver() {
        System.out.println("========================= Web-driver: " + webDriver + "  ===============================");
        if (webDriver == null || String.valueOf(webDriver).contains("null"))
            synchronized (WebDriverFactory.class) {
                setWebDriver();
            }
        return webDriver;
    }

    private static void setWebDriver() {
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
    }
}
