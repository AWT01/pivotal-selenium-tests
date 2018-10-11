package org.fundacionjala.pivotal.util;

import org.fundacionjala.pivotal.model.pageobjects.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class with common actions to execute.
 * @author Kevin Sanchez AWT - [01].
 * @version 0.1
 */
public final class CommonActions extends AbstractPage {

    private CommonActions () {

    }
    /**
     * wait and click action.
     * @param element webelement.
     */
    private void waitClick(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Static method for wait and click.
     * @param webElement element to click
     */
    public static void waitAndClick(final WebElement webElement) {
        CommonActions commonActions = new CommonActions();
        commonActions.waitClick(webElement);
    }

    /**
     * wait and set text.
     * @param element webelement
     * @param textToSet text
     */
    private void waitSet(final WebElement element, final String textToSet) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(textToSet);
    }

    /**
     * Static method to wait and set.
     * @param element webelement
     * @param textToSet text
     */
    public static void waitAndSetText(final WebElement element, final String textToSet) {
        CommonActions commonActions = new CommonActions();
        commonActions.waitSet(element, textToSet);
    }

    /**
     * wait for a element.
     * @param element webelement
     */
    private void waitElement(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * static method to wait an element.
     * @param element webelement
     */
    public static void waitAnElement(final WebElement element) {
        CommonActions commonActions = new CommonActions();
        commonActions.waitElement(element);
    }


    /**
     * wait and get text.
     * @param element webelement
     */
    private String waitGet(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    /**
     * Static method to wait and get.
     * @param element webelement
     */
    public static String waitAndGetText(final WebElement element) {
        CommonActions commonActions = new CommonActions();
        return commonActions.waitGet(element);
    }
}
