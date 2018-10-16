package org.fundacionjala.core.ui;

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
     * wait for a element.
     * @param element webelement
     */
    public static void waitAnElement(final WebElement element) {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
    }
}
