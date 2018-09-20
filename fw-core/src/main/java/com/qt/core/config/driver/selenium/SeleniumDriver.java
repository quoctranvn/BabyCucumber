package com.qt.core.config.driver.selenium;

import org.openqa.selenium.WebDriver;

public interface SeleniumDriver {

    WebDriver createDriver();

    public void setDriverOptions(Object options);
}
