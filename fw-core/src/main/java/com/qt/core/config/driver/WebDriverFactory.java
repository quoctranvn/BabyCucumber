package com.qt.core.config.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
    private WebDriver webDriver;
    //    private String browserName = System.getProperty("browser");//Get browser value from cmd
    private final String browserName = "chrome";

    public WebDriverFactory() {
    }

    public WebDriver getWebDriver() {
        System.out.print("\n========================= Current webdriver: ");
        System.out.println(webDriver);
        if (webDriver == null || String.valueOf(webDriver).contains("null"))
            setWebDriver();
        return webDriver;
    }

    private void setWebDriver() {
        //Set download directory of webdriver to <drivers>
        WebDriverManager.config().setTargetPath("../drivers");

        //Initiate a new webdriver instance base on browserName
        Class<? extends WebDriver> driverClass;
        try {
            switch (browserName.toLowerCase().trim()) {
                case "ie":
                    driverClass = InternetExplorerDriver.class;
                    WebDriverManager.getInstance(driverClass).setup();
                    break;
                default:
                    driverClass = ChromeDriver.class;
                    WebDriverManager.getInstance(driverClass).setup();
                    break;
            }
            webDriver = driverClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
