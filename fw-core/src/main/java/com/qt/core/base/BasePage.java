package com.qt.core.base;

import com.qt.core.config.driver.WebDriverFactory;
import com.qt.core.config.element.factory.internal.ElementDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class BasePage {

    public BasePage() {
        initPageObject();
    }

    private void initPageObject() {
        PageFactory.initElements(
                new ElementDecorator(
                        new DefaultElementLocatorFactory(WebDriverFactory.instance().getWebDriver())), this);
    }

    public void openURL(String url) {
        WebDriverFactory.instance().getWebDriver().get(url);
    }

}
