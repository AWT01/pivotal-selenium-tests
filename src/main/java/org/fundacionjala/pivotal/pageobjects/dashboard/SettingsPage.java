package org.fundacionjala.pivotal.pageobjects.dashboard;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.ui.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object for Pivotal Settings Page.
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class SettingsPage extends AbstractPage {

    @FindBy(css = "a[data-aid='navTab-more']")
    private WebElement projectMoreButton;

    @FindBy(id = "project_name")
    private WebElement projectNameInputField;

    /**
     * Getter of project name input field on create project settings page.
     * @return webElement object.
     */
    public WebElement getProjectNameInputField() {
        CommonActions.waitAnElement(projectNameInputField);
        return projectNameInputField;
    }


    /**
     * Click on more button inside project page.
     */
    public void clickMoreButton() {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(projectMoreButton));
        Actions actions = new Actions(WebDriverManager.getInstance().getDriver());
        actions.moveToElement(projectMoreButton).click().perform();
    }
}
