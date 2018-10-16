package org.fundacionjala.pivotal.model.pageObject.story;
import org.fundacionjala.pivotal.model.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StoryPage extends AbstractPage{

  @FindBy(css = "button[title='Add Story']") WebElement sideBarAddStoryButton;
  @FindBy(css = "[name='story[name]']") WebElement storyTitleText;
  @FindBy(css = "button[id*='story_close_']") WebElement saveButton;
  @FindBy(css = "[data-focus-id='TaskAdd']") WebElement enableTaskButton;
  @FindBy(css = "[placeholder='Add a task']") WebElement addTaskText;
  @FindBy(css = "button[data-aid='addTaskButton']") WebElement saveTaskEditButton;

  // This method is to click on Login Button.
  public void clickAddSideBarStoryButton(){
    wait.until(ExpectedConditions.elementToBeClickable(sideBarAddStoryButton));
    sideBarAddStoryButton.click();
  }

  // This method is to set on text story title.
  public void setStoryTitle(String text){
    wait.until(ExpectedConditions.visibilityOf(storyTitleText));
    storyTitleText.sendKeys(text);
  }

  //This method is to click on button save.
  public void clickSaveButton(){
    wait.until(ExpectedConditions.elementToBeClickable(saveButton));
    saveButton.click();
  }

  //This method is to click on enable task button
  public void clickEnableTaskButton(){
    wait.until(ExpectedConditions.elementToBeClickable(enableTaskButton));
    enableTaskButton.click();
  }

  // This method is to set on text to add text task.
  public void setAddText(String text){
    wait.until(ExpectedConditions.visibilityOf(addTaskText));
    addTaskText.sendKeys(text);
  }

  //This method is to click on enable task button
  public void clickSaveTaskButton(){
    wait.until(ExpectedConditions.elementToBeClickable(saveTaskEditButton));
    saveTaskEditButton.click();
  }

}
