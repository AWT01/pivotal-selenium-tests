package org.fundacionjala.pivotal.hooks;

import cucumber.api.java.After;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;
import org.fundacionjala.pivotal.pageobjects.workspaces.Workspaces;

public class Hooks {

    private Dashboard dashboard;
    private Projects projects;
    private Workspaces workspaces;

    /**
     * Default Constructor.
     *
     * @param dashboard to manage projects, workspaces and stories
     */
    public Hooks(final Dashboard dashboard, final Projects projects, final Workspaces workspaces) {
        this.dashboard = dashboard;
        this.projects = projects;
        this.workspaces = workspaces;
    }


    /**
     * Delete Project.
     */
    @After(value = "@deleteProject")
    public void deleteCreatedProject() {
        projects.deleteProject();
        WebDriverManager.getInstance().getDriver().close();
    }

    /**
     * Delete Workspace.
     */
    @After(value = "@deleteWorkspace")
    public void deleteCreatedWorkspace() {
        workspaces.deleteWorkspace();
    }
}
