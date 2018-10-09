package org.fundacionjala.pivotal.model.pageobjects.dashboard;

import org.fundacionjala.pivotal.model.pageobjects.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object for Pivotal Dashboard Page.
 * @author Kevin Herrera - AWT-[01].
 * @version 0.1
 */
public class PageDashboard  extends AbstractPage {

    @FindBy(id = "create-project-button")
    private WebElement createProjectButton;

    /**
     * Click on "Create Project" button inside Dashboard page.
     * @return .
     */
    public PageFormCreate clickCreateNewProject() {
        wait.until(ExpectedConditions.elementToBeClickable(createProjectButton));
        createProjectButton.click();
        return new PageFormCreate();
    }
}
