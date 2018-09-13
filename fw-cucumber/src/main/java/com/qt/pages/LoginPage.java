package pages;

import annotation.IElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    public LoginPage (WebDriver webDriver) { }

    @FindBy(linkText = "Sign in")
    private IElement btn_Login;

    @FindBy (name = "email")
    private IElement input_Email;

    @FindBy (id = "passwd")
    private IElement input_Password;

    @FindBy (id = "SubmitLogin")
    private IElement btn_Submit;

    @FindBy (css = ".info-account")
    private IElement lbl_AccountInfo;

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
