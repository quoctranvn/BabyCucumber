package stepdefs;

import pages.BasePage;

import static com.qt.core.config.element.factory.ElementFactory.initElements;

class BaseStep extends BasePage {

    static final pages.LoginPage loginPage = initElements(webDriver, pages.LoginPage.class);
}
