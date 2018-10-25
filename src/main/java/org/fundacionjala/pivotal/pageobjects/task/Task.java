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

    @FindBy(css = "[placeholder='Add a task']")
    private WebElement addTaskText;

    @FindBy(css = "button[data-aid='addTaskButton']")
    private WebElement saveTaskEditButton;

    @FindBy(css = ".tracker_markup")
    private WebElement firstTask;

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
     * method which returns the first task.
     * @return string.
     */
    public String getFirstTask() {
        return CommonActions.getText(firstTask);
    }
}
