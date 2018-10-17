package org.fundacionjala.pivotal.hooks;

import cucumber.api.java.After;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;
import org.fundacionjala.pivotal.pageobjects.workspaces.Workspaces;

/**
 * Hooks for cucumber.
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
public class Hooks {

    private Dashboard dashboard;
    private Projects projects;
    private Workspaces workspaces;

    /**
     * Default constructor.
     * @param dashboard to d
     * @param projects to p
     * @param workspaces to w
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
