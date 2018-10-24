package org.fundacionjala.pivotal.pageobjects.epics;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to manage epics page on a pivotal's project.
 */
public class Epics extends AbstractPage {
    @FindBy (css = "button[data-panel-id*='epics_']")
    private WebElement epicsToggleButton;
    @FindBy (css = "a[title='Add Epic']")
    private WebElement epicsAddButton;
    @FindBy (css = "textArea[name='epic[name]']")
    private WebElement epicNameTextField;
    @FindBy (css = "button[id*='epic_close")
    private WebElement epicSaveButton;
    @FindBy (css = ".tracker_markup")
    private WebElement epicNameLocator;

    /**
     * set the epic name text field.
     * @param text epic name
     */
    public void setEpicNameTextField(final String text) {
        CommonActions.setText(epicNameTextField, text);
    }

    /**
     * click on button show epic tab.
     */
    public void clickEpicToggleButton() {
        CommonActions.click(epicsToggleButton);
    }

    /**
     * click on button add epic.
     */
    public void clickEpicAddButton() {
        CommonActions.click(epicsAddButton);
    }

    /**
     * click on button save epic changes.
     */
    public void clickEpicSaveButton() {
        CommonActions.click(epicSaveButton);
    }

    /**
     * get the text inside the title of the epic just created.
     * @return name of the epic just created
     */
    public String getNameLocatorText() {
        return CommonActions.getText(epicNameLocator);
    }
}
