package com.qt.core.config.driver.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class DriverExecutable {

    private String browserName;
    private String driverVersion;

    public DriverExecutable (String browserName, String driverVersion) {
        this.browserName = browserName;
        this.driverVersion = driverVersion;
        setDriverExecutable();
    }

    public DriverExecutable (String browserName) {
        this.browserName = browserName;
        setDriverExecutable();
    }

    private void setDriverExecutable() {
        //Set directory that contains webdrivers to .\drivers
        WebDriverManager.config().setTargetPath("..\\drivers");

        //Initiate new webdriver instance base on browserName
        String pathToDriver;
        switch(browserName.toLowerCase().trim()) {
            case "chrome":
                if (driverVersion == null)
                    WebDriverManager.chromedriver().setup();
                else
                    WebDriverManager.chromedriver().version(driverVersion).setup();
                pathToDriver = WebDriverManager.chromedriver().getBinaryPath();
                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, pathToDriver);
                break;
            case "firefox":
                if (driverVersion == null)
                    WebDriverManager.firefoxdriver().setup();
                else
                    WebDriverManager.firefoxdriver().version(driverVersion).setup();
                pathToDriver = WebDriverManager.firefoxdriver().getBinaryPath();
                System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, pathToDriver);
                break;
//            case "edge":
//                if (driverVersion == null) {
//                    WebDriverManager.edgedriver().setup();
//                } else {
//                    WebDriverManager.edgedriver().version(driverVersion).setup();
//                }
//                pathToDriver = WebDriverManager.edgedriver().getBinaryPath();
//                System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, pathToDriver);
//                break;
            default:
                if (driverVersion == null)
                    WebDriverManager.iedriver().setup();
                else
                    WebDriverManager.iedriver().version(driverVersion).setup();
                pathToDriver = WebDriverManager.iedriver().getBinaryPath();
                System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, pathToDriver);
        }
    }

}
