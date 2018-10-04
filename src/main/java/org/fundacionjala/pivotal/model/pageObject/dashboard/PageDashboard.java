package org.fundacionjala.pivotal.model.pageObject.dashboard;

import org.fundacionjala.pivotal.model.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Kevin Herrera - AWT-[01].
 * @version 0.1
 */
public class PageDashboard  extends AbstractPage {

    @FindBy(id = "create-project-button")
    private WebElement createProjectButton;

    /**
     * .
     * @return .
     */
    public PageFormCreate clickCreateNewProject() {
        wait.until(ExpectedConditions.elementToBeClickable(createProjectButton));
        createProjectButton.click();
        return new PageFormCreate();
    }
}
