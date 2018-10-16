package org.fundacionjala.pivotal.pageobjects.dashboard;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for Pivotal Dashboard Page.
 * @author Kevin Herrera, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class Dashboard extends AbstractPage {

    @FindBy(id = "create-project-button")
    private WebElement createProjectButton;

    @FindBy(id = "#create-workspace-button")
    private WebElement createWorkspaceButton;

    @FindBy(id = "//span[text()='Workspaces']")
    private WebElement workspacesTab;

    /**
     * Click on "Create Project" button inside Dashboard page.
     * @return .
     */
    public FormCreate clickCreateNewProjectButton() {
        CommonActions.waitAndClick(createProjectButton);
        return new FormCreate();
    }
    /**
     * Click workspace tab to enter the workspace creation mode
     */
    public void clickWorkspaceTab() {
        CommonActions.waitAndClick(workspacesTab);
    }
    /**
     * Click to enter the
     */
    public void clickCreateWorkspaceButton() {
        CommonActions.waitAndClick(createWorkspaceButton);
    }
}
