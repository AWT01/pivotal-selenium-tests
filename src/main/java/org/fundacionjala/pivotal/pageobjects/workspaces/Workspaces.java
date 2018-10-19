package org.fundacionjala.pivotal.pageobjects.workspaces;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.core.ui.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object for Pivotal Workspaces Page.
 */
public class Workspaces extends AbstractPage {

    @FindBy(className = "tc_context_name")
    private WebElement workspaceContextName;

    @FindBy(id = "workspace_name")
    private WebElement workspaceNameTextField;

    @FindBy(css = "a[data-aid='navTab-more']")
    private WebElement moreButton;

    @FindBy(id = "delete_link")
    private WebElement deleteLink;

    @FindBy(id = "confirm_delete")
    private WebElement deleteConfirmButton;

    @FindBy(className = "WorkspaceTile_name")
    private WebElement workspaceTitle;

    /**
     * Getter of workspace name input field on create workspace settings page.
     * @return String with name.
     */
    public String getWorkspaceNameFromSettings() {
        enterWorkspaceSettings();
        return workspaceNameTextField.getAttribute("value");
    }

    /**
     * Getter of workspace name input field on workspace page.
     * @return String with name.
     */
    public String getWorkspaceNameFromContext() {
        CommonActions.waitElement(moreButton);
        return WebDriverManager.getInstance().getDriver().getTitle().replace(" - Pivotal Tracker","");

    }
    /**
     * Getter of workspace name input field on dashboard page.
     * @return String with name.
     */
    public String getWorkspaceNameFromDashboard() {
        CommonActions.goToDashboard();
        System.out.println(workspaceTitle.getAttribute("value"));
        return workspaceTitle.getAttribute("value");
    }


    /**
     * Click on more button inside project page.
     */
    public void enterWorkspaceSettings() {
        WebDriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(moreButton));
        String newURL = WebDriverManager.getInstance().getDriver().getCurrentUrl().replace("/n", "") + "/settings";
        WebDriverManager.getInstance().getDriver().navigate().to(newURL);
    }

    /**
     * Delete the current project page.
     */
    public void deleteWorkspace() {
        CommonActions.scrollToElement(deleteLink);
        CommonActions.click(deleteLink);
        CommonActions.click(deleteConfirmButton);
    }
}
