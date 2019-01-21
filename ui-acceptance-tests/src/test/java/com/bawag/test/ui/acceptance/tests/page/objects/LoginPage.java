package com.bawag.test.ui.acceptance.tests.page.objects;

import com.bawag.test.ui.acceptance.tests.util.WebElementExtension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "disposerNumber")
    WebElement disposerNumberTextField;

    @FindBy (id = "disposerPassword")
    WebElement disposerPasswordTextField;

    @FindBy (xpath = "//div[@class='form_row bawag__button-container']/button[@type='submit']")
    WebElement loginButton;

    @FindBy(className = "field-validation-error")
    WebElement invalidLoginErrorBox;

    @FindBy(id = "disposerNumber-error")
    WebElement disposerNumberErrorBox;

    @FindBy(id = "disposerPassword-error")
    WebElement passwordErrorBox;


    public boolean checkLoginPageIsDisplayed() {
        return WebElementExtension.isElementDisplayed(disposerNumberTextField);
    }

    public void insertDisposerNumber(String disposerNumber) {
        if(WebElementExtension.isElementDisplayed(disposerNumberTextField))
            disposerNumberTextField.sendKeys(disposerNumber);
    }

    public void insertDisposerPassword(String disposerPassword) {
        if(WebElementExtension.isElementDisplayed(disposerPasswordTextField))
            disposerPasswordTextField.sendKeys(disposerPassword);
    }

    public void clickOnLoginButton() {
        if(WebElementExtension.isElementDisplayed(loginButton))
            WebElementExtension.clickWithJavaScript(loginButton);
    }

    public boolean checkInvalidLoginErrorBox(String message) {
        return invalidLoginErrorBox.isDisplayed() && invalidLoginErrorBox.getText().contains(message);
    }

    public boolean checkDisposerNumberErrorBox(String message) {
        return disposerNumberErrorBox.isDisplayed() && disposerNumberErrorBox.getText().contains(message);
    }

    public boolean checkPasswordErrorBox(String message) {
        return passwordErrorBox.isDisplayed() && passwordErrorBox.getText().contains(message);
    }
}
