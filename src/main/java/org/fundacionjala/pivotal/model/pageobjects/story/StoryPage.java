package org.fundacionjala.pivotal.model.pageobjects.story;

import org.fundacionjala.pivotal.model.pageobjects.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object of Create Story on project view of pivotaltracker.com.
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
public class StoryPage extends AbstractPage {

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
        wait.until(ExpectedConditions.elementToBeClickable(sideBarAddStoryButton));
        sideBarAddStoryButton.click();
    }

    /**
     * This method is to set on text story title.
     * @param text story title.
     */
    public void setStoryTitle(final String text) {
        wait.until(ExpectedConditions.visibilityOf(storyTitleText));
        storyTitleText.sendKeys(text);
    }

    /**
     * This method is to click on button save.
     */
    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    /**
     * This method is to click on enable task button.
     */
    public void clickEnableTaskButton() {
        wait.until(ExpectedConditions.elementToBeClickable(enableTaskButton));
        enableTaskButton.click();
    }

    /**
     * This method is to set on text to add text task.
     * @param text task text.
     */
    public void setAddText(final String text) {
        wait.until(ExpectedConditions.visibilityOf(addTaskText));
        addTaskText.sendKeys(text);
    }

    /**
     * This method is to click on enable task button.
     */
    public void clickSaveTaskButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveTaskEditButton));
        saveTaskEditButton.click();
    }

}
