package com.qt.core.config.driver.selenium.browsers;

import com.qt.core.config.driver.selenium.DriverConfig;
import com.qt.core.config.driver.selenium.DriverExecutable;
import com.qt.core.config.driver.selenium.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxDriverConfig extends DriverConfig implements SeleniumDriver {
    private FirefoxProfile profile;
    private FirefoxOptions options;

    private FirefoxOptions getOptions () {
        if(options == null) {
            options = new FirefoxOptions();
            options.setProfile(getProfile());
        }
        return options;
    }

    private FirefoxProfile getProfile() {
        if (profile == null) {
            profile = new FirefoxProfile();
            profile.setAcceptUntrustedCertificates(true);
        }
        return profile;
    }

    public void setProfile (Object profile) {
        this.profile = (FirefoxProfile) profile;
    }

    @Override
    public WebDriver createDriver() {
        new DriverExecutable("firefox");
        WebDriver driver = new FirefoxDriver(getOptions());
        manage(driver);
        return driver;
    }

    @Override
    public void setDriverOptions(Object options) {
        this.options = (FirefoxOptions) options;
    }
}
