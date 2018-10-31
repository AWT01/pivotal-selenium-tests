package org.fundacionjala.pivotal.pageobjects.story;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.CommonActions;
import org.fundacionjala.pivotal.pageobjects.comment.Comments;
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

    @FindBy(css = ".story_name")
    private WebElement firstStory;

    @FindBy(css = "textarea[data-aid='Comment__textarea']")
    private WebElement textAreaComment;

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
     * Method to get the first story on the list.
     * @return the name of the first story
     */
    public String getFirstStory() {
        return CommonActions.getText(firstStory);
    }

    /**
     * scrool view to comment text box.
     * @return page object Comments;
     */
    public Comments scrollToCommentTextField() {
        CommonActions.scrollToElement(textAreaComment);
        return new Comments();
    }
}
