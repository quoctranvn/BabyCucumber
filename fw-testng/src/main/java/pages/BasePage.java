package pages;

import com.qt.core.base.BaseExecutionTestNG;
import com.qt.core.config.driver.WebDriverFactory;

import static com.qt.core.config.element.factory.ElementFactory.initElements;

public class BasePage extends BaseExecutionTestNG {

    public static final pages.LoginPage loginPage = initElements(WebDriverFactory.instance().getWebDriver()
                                                                    , pages.LoginPage.class);
}
