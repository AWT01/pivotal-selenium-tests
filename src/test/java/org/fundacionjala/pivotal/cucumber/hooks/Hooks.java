package org.fundacionjala.pivotal.cucumber.hooks;

import cucumber.api.java.After;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;
import org.fundacionjala.pivotal.pageobjects.workspaces.Workspaces;
import org.fundacionjala.pivotal.restapi.RequestManager;

/**
 * Hooks for cucumber.
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
public class Hooks {

    private Projects projects;
    private Workspaces workspaces;

    /**
     * Default constructor.
     * @param projects to p
     * @param workspaces to w
     */
    public Hooks(final Projects projects, final Workspaces workspaces) {
        this.projects = projects;
        this.workspaces = workspaces;
    }


    /**
     * Delete Project using api request.
     */
    @After(value = "@deleteProject")
    public void deleteCreatedProject() {
        if (!WebDriverManager.getInstance().getDriver().getCurrentUrl().contains("settings")) {
            projects.enterProjectSettings();
        }
        RequestManager.deleteRequest("/projects/" + projects.getProjectIDSettings());
    }

    /**
     * Delete Workspace.
     */
    @After(value = "@deleteWorkspace")
    public void deleteCreatedWorkspace() {
        workspaces.deleteWorkspace();
    }
}
