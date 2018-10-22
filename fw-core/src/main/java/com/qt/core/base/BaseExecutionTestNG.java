package com.qt.core.base;

import com.qt.core.config.annotation.PageObject;
import com.qt.core.config.driver.WebDriverFactory;
import com.qt.core.config.element.factory.internal.ElementDecorator;
import com.qt.core.listeners.TestNGExecutionListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.reflections.Reflections;
import org.testng.annotations.*;

@Listeners(TestNGExecutionListener.class)
public class BaseExecutionTestNG {

    private WebDriver webDriver;

    @BeforeClass
    @Parameters("browserName")
    public void setUpTestClass(@Optional("chrome") String browserName) {
        webDriver = WebDriverFactory.instance().createWebDriver(browserName);
    }

    @AfterClass
    public void tearDownTestClass() {
        WebDriverFactory.instance().disposeWebDriver();
    }

    private void initPageObject() {

    }

    private void getPageObjectClass() {
        String packageName = getClass().getSuperclass().getPackage().getName();
        System.out.println("Scanning using Reflections of package: " + packageName);

        Reflections ref = new Reflections(packageName);
        for (Class<?> cl : ref.getTypesAnnotatedWith(PageObject.class)) {
            System.out.printf("Found class: %s", cl.getSimpleName());

            PageFactory.initElements(
                    new ElementDecorator(
                            new DefaultElementLocatorFactory(webDriver)), cl);
        }
    }

}
