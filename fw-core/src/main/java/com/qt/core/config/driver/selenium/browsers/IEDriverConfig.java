package com.qt.core.config.driver.selenium.browsers;

import com.qt.core.config.driver.selenium.DriverConfig;
import com.qt.core.config.driver.selenium.DriverExecutable;
import com.qt.core.config.driver.selenium.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEDriverConfig extends DriverConfig implements SeleniumDriver {

    private InternetExplorerOptions options;

    private InternetExplorerOptions getOptions () {
        if (options == null) {
            options = new InternetExplorerOptions();
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        }
        return options;
    }

    @Override
    public WebDriver createDriver() {
        new DriverExecutable("ie", "Win32_3.14.0");
        WebDriver driver = new InternetExplorerDriver(getOptions());
        manage(driver);
        return driver;
    }

    @Override
    public void setDriverOptions(Object options) {
        this.options = (InternetExplorerOptions) options;
    }
}
