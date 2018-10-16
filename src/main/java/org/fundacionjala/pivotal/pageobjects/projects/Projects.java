package org.fundacionjala.pivotal.pageobjects.projects;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.ui.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object for Pivotal Settings Page.
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class Projects extends AbstractPage {

    @FindBy(css = "a[data-aid='navTab-more']")
    private WebElement projectMoreButton;

    @FindBy(id = "project_name")
    private WebElement projectNameInputField;

    @FindBy(id = "delete_link")
    private WebElement projectDeleteLink;

    @FindBy(id = "confirm_delete")
    private WebElement projectDeleteConfirmButton;
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
    public void enterProjectSettings() {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(projectMoreButton));
        String newURL = WebDriverManager.getInstance().getDriver().getCurrentUrl().replace("/n", "") + "/settings";
        WebDriverManager.getInstance().getDriver().navigate().to(newURL);
    }

    /**
     * Delete the current project page.
     */
    public void deleteProject() {
        CommonActions.waitAnElement(projectDeleteLink);
        CommonActions.scrollToElement(projectDeleteLink);
        CommonActions.waitAndClick(projectDeleteLink);
        CommonActions.waitAndClick(projectDeleteConfirmButton);
    }
}
