package org.fundacionjala.pivotal;
import org.fundacionjala.pivotal.model.pageobjects.story.StoryPage;
import org.fundacionjala.pivotal.model.pageobjects.WebDriverManager;
import org.fundacionjala.pivotal.model.pageobjects.login.SignInPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test of story page.
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
public class StoryTest {

    private static final String PROJECT_PAGE_URL = "https://www.pivotaltracker.com/n/projects/2203077";

    /**
     * Set up of test create project, set valid user credentials for pivotaltracker.com inside this method.
     */
    @BeforeClass
    public void setUP() {
        SignInPage.loginAs("aaaaa@aaaaa", "111111");
    }

    /**
     * test of create and save story .
     */
    @Test
    public void testClick() {
        WebDriverManager.getInstance().getDriver().get(PROJECT_PAGE_URL);
        StoryPage storyPage = new StoryPage();
        storyPage.clickAddSideBarStoryButton();
        storyPage.setStoryTitle("test...");
        storyPage.clickEnableTaskButton();
        storyPage.setAddText("add test task");
        storyPage.clickSaveTaskButton();
        storyPage.clickSaveButton();
    }
}

