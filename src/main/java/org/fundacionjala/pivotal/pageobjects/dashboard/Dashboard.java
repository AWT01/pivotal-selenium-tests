package org.fundacionjala.pivotal.pageobjects.dashboard;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;
import org.fundacionjala.pivotal.pageobjects.workspaces.Workspaces;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

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
     * Click to enter the workspace tab.
     */
    public NewWorkspaceForm clickCreateWorkspaceButton() {
        CommonActions.click(createWorkspaceButton);
        return new NewWorkspaceForm();
    }

    /**
     * this method gives the href for the first project.
     * @return url to access the project
     */
    public String getFirstProject() {
        return CommonActions.getAttribute(firstProject, "href");
    }

    /**
     * Dashboard method to create new project.
     * @param projectName name of the project
     * @param privacy public or private
     * @param account account for project
     * @return the new project
     */
    public Projects createNewProject (String projectName, String privacy, String account) {
        NewProjectForm formPage;
        formPage = clickCreateNewProjectButton();

        Map<String, String> formData = new HashMap<>();
        formData.put("name", projectName);
        formData.put("account", account);
        formData.put("privacy", privacy);
        formData.keySet().forEach(form -> formPage.getStrategyFormMap(formData).get(form).fillCreateProjectForm());
        //submit data to create new project
        return formPage.clickCreateButton();
    }

    /**
     * Create new workspace.
     * @param workspaceName name
     * @return the new workspace
     */
    public Workspaces createNewWorkspace (String workspaceName) {
        clickWorkspaceTab();
        NewWorkspaceForm formPage;
        formPage = clickCreateWorkspaceButton();
        formPage.setWorkspaceNameTextField(workspaceName);
        return formPage.clickCreateSubmit();
    }
}
