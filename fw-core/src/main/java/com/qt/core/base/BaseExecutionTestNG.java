package com.qt.core.base;

import com.qt.core.config.driver.WebDriverFactory;
import com.qt.core.listeners.TestNGExecutionListener;
import org.testng.annotations.*;

@Listeners(TestNGExecutionListener.class)
public class BaseExecutionTestNG {

    @BeforeClass
    @Parameters("browserName")
    public void setUpTestClass(@Optional("chrome") String browserName) {
        WebDriverFactory.instance().createWebDriver(browserName);
    }

    @AfterClass
    public void tearDownTestClass() {
        WebDriverFactory.instance().disposeAllDriver();
    }


}
