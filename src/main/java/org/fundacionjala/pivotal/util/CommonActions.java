package org.fundacionjala.pivotal.util;

import org.fundacionjala.pivotal.model.pageobjects.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions extends AbstractPage {
    private CommonActions() {
    }
    private void waitClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public static void waitAndClick(WebElement webElement) {
        CommonActions commonActions = new CommonActions();
        commonActions.waitClick(webElement);
    }
    private void waitSet(WebElement element, final String textToSet) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(textToSet);
    }
    public static void WaitAndSetText (WebElement element, final String textToSet) {
        CommonActions commonActions = new CommonActions();
        commonActions.waitSet(element, textToSet);
    }
    private void waitElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitAnElement(WebElement element) {
        CommonActions commonActions = new CommonActions();
        commonActions.waitElement(element);
    }
}
