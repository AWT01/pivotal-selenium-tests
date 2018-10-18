package org.fundacionjala.pivotal.pageobjects.story;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Create Story on project view of pivotaltracker.com.
 * @author Angelica Lopez, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class Story extends AbstractPage {

    @FindBy(css = "button[title='Add Story']")
    private WebElement sideBarAddStoryButton;

    @FindBy(css = "[name='story[name]']")
    private WebElement storyTitleText;

    @FindBy(css = "button[id*='story_close_']")
    private WebElement saveButton;

    @FindBy(css = "[data-focus-id='TaskAdd']")
    private WebElement enableTaskButton;

    @FindBy(css = "[placeholder='Add a task']")
    private WebElement addTaskText;

    @FindBy(css = "button[data-aid='addTaskButton']")
    private WebElement saveTaskEditButton;

    @FindBy(css = ".story_name")
    private WebElement firstStory;

    /**
     * This method is to click on Login Button.
     */
    public void clickAddSideBarStoryButton() {
        CommonActions.click(sideBarAddStoryButton);
    }

    /**
     * This method is to set on text story title.
     * @param text story title.
     */
    public void setStoryTitle(final String text) {
        CommonActions.setText(storyTitleText, text);
    }

    /**
     * This method is to click on button save.
     */
    public void clickSaveButton() {
        CommonActions.click(saveButton);
    }

    /**
     * This method is to click on enable task button.
     */
    public void clickEnableTaskButton() {
        CommonActions.click(enableTaskButton);
    }

    /**
     * This method is to set on text to add text task.
     * @param text task text.
     */
    public void setAddText(final String text) {
        CommonActions.setText(addTaskText, text);
    }

    /**
     * This method is to click on enable task button.
     */
    public void clickSaveTaskButton() {
        CommonActions.click(saveTaskEditButton);
    }

    /**
     * Method to get the first story on the list.
     * @return the name of the first story
     */
    public String getFirstStory() {
        return CommonActions.getText(firstStory);
    }
}
