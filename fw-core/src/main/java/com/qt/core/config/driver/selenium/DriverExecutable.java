package com.qt.core.config.driver.selenium;

import com.qt.core.helper.FileHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import java.io.File;

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
        String driverFolder = "drivers";
        WebDriverManager.config().setTargetPath(driverFolder);

        //Set desired version of webdriver
        if(driverVersion != null)
            WebDriverManager.config().setDriverVersion(driverVersion);

        //Initiate new webdriver instance base on browserName
        String pathToDriver;
        switch(browserName.toLowerCase().trim()) {
            case "ie":
                WebDriverManager.iedriver().setup();
                pathToDriver = (new FileHelper()).getFilePath("IEDriverServer.exe", new File(driverFolder));
                System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, pathToDriver);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                pathToDriver = (new FileHelper()).getFilePath("geckodriver.exe", new File(driverFolder));
                System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, pathToDriver);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                pathToDriver = (new FileHelper()).getFilePath("MicrosoftWebDriver.exe", new File(driverFolder));
                System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, pathToDriver);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                pathToDriver = (new FileHelper()).getFilePath("chromedriver.exe", new File(driverFolder));
                System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, pathToDriver);
        }
    }

}
