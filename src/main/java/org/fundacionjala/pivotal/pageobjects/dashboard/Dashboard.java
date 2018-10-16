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



    /**
     * Click on "Create Project" button inside Dashboard page.
     * @return .
     */
    public ProjectFormCreate clickCreateNewProject() {
        CommonActions.waitAndClick(createProjectButton);
        return new ProjectFormCreate();
    }

}
