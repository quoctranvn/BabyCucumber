package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;

public class LoginDef extends BasePage {

    @Given("^user is on homepage$")
    public void user_is_on_homepage(){}

    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page(){
        loginPage.clickLogin();
    }

    @When("^user enters username and Password$")
    public void user_enters_username_and_Password(){
        loginPage.enterUserNamedAndPassWord();
        loginPage.clickSubmit();
    }

    @Then("^success message is displayed$")
    public void success_message_is_displayed() {
        loginPage.verifyInfo();
    }
}
