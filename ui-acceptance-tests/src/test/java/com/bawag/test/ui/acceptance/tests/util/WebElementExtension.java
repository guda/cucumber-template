package com.bawag.test.ui.acceptance.tests.util;

import com.bawag.test.ui.acceptance.tests.config.driver.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class WebElementExtension {
    private static int timeoutInSeconds = 15;

    public static void scrollToViewElement(WebElement element) {
        Actions actions = new Actions(WebDriverFactory.getWebDriver());
        actions.moveToElement(element);
        actions.perform();
    }

    public static boolean isElementEnabled(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
        try {
            wait.until(d -> {
                if (element.isEnabled())
                    return true;
                return false;
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementNotEnabled(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
        try {
            wait.until(d -> {
                if (!element.isEnabled())
                    return true;
                return false;
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
        try {
            wait.until(d -> {
                if (element.isDisplayed())
                    return true;
                return false;
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementNotDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
        try {
            wait.until(d -> {
                if (!element.isEnabled())
                    return true;
                return false;
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementNotVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isTitleContains(String title) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.titleContains(title));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUrlContains(String url) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
        try {
            wait.until(ExpectedConditions.urlContains(url));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementTextPresent(WebElement element, String elementText) {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
            return wait.until(ExpectedConditions.textToBePresentInElement(element, elementText));
        } catch (Exception e) {
            return false;
        }
    }

    public static void clickActionWithCoordinates(WebElement element, int x, int y) {
        Actions action = new Actions(WebDriverFactory.getWebDriver());
        action.moveToElement(element).moveByOffset(x, y).click().build().perform();
    }

    public static void clickAction(WebElement element) {
        Actions action = new Actions(WebDriverFactory.getWebDriver());
        action.moveToElement(element).click().build().perform();
    }

    public static void doubleClickAction(WebElement element) {
        Actions action = new Actions(WebDriverFactory.getWebDriver());
        action.moveToElement(element).doubleClick().build().perform();
    }

    public static void clickWithJavaScript(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) WebDriverFactory.getWebDriver();
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public static void selectComboboxOptionByText(WebElement element, String value) {
        if (isElementDisplayed(element)) {
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(value);
        }
    }

    public static void selectComboboxOptionByValue(WebElement element, String value) {
        if (isElementDisplayed(element)) {
            Select dropdown = new Select(element);
            dropdown.selectByValue(value);
        }
    }

    public static void selectComboboxOptionByIndex(WebElement element, int index) {
        if (isElementDisplayed(element)) {
            Select dropdown = new Select(element);
            dropdown.selectByIndex(index);
        }
    }

    public static void clearAndSendKeys(WebElement element, String value) {
        if (isElementDisplayed(element)) {
            scrollToViewElement(element);
            element.clear();
            element.sendKeys(value);
        }
    }

    public static void clearElementWithControls(WebElement element) {
        if (isElementDisplayed(element)) {
            scrollToViewElement(element);
            element.sendKeys(Keys.ARROW_LEFT + "a" + Keys.DELETE);
        }
    }

    public static void clickInAndSendKeysElement(WebElement element, String value) {
        if (isElementClickable(element)) {
            scrollToViewElement(element);
            element.click();
            clearAndSendKeys(element, value);
        }
    }

    public static boolean getCheckboxValue(WebElement element) {
        boolean result = false;

        if (element.isSelected())
            result = true;

        return result;
    }

    public static void refreshPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) WebDriverFactory.getWebDriver();
        jsExecutor.executeScript("location.reload();");
    }

    public static void selectDropdownListValue(WebElement selectlistElement, String optionXpath, int explicitWait) {
        try {
            if (isElementDisplayed(selectlistElement)) {
                selectlistElement.click();
                Thread.sleep(explicitWait);
                WebElement selectlistOption = WebDriverFactory.getWebDriver().findElement(By.xpath(optionXpath));
                Thread.sleep(explicitWait);
                selectlistOption.click();
            }
        } catch (Exception e) {
            return;
        }

    }

    public static void sendKeysViaActions(WebElement element, String value) {
        if (isElementDisplayed(element)) {
            element.click();
            Actions action = new Actions(WebDriverFactory.getWebDriver());
            action.sendKeys(value).perform();
        }
    }

    public static void confirmAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = WebDriverFactory.getWebDriver().switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException ex) {
            throw ex;
        }
    }

    public static boolean isWindowDisplayed(int tabIndex) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), timeoutInSeconds);
        try {
            wait.until(d -> {
                if (d.getWindowHandles().size() > tabIndex) {
                    ArrayList<String> browserTabs = new ArrayList<String>(d.getWindowHandles());
                    if (d.switchTo().window(browserTabs.get(tabIndex)) != null)
                        return true;
                }
                return false;
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void switchToWindow(int tabIndex) {
        if (isWindowDisplayed(tabIndex)) {
            ArrayList<String> browserTabs = new ArrayList<String>(WebDriverFactory.getWebDriver().getWindowHandles());
            WebDriverFactory.getWebDriver().switchTo().window(browserTabs.get(tabIndex));
        }
    }

    public static void switchToDefaultWindow() {
        ArrayList<String> browserTabs = new ArrayList<String>(WebDriverFactory.getWebDriver().getWindowHandles());
        WebDriverFactory.getWebDriver().switchTo().window(browserTabs.get(0));
    }

}
