package com.qt.core.config.driver.selenium;

import com.qt.core.helper.FileHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;

public class DriverExecutable {

    private String browserName;
    private String driverVersion;

    public DriverExecutable(String browserName) {
        this.browserName = browserName;
        setWebDriver();
    }

    public DriverExecutable(String browserName, String driverVersion) {
        this.driverVersion = driverVersion;
        this.browserName = browserName;
        setWebDriver();
    }

    private void setWebDriver() {
        //Set directory that contains webdrivers to .\drivers
        String driverFolder = "drivers";
        WebDriverManager.config().setTargetPath(driverFolder);

        //Set desired version of webdriver
        if(driverVersion != null)
            WebDriverManager.config().setDriverVersion(driverVersion);

        //Initiate new webdriver instance base on browserName
        String browserPath;
        switch(browserName.toLowerCase().trim()) {
            case "ie":
                WebDriverManager.iedriver().setup();
                browserPath = (new FileHelper()).getFilePath("IEDriverServer.exe", new File(driverFolder));
                System.setProperty("webdriver.ie.driver", browserPath);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                browserPath = (new FileHelper()).getFilePath("geckodriver.exe", new File(driverFolder));
                System.setProperty("webdriver.firefox.driver", browserPath);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                browserPath = (new FileHelper()).getFilePath("MicrosoftWebDriver.exe", new File(driverFolder));
                System.setProperty("webdriver.edge.driver", browserPath);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                browserPath = (new FileHelper()).getFilePath("chromedriver.exe", new File(driverFolder));
                System.setProperty("webdriver.chrome.driver", browserPath);
        }
    }

}
