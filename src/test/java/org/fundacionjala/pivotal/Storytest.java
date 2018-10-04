package org.fundacionjala.pivotal;
import org.fundacionjala.pivotal.model.pageObject.WebDriverManager;
import org.fundacionjala.pivotal.model.pageObject.login.SignInPage;
import org.fundacionjala.pivotal.model.pageObject.story.StoryPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Storytest {

  @BeforeClass
  public void setUP(){
    SignInPage.loginAs("elianor@gmail.com","");
  }

  @Test
  public void testclick(){
    WebDriverManager.getInstance().getDriver().get("https://www.pivotaltracker.com/n/projects/2202174");
    StoryPage storyPage = new StoryPage();
    storyPage.initDriver();
    storyPage.clickAddSideBarStoryButton();
    storyPage.setStoryTitle("test...");
    storyPage.clickEnableTaskButton();
    storyPage.setAddText("add test task");
    storyPage.clickSaveTaskButton();
    storyPage.clickSaveButton();
  }
}
