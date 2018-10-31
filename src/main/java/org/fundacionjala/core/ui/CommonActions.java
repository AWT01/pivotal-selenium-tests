package org.fundacionjala.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class with common actions to execute.
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
    public static void click(final WebElement element) {
        WebDriverManager.getInstance().getWait()
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    /**
     * wait and double click action.
     * @param element webelement.
     */
    public static void doubleClick(final WebElement element) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        new Actions(WebDriverManager.getInstance().getDriver())
                .doubleClick(element)
                .perform();
    }
    /**
     * wait and set text.
     * @param element webelement
     * @param textToSet text
     */
    public static void setText(final WebElement element, final String textToSet) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(textToSet);
    }
    /**
     * wait and get text.
     * @param element webelement
     * @return a string
     */
    public static String getText(final WebElement element) {
        return WebDriverManager.getInstance().getWait()
                .until(ExpectedConditions.visibilityOf(element))
                .getText();
    }

    /**
     * wait and get attribute.
     * @param element web element
     * @param attribute attribute to get
     * @return string
     */
    public static String getAttribute(final WebElement element, final String attribute) {
        return WebDriverManager.getInstance().getWait()
                .until(ExpectedConditions.visibilityOf(element))
                .getAttribute(attribute);
    }

    /**
     * wait for a element.
     * @param element webelement
     */
    public static void waitElement(final WebElement element) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * wait for a element.
     * @param findBy webelement
     */
    public static void waitElement(final By findBy) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    /**
     * Scroll to web element.
     * @param element to scroll to
     */
    public static void scrollToElement(final WebElement element) {
        CommonActions.waitElement(element);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
