package org.fundacionjala.pivotal.pages.workspaces;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Form to create workspaces.
 */
public class NewWorkspaceForm extends AbstractPage {

    @FindBy(css = ".tc-form__input")
    private WebElement workspaceNameTextField;

    @FindBy(css = ".pvXpn__Button--positive")
    private WebElement createSubmit;
    /**
     * Submit the new workspace for creation.
     * @return the workspace page
     */
    public Workspaces clickCreateSubmit() {
        CommonActions.click(createSubmit);
        return new Workspaces();
    }
    /**
     * Set the workspace name on the form displayed.
     * @param workspaceName to create workspace
     */
    public void setWorkspaceNameTextField(final String workspaceName) {
        CommonActions.setText(workspaceNameTextField, workspaceName);
    }

}
