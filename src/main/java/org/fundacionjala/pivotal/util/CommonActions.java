package org.fundacionjala.pivotal.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
    private static final long WAIT_TIME = 30;
    private WebDriverWait wait;
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
}
