package com.bawag.test.ui.acceptance.tests.step.definitions;

import com.bawag.test.ui.acceptance.tests.config.driver.WebDriverFactory;
import com.bawag.test.ui.acceptance.tests.page.objects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;


public class LoginSteps {

    private LoginPage loginPage = PageFactory.initElements(WebDriverFactory.getWebDriver(), LoginPage.class);

    @Then("^The login page is displayed$")
    public void the_login_page_is_displayed()  {
        assertTrue(loginPage.checkLoginPageIsDisplayed());
    }

    @When("^The customer inserts \"([^\"]*)\" as Verfugernummer$")
    public void the_customer_inserts_as_Verfugernummer(String disposerNumberTextField) {
        loginPage.insertDisposerNumber(disposerNumberTextField);
    }

    @And("^The customer inserts \"([^\"]*)\" as PIN$")
    public void the_customer_inserts_as_PIN(String disposerPasswordTextField) {
        loginPage.insertDisposerPassword(disposerPasswordTextField);
    }

    @And("^The customer clicks on login button$")
    public void the_customer_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("^An error message is shown for invalid credentials \"([^\"]*)\"$")
    public void an_error_message_is_shown_for_invalid_credentials(String message) {
        assertTrue(loginPage.checkInvalidLoginErrorBox(message));
    }

    @Then("^An error message is shown for required disposer number \"([^\"]*)\"$")
    public void the_customer_gets_error_message_for_required_password(String message) {
        assertTrue(loginPage.checkDisposerNumberErrorBox(message));
    }

    @Then("^An error message is shown for required password \"([^\"]*)\"$")
    public void the_customer_get_error_message_for_required_disposer_number(String message) {
        assertTrue(loginPage.checkPasswordErrorBox(message));
    }

    @Then("^Error messages are shown for required disposer number \"([^\"]*)\" and required password \"([^\"]*)\"$")
    public void error_messages_for_required_disposer_number_number_and_required_password(String message1, String message2) {
        assertTrue(loginPage.checkDisposerNumberErrorBox(message1));
        assertTrue(loginPage.checkPasswordErrorBox(message2));
    }

    @Then("^The ExpressFinanzierung login is displayed$")
    public void the_ExpressFinanzierung_login_is_displayed() {
        assertTrue(loginPage.checkLoginPageIsDisplayed());
    }

}