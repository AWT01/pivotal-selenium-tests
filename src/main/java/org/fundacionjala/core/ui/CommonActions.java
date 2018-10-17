package org.fundacionjala.core.ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class with common actions to execute.
 * @author Kevin Sanchez AWT - [01].
 * @version 0.1
 */
public final class CommonActions {

    /**
     * empty constructor.
     */
    private CommonActions() {
    }

    /**
     * wait and click action.
     * @param element webelement.
     */
    //TODO rename methods
    public static void waitAndClick(final WebElement element) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * wait and set text.
     * @param element webelement
     * @param textToSet text
     */
    public static void waitAndSetText(final WebElement element, final String textToSet) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(textToSet);
    }
    /**
     * wait and get text.
     * @param element webelement
     * @return a string
     */
    public static String waitAndGetText(final WebElement element) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /**
     * waitand get attribute.
     * @param element web element
     * @param attribute attribute to get
     * @return string
     */
    public static String waitAndGetAttribute(final WebElement element, final String attribute) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attribute);
    }

    /**
     * wait for a element.
     * @param element webelement
     */
    public static void waitAnElement(final WebElement element) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Scroll to web element.
     * @param element to scroll to
     */
    public static void scrollToElement(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
