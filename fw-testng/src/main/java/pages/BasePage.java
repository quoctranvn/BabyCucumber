package pages;

import com.qt.core.config.driver.WebDriverFactory;

import static com.qt.core.config.element.factory.ElementFactory.initElements;

public class BasePage {

    public static final pages.LoginPage loginPage = initElements(WebDriverFactory.instance().getWebDriver()
                                                                    , pages.LoginPage.class);
}
