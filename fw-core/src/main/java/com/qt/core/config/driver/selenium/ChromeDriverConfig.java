package com.qt.core.config.driver.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverConfig extends DriverConfig implements SeleniumDriver{

    private ChromeOptions options;

    private ChromeOptions getOptions() {
        if (options == null) {
            options = new ChromeOptions();
            options.addArguments("--no-sandbpx");
        }
        return options;
    }

    @Override
    public WebDriver createDriver() {
        new DriverExecutable("chrome");
        WebDriver driver = new ChromeDriver(getOptions());
        manage(driver);
        return driver;
    }

    @Override
    public void setDriverOptions(Object options) {
        this.options = (ChromeOptions) options;
    }

}