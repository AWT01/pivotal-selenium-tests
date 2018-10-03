package org.fundacionjala.pivotal.model.pageObject.story;

import org.fundacionjala.pivotal.model.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StoryPage extends AbstractPage{
  //Using FindBy for locating elements
  @FindBy(how= How.LINK_TEXT, using="[title='Add Story']")
  WebElement addStoryButton;
  @FindBy(how=How.LINK_TEXT, using="[data-aid='Sidebar_AddStoryButton']") WebElement sideBarAddStoryButton;
  //@FindBy(how=How.XPATH, using="//a[@data-aid='project-name'][@value='test']") WebElement projectTest;
  @FindBy(how=How.CSS, using="a[value='test']") WebElement projectTest;

  //*[@id="elm-root"]/div/div[3]/div[2]/div[1]/section/ol/li/header/div/div/div[2]/a

  // This method is to click on Login Button
  public void clickStoryButton(){
    //wait.until(ExpectedConditions.elementToBeClickable(addStoryButton));
    projectTest.click();
  }

  // This method is to click on Login Button
  public void clickAddStoryButton(){
    //wait.until(ExpectedConditions.elementToBeClickable(addStoryButton));
    addStoryButton.click();
  }

  // This method is to click on Login Button
  public void clickAddSideBarStoryButton(){
    //wait.until(ExpectedConditions.elementToBeClickable(sideBarAddStoryButton));
    sideBarAddStoryButton.click();
  }
}
