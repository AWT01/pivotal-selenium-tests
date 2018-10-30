package org.fundacionjala.pivotal.pageobjects.projects;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.pivotal.pageobjects.epics.Epics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for Pivotal Settings Page.
 */
public class Projects extends AbstractPage {

    @FindBy(css = "a[data-aid='navTab-more']")
    private WebElement projectMoreButton;

    @FindBy(id = "project_name")
    private WebElement projectNameInputField;

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
     * get project id from project setting page.
     * @return id of project as string
     */
    public String getProjectIDSettings() {
        CommonActions.waitElement(projectIDText);
        CommonActions.scrollToElement(projectIDText);
        return CommonActions.getText(projectIDText);
    }

    /**
     * click on button that show epics tab.
     * @return page object Epics
     */
    public Epics clickEpicToggleButton() {
        if ("false".equals(CommonActions.getAttribute(epicsToggleButton, "data-panel-visible"))) {
            CommonActions.click(epicsToggleButton);
        }
        return new Epics();
    }

    /**
     * open a story from UI, by searching the name of project on dashboard page.
     * @param storyName name of story
     */
    public static void openStoryByName(final String storyName) {
        By elementToFind = By.xpath("//span[text()='" + storyName + "']");
        CommonActions.waitElement(elementToFind);
        WebElement element = WebDriverManager.getInstance().getDriver().findElement(elementToFind);
        CommonActions.doubleClick(element);
    }
}
