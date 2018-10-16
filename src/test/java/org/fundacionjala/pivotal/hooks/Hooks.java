package org.fundacionjala.pivotal.hooks;

import cucumber.api.java.After;
import org.fundacionjala.pivotal.pageobjects.dashboard.PageDashboard;

public class Hooks {

    private PageDashboard dashboard;

    /**
     * Default Constructor.
     *
     * @param pageDashboard to manage projects, workspaces and stories
     */
    public Hooks(final PageDashboard pageDashboard) {
        this.dashboard = pageDashboard;
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
