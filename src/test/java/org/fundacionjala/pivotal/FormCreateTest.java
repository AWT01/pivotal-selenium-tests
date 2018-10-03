package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.model.AbstractPage;
import org.fundacionjala.pivotal.model.PageObjectFactory;
import org.fundacionjala.pivotal.model.pageObject.dashboard.PageDashboard;
import org.fundacionjala.pivotal.model.pageObject.dashboard.PageFormCreate;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class FormCreateTest {

    private PageFormCreate formPage;

    /**
     * .
     */
    @BeforeTest
    public void pressCreateProject() {
        PageDashboard dashboard = new PageDashboard(AbstractPage.instanceFirefoxDriver(), PageDashboard.PAGE_URL);
        PageObjectFactory.initElements(dashboard.getDriver(), dashboard);
        formPage = dashboard.clickCreateNewProject();
    }

    /**
     * .
     */
    @Test
    public void testSetProjectName() {
        formPage.setProjectName("testProject");
    }
}
