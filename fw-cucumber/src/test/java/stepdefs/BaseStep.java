package stepdefs;

import pages.BasePage;

import static com.qt.core.config.element.factory.ElementFactory.initElements;

public class BaseStep extends BasePage {

    protected static pages.LoginPage loginPage = initElements(webDriver, pages.LoginPage.class);
}
