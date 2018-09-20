package com.qt.core.config.driver.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.openqa.selenium.remote.DesiredCapabilities.chrome;

public class Chrome implements SeleniumDriver {
    private ChromeOptions options;
    private DesiredCapabilities capabilities;

    private ChromeOptions getOptions() {
        return this.options;
    }

    private DesiredCapabilities getCapabilities() {
        if (this.capabilities == null) {
            this.capabilities = chrome();
        }
        return this.capabilities;
    }

    @Override
    public WebDriver createDriver() {
        new DriverExecutable("chrome");
        this.capabilities.setCapability(ChromeOptions.CAPABILITY, getOptions());
        return new ChromeDriver(this.capabilities.merge(getCapabilities()));
    }

    @Override
    public void setDriverOptions(Object options) {
        this.options = (ChromeOptions) options;
    }

    @Override
    public void setCapabilities(Object capabilities) {
        this.capabilities = (DesiredCapabilities) capabilities;
    }
}
