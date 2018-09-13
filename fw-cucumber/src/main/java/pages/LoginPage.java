package pages;


import com.qt.core.config.element.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    public LoginPage (WebDriver webDriver) { }

    @FindBy(linkText = "Sign in")
    private Element btn_Login;

    @FindBy (name = "email")
    private Element input_Email;

    @FindBy (id = "passwd")
    private Element input_Password;

    @FindBy (id = "SubmitLogin")
    private Element btn_Submit;

    @FindBy (css = ".info-account")
    private Element lbl_AccountInfo;

    public void clickLogin() { btn_Login.click(); }

    public void enterUserNamedAndPassWord() {
        input_Email.sendKeys("blog.cucumber@gmail.com");
        input_Password.sendKeys("Cucumber@blog");
    }

    public void clickSubmit() { btn_Submit.click(); }

    public void verifyInfo() {
        String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
        String act_message = lbl_AccountInfo.getText().trim();
    }
}
