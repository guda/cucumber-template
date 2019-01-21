package com.bawag.test.ui.acceptance.tests.step.definitions;

import com.bawag.test.ui.acceptance.tests.config.driver.WebDriverFactory;
import com.bawag.test.ui.acceptance.tests.page.objects.ProductDetailsPage;
import com.bawag.test.ui.acceptance.tests.util.WebElementExtension;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;


public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage = PageFactory.initElements(WebDriverFactory.getWebDriver(), ProductDetailsPage.class);

    @Given("^Product details page is displayed \"([^\"]*)\"$")
    public void product_details_page_is_displayed(String url) {
        WebDriverFactory.getWebDriver().get(url);
    }

    @And("^The customer clicks on apply online button$")
    public void the_customer_clicks_on_apply_online_button() {
        productDetailsPage.clickOnApplyNowButton();
    }

    @And("^The customer clicks on close button$")
    public void the_customer_clicks_on_close_button() {

        productDetailsPage.clickOnCloseButton();
    }

    @Then("^Required elements are present$")
    public void required_elements_are_present() {
        assertTrue(productDetailsPage.checkLoanAmountIsDisplayed());
        assertTrue(productDetailsPage.checkLoanAmountSliderIsDisplayed());
        assertTrue(productDetailsPage.checkLoanDurationDropdownIsDisplayed());
        assertTrue(productDetailsPage.checkLoanDurationSliderIsDisplayed());
        assertTrue(productDetailsPage.checkFirstApplyOnlineButtonIsDisplayed());
        assertTrue(productDetailsPage.checkMonthlyLoanMessageIsDisplayed());
        assertTrue(productDetailsPage.checkCloseButtonIsDisplayed());
        assertTrue(productDetailsPage.checkBenefitsHeadingIsDisplayed());
        assertTrue(productDetailsPage.checkSecondApplyOnlineButtonIsDisplayed());
        assertTrue(productDetailsPage.checkThreeStepsHeadingIsDisplayed());
        assertTrue(productDetailsPage.checkCreditCalculatorIsDisplayed());
        assertTrue(productDetailsPage.checkFeesConditionsLinkIsDisplayed());
        assertTrue(productDetailsPage.checkFaqLinkIsDisplayed());
        assertTrue(productDetailsPage.checkImprintIsDisplayed());
        assertTrue(productDetailsPage.checkDataProtectionIsDisplayed());
        assertTrue(productDetailsPage.checkTermsOfUseIsDisplayed());
    }

    @When("^The customer enters \"([^\"]*)\" as loan amount$")
    public void the_customer_enters_as_loan_amount(String loanAmount) {
        productDetailsPage.insertLoanAmount(loanAmount);
    }

    @And("^The customer selects \"([^\"]*)\" as loan duration$")
    public void the_customer_selects_as_loan_duration(String loanDuration) {
        productDetailsPage.selectLoanDuration(loanDuration);
    }

    @When("^The customer clicks on apply online button in the paragraph Your benefits at a glance$")
    public void the_customer_clicks_on_apply_online_button_in_the_paragraph_Your_benefits_at_a_glance() {
        productDetailsPage.clickOnSecondApplyNowButton();
    }

    @When("^The customer clicks on Credit calculator in the paragraph In just three steps to your desired credit$")
    public void the_customer_clicks_on_Credit_calculator_in_the_paragraph_In_just_three_steps_to_your_desired_credit() {
        productDetailsPage.clickOnCreditCalculator();
    }

    @Then("^The customer is redirected to the top of Product Details page$")
    public void the_customer_is_redirected_to_the_top_of_Product_Details_page() {
        assertTrue(productDetailsPage.checkLoanAmountIsDisplayed());
        assertTrue(productDetailsPage.checkLoanAmountSliderIsDisplayed());
        assertTrue(productDetailsPage.checkLoanDurationDropdownIsDisplayed());
        assertTrue(productDetailsPage.checkLoanDurationSliderIsDisplayed());
    }

    @When("^The customer clicks on Fees And Conditions$")
    public void the_customer_clicks_on_Fees_And_Conditions() {
        productDetailsPage.clickOnFeesConditions();
    }

    @When("^The customer clicks on Price Sheet for Consumer and Commercial Loans$")
    public void the_customer_clicks_on_Price_Sheet_for_Consumer_and_Commercial_Loans() {
        productDetailsPage.clickOnFeesConditionsLink();
    }

//    @Then("^Fees and Legal Fees for Consumer and Commercial Loans is opened in a new window$")
//    public void fees_and_Legal_Fees_for_Consumer_and_Commercial_Loans_is_opened_in_a_new_window() {
//        if(System.getProperty("headless") == null && System.getProperty("browser") != WebDriverFactory.CHROME){
//            WebElementExtension.switchToWindow(1);
//            assertTrue(WebDriverFactory.getWebDriver().getCurrentUrl().contains("preisblatt-kredit-allgemein-data.pdf"));
//            WebDriverFactory.getWebDriver().close();
//            WebElementExtension.switchToDefaultWindow();
//        }
//        assertTrue(new PDFService().verifyPDFContent(productDetailsPage.getFeesAndConditionLink(),"ENTGELTE UND GESETZLICHE GEBÜHREN"));
//    }
//
//    @When("^The customer clicks on FAQs$")
//    public void the_customer_clicks_on_FAQs() {
//        productDetailsPage.clickOnFAQs();
//    }
//
//    @And("^The customer clicks on FAQs link$")
//    public void the_customer_clicks_on_FAQs_link() {
//        productDetailsPage.clickOnFAQsLink();
//    }
//
//    @Then("^New FAQ window is opened$")
//    public void new_FAQ_window_is_opened() {
//        if(System.getProperty("headless") == null && System.getProperty("browser") != WebDriverFactory.CHROME) {
//            WebElementExtension.switchToWindow(1);
//            assertTrue(WebDriverFactory.getWebDriver().getCurrentUrl().contains("FAQs.pdf"));
//            WebDriverFactory.getWebDriver().close();
//            WebElementExtension.switchToDefaultWindow();
//        }
//    }
//
//    @When("^The customer clicks on Imprint$")
//    public void the_customer_clicks_on_Imprint() {
//        productDetailsPage.clickOnImprint();
//    }
//
//    @Then("^New Imprint window is opened$")
//    public void new_Imprint_window_is_opened() {
//        WebElementExtension.switchToWindow(1);
//        assertTrue(imprintPage.checkMainContainer());
//        WebDriverFactory.getWebDriver().close();
//        WebElementExtension.switchToDefaultWindow();
//    }
//
//    @When("^The customer clicks on Data Protection$")
//    public void the_customer_clicks_on_Data_Protection() {
//        productDetailsPage.clickOnDataProtection();
//    }
//
//    @Then("^New Data Protection window is opened$")
//    public void new_Data_Protection_window_is_opened() {
//        WebElementExtension.switchToWindow(1);
//        assertTrue(dataProtectionPage.checkMainContainer());
//        WebDriverFactory.getWebDriver().close();
//        WebElementExtension.switchToDefaultWindow();
//    }
//
//    @When("^The customer clicks on Terms of Use$")
//    public void the_customer_clicks_on_Terms_of_Use() {
//        productDetailsPage.clickOnTermsOfUse();
//    }
//
//    @Then("^New Legal notice window is opened$")
//    public void new_Legal_window_is_opened() {
//        WebElementExtension.switchToWindow(1);
//        assertTrue(legalNoticePage.checkMainContainer());
//        WebDriverFactory.getWebDriver().close();
//        WebElementExtension.switchToDefaultWindow();
//    }
}
