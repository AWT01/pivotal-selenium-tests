package org.fundacionjala.pivotal.model.pageobjects.story;

import org.fundacionjala.pivotal.model.pageobjects.MozillaFirefox;
import org.fundacionjala.pivotal.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Create Story on project view of pivotaltracker.com.
 * @author Angelica Lopez, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class StoryPage extends MozillaFirefox {

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

    /**
     * This method is to click on Login Button.
     */
    public void clickAddSideBarStoryButton() {
        CommonActions.waitAndClick(sideBarAddStoryButton);
    }

    /**
     * This method is to set on text story title.
     * @param text story title.
     */
    public void setStoryTitle(final String text) {
        CommonActions.waitAndSetText(storyTitleText, text);
    }

    /**
     * This method is to click on button save.
     */
    public void clickSaveButton() {
        CommonActions.waitAndClick(saveButton);
    }

    /**
     * This method is to click on enable task button.
     */
    public void clickEnableTaskButton() {
        CommonActions.waitAndClick(enableTaskButton);
    }

    /**
     * This method is to set on text to add text task.
     * @param text task text.
     */
    public void setAddText(final String text) {
        CommonActions.waitAndSetText(addTaskText, text);
    }

    /**
     * This method is to click on enable task button.
     */
    public void clickSaveTaskButton() {
        CommonActions.waitAndClick(saveTaskEditButton);
    }

}
