package com.bawag.test.ui.acceptance.tests.page.objects;

import com.bawag.test.ui.acceptance.tests.config.driver.WebDriverFactory;
import com.bawag.test.ui.acceptance.tests.util.WebElementExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage {

    @FindBy(xpath = "//div[@id='Kreditrechner']//div[@class='apply-now-button']/a/span")
    WebElement applyOnlineButton1;

    @FindBy(xpath = "//iframe[@src='https://lp.expressfinanzierung.bawagpsk.com/finanzierung/']")
    WebElement iframe;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    WebElement closeButton;

    @FindBy(id = "calcInputAmount")
    WebElement loanAmountTextField;

    @FindBy(xpath = "(//div[@class='calc__slider-inner-container range-slider-main'])[1]")
    WebElement loanAmountSlider;

    @FindBy(id = "calcSelectDuration")
    WebElement loanDurationButton;

    @FindBy(xpath = "(//div[@class='calc__slider-inner-container range-slider-main'])[2]")
    WebElement loanDurationSlider;

    @FindBy(className = "calc__summary-amount-label")
    WebElement monthlyLoanMessage;

    @FindBy(xpath = "(//div[@class='wpb_wrapper']/h3[@class='vc_custom_heading'])[1]")
    WebElement benefitsHeading;

    @FindBy(xpath = "//div[@class='wpb_wrapper']/a/span")
    WebElement applyOnlineButton2;

    @FindBy(xpath = "//div/h2[@class='vc_custom_heading vc_custom_1516359258627']")
    WebElement threeStepsHeading;

    @FindBy(xpath = "//div[@class='wpb_wrapper']/p/a[@class='menu-smooth-scroll']")
    WebElement creditCalculator;

    @FindBy(xpath = "(//a[@id='1512733810123-3-8']/span/span)[2]")
    WebElement feesConditions;

    @FindBy(xpath = "(//p/a[contains(@href,'preisblatt-kredit-allgemein-data.pdf')])[2]")
    WebElement feesConditionsLink;

    @FindBy(xpath = "//a/span[@class='ult_tab_main ult_ac_mainBoth']/span[contains(.,'FAQs')]")
    WebElement faq;

    @FindBy(xpath = "(//a[contains(text(),'FAQs')])[2]")
    WebElement faqLink;

    @FindBy( xpath = "//*[contains(text(), 'Impressum')]")
    WebElement imprint;

    @FindBy( xpath = "//*[contains(text(), 'Datenschutz')]")
    WebElement dataProtection;

    @FindBy( xpath = "//*[contains(text(), 'Nutzungsbedingungen')]")
    WebElement termsOfUse;


    public void clickOnApplyNowButton() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(applyOnlineButton1))
            applyOnlineButton1.click();
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void clickOnCloseButton() {
        if(WebElementExtension.isElementDisplayed(closeButton))
            closeButton.click();
    }

    public boolean checkLoanAmountIsDisplayed() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        return WebElementExtension.isElementDisplayed(loanAmountTextField);
    }

    public boolean checkLoanAmountSliderIsDisplayed() {
        return WebElementExtension.isElementDisplayed(loanAmountSlider);
    }

    public boolean checkLoanDurationDropdownIsDisplayed() {
        return WebElementExtension.isElementDisplayed(loanDurationButton);
    }

    public boolean checkLoanDurationSliderIsDisplayed() {
        return WebElementExtension.isElementDisplayed(loanDurationSlider);
    }

    public boolean checkFirstApplyOnlineButtonIsDisplayed() {
        return WebElementExtension.isElementDisplayed(applyOnlineButton1);
    }

    public boolean checkMonthlyLoanMessageIsDisplayed() {
        return WebElementExtension.isElementDisplayed(monthlyLoanMessage);
    }

    public boolean checkCloseButtonIsDisplayed() {
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
        return WebElementExtension.isElementDisplayed(closeButton);
    }

    public boolean checkBenefitsHeadingIsDisplayed() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        return WebElementExtension.isElementDisplayed(benefitsHeading);
    }

    public boolean checkSecondApplyOnlineButtonIsDisplayed() {
        return WebElementExtension.isElementDisplayed(applyOnlineButton2);
    }

    public boolean checkThreeStepsHeadingIsDisplayed() {
        return WebElementExtension.isElementDisplayed(threeStepsHeading);
    }

    public boolean checkCreditCalculatorIsDisplayed() {
        return WebElementExtension.isElementDisplayed(creditCalculator) && WebElementExtension.isElementClickable(creditCalculator);
    }

    public boolean checkFeesConditionsLinkIsDisplayed() {
        if(WebElementExtension.isElementDisplayed(feesConditions))
            WebElementExtension.clickWithJavaScript(feesConditions);

        return WebElementExtension.isElementDisplayed(feesConditionsLink);
    }

    public boolean checkFaqLinkIsDisplayed() {
        if(WebElementExtension.isElementDisplayed(faq))
            WebElementExtension.clickWithJavaScript(faq);

        return WebElementExtension.isElementDisplayed(faqLink);
    }

    public boolean checkImprintIsDisplayed() {
        return WebElementExtension.isElementDisplayed(imprint);
    }

    public boolean checkDataProtectionIsDisplayed() {
        return WebElementExtension.isElementDisplayed(dataProtection);
    }

    public boolean checkTermsOfUseIsDisplayed() {
        return WebElementExtension.isElementDisplayed(termsOfUse);
    }

    public void insertLoanAmount(String loanAmount) {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(loanAmountTextField)){
            loanAmountTextField.sendKeys(Keys.CONTROL+ "a");
            loanAmountTextField.sendKeys(loanAmount);
        }
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void selectLoanDuration(String loanDuration) {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(loanDurationButton)){
            loanDurationButton.click();
            WebDriverFactory.getWebDriver()
                    .findElement(By.xpath("//div[@id='calcSelectDurationOptions']/button[contains(.,'"+loanDuration+"')]"))
                    .click();
        }
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void clickOnSecondApplyNowButton() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(applyOnlineButton2)){
            applyOnlineButton2.click();
        }
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void clickOnCreditCalculator() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(loanDurationButton)){
            loanDurationButton.click();
        }
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void clickOnFeesConditions() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);

        if(WebElementExtension.isElementDisplayed(feesConditions)){
            WebElementExtension.clickWithJavaScript(feesConditions);
        }

        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void clickOnFeesConditionsLink() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(feesConditionsLink)){
            WebElementExtension.clickWithJavaScript(feesConditionsLink);
        }

        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void clickOnFAQs() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(faq)){
            WebElementExtension.clickWithJavaScript(faq);
        };
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void clickOnFAQsLink() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(faqLink)){
            WebElementExtension.clickWithJavaScript(faqLink);
        }
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void clickOnImprint() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(imprint)){
            imprint.click();
        }
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void clickOnDataProtection() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(dataProtection)){
            dataProtection.click();
        }
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public void clickOnTermsOfUse() {
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        if(WebElementExtension.isElementDisplayed(termsOfUse)){
            termsOfUse.click();
        }
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
    }

    public String getFeesAndConditionLink(){
        WebDriverFactory.getWebDriver().switchTo().frame(iframe);
        String result = null;
        if(WebElementExtension.isElementDisplayed(feesConditionsLink)){
            result = feesConditionsLink.getAttribute("href");
        }
        WebDriverFactory.getWebDriver().switchTo().defaultContent();
        return result;
    }
}
