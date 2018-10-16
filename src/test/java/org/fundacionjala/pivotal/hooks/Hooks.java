package org.fundacionjala.pivotal.hooks;

import cucumber.api.java.After;
import org.fundacionjala.pivotal.pageobjects.dashboard.Dashboard;

public class Hooks {

    private Dashboard dashboard;

    /**
     * Default Constructor.
     *
     * @param dashboard to manage projects, workspaces and stories
     */
    public Hooks(final Dashboard dashboard) {
        this.dashboard = dashboard;
    }


    /**
     * Delete Project.
     */
    @After(value = "@deleteProject")
    public void deleteCreatedProject() {
        dashboard.clickCreateNewProject();
    }

    /**
     * Delete Workspace.
     */
    @After(value = "@deleteWorkspace")
    public void deleteCreatedWorkspace() {
        dashboard.clickCreateNewProject();
    }
}
