package org.fundacionjala.pivotal.pageobjects.task;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for task.
 */
public class Task extends AbstractPage {

    @FindBy(css = "[data-focus-id='TaskAdd']")
    private WebElement enableTaskButton;

    @FindBy(css = "[data-aid='editor']")
    private WebElement addEditTaskText;

    @FindBy(css = "[data-aid='new']")
    private WebElement addNewTaskText;

    @FindBy(css = "button[data-aid='addTaskButton']")
    private WebElement saveTaskEditButton;

    @FindBy(css = "div[data-aid='TaskDescription']")
    private WebElement firstTask;

    @FindBy(css = "button[data-aid='saveTaskButton']")
    private WebElement saveEditedTaskButton;

    /**
     * This method is to click on enable task button.
     */
    public void clickEnableTaskButton() {
        CommonActions.click(enableTaskButton);
    }

    /**
     * This method set the text to edit text task.
     * @param text task text.
     */
    public void setAddEditText(final String text) {
        CommonActions.setText(addEditTaskText, text);
    }

    /**
     * This method set the text to add new text task.
     * @param text string.
     */
    public void setAddNewTaskText(final String text) {
        CommonActions.setText(addNewTaskText, text);
    }

    /**
     * This method is to click on enable task button.
     */
    public void clickSaveNewTaskButton() {
        CommonActions.click(saveTaskEditButton);
    }

    /**
     * method which returns the first task.
     * @return string.
     */
    public String getFirstTask() {
        return CommonActions.getText(firstTask);
    }

    /**
     * method to select the task.
     */
    public void clickFirstTask() {
        CommonActions.click(firstTask);
    }

    /**
     * save the edited text.
     */
    public void clickSaveEditTaskButton() {
        CommonActions.click(saveEditedTaskButton);
    }
}
