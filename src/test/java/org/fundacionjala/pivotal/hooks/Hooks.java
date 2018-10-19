package org.fundacionjala.pivotal.hooks;

import cucumber.api.java.After;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.pivotal.pageobjects.projects.Projects;
import org.fundacionjala.pivotal.pageobjects.workspaces.Workspaces;

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
     * Delete Project.
     */
    @After(value = "@deleteProject")
    public void deleteCreatedProject() {
        if (!WebDriverManager.getInstance().getDriver().getCurrentUrl().contains("settings")) {
            projects.enterProjectSettings();
        }
        projects.deleteProject();
        WebDriverManager.getInstance().getDriver().close();
    }

    /**
     * Delete Workspace.
     */
    @After(value = "@deleteWorkspace")
    public void deleteCreatedWorkspace() {
        workspaces.deleteWorkspace();
        WebDriverManager.getInstance().getDriver().close();
    }
}
