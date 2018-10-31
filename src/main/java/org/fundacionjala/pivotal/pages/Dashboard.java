package org.fundacionjala.pivotal.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.pivotal.pages.projects.NewProjectForm;
import org.fundacionjala.pivotal.pages.workspaces.NewWorkspaceForm;
import org.openqa.selenium.By;
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

    @FindBy(id = "create-workspace-button")
    private WebElement createWorkspaceButton;

    @FindBy(xpath = "//span[contains(text(), 'Workspaces')]")
    private WebElement workspacesTab;

    @FindBy(css = "a[data-aid='project-name']")
    private WebElement firstProject;

    @FindBy(css = "button[data-aid='show-more-projects-button']")
    private WebElement showMoreProjects;

    /**
     * Click on "Create Project" button inside Dashboard page.
     * @return .
     */
    public NewProjectForm clickCreateNewProjectButton() {
        CommonActions.click(createProjectButton);
        return new NewProjectForm();
    }
    /**
     * Click workspace tab to enter the workspace creation mode.
     */
    public void clickWorkspaceTab() {
        CommonActions.click(workspacesTab);
    }

    /**
     * Click to enter workspace tab.
     * @return form
     */
    public NewWorkspaceForm clickCreateWorkspaceButton() {
        CommonActions.click(createWorkspaceButton);
        return new NewWorkspaceForm();
    }

    /**
     * click on button show more project from dashboard.
     */
    private void clickShowMoreProjects() {
        if (showMoreProjects != null) {
            CommonActions.click(showMoreProjects);
        }
    }

    /**
     * open a project from UI, searching name on dashboard page.
     * @param projectName name of project
     */
    public void openProjectByName(final String projectName) {
        clickShowMoreProjects();
        WebElement element = WebDriverManager.getInstance().getDriver()
                .findElement(By.xpath("//a[text()='" + projectName + "']"));
        CommonActions.scrollToElement(element);
        CommonActions.click(element);
    }

}
