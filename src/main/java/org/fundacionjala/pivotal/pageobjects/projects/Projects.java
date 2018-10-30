package org.fundacionjala.pivotal.pageobjects.projects;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.pivotal.pageobjects.epics.Epics;
import org.fundacionjala.pivotal.restapi.RequestManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for Pivotal Settings Page.
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class Projects extends AbstractPage {

    @FindBy(css = "a[data-aid='navTab-more']")
    private WebElement projectMoreButton;

    @FindBy(id = "project_name")
    private WebElement projectNameInputField;

    @FindBy(id = "delete_link")
    private WebElement projectDeleteLink;

    @FindBy(id = "confirm_delete")
    private WebElement projectDeleteConfirmButton;

    @FindBy(css = "td[class='text_column']")
    private WebElement projectIDText;

    @FindBy (css = "button[data-panel-id*='epics_']")
    private WebElement epicsToggleButton;
    /**
     * Getter of project name input field on create project settings page.
     * @return webElement object.
     */
    public WebElement getProjectNameInputField() {
        CommonActions.waitElement(projectNameInputField);
        return projectNameInputField;
    }

    /**
     * Click on more button inside project page.
     */
    public void enterProjectSettings() {
        CommonActions.waitElement(projectMoreButton);
        String newURL = WebDriverManager.getInstance().getDriver().getCurrentUrl().replace("/n", "") + "/settings";
        WebDriverManager.getInstance().getDriver().navigate().to(newURL);
    }

    /**
     * Delete the current project page.
     */
    public void deleteProject() {
        CommonActions.waitElement(projectDeleteLink);
        CommonActions.scrollToElement(projectDeleteLink);
        CommonActions.click(projectDeleteLink);
        CommonActions.click(projectDeleteConfirmButton);
    }

    public String getProjectIDSettings() {
        CommonActions.waitElement(projectIDText);
        CommonActions.scrollToElement(projectIDText);
        return CommonActions.getText(projectIDText);
    }

    /**
     * click on button that show epics tab.
     */
    public Epics clickEpicToggleButton() {
        if ("false".equals(CommonActions.getAttribute(epicsToggleButton, "data-panel-visible"))) {
            CommonActions.click(epicsToggleButton);
        }
        return new Epics();
    }
}
