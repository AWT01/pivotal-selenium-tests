package org.fundacionjala.pivotal.model.pageObject.dashboard;

import org.fundacionjala.pivotal.model.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class SettingsPage extends AbstractPage {

    @FindBy(css = "a[data-aid='navTab-more']")
    private WebElement projectMoreButton;

    @FindBy(id = "project_name")
    private WebElement projectNameInputField;

    /**
     * .
     * @return .
     */
    public WebElement getProjectNameInputField() {
        wait.until(ExpectedConditions.visibilityOf(projectNameInputField));
        return projectNameInputField;
    }


    /**
     * .
     */
    public void clickMoreButton() {
        wait.until(ExpectedConditions.elementToBeClickable(projectMoreButton));
        projectMoreButton.click();
    }
}
