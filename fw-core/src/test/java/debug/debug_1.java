import com.qt.core.config.driver.selenium.ChromeDriverConfig;
import com.qt.core.config.driver.selenium.FirefoxDriverConfig;
import com.qt.core.config.driver.selenium.IEDriverConfig;
import com.qt.core.helper.FileHelper;

import java.io.File;
import java.util.List;

public class debug_1 {

    public static void main(String[] argv) {
        new IEDriverConfig().createDriver();
    }
}
