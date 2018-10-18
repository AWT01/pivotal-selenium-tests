package org.fundacionjala.pivotal.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.fundacionjala.core.ui.WebDriverManager;
import org.testng.annotations.AfterClass;

/**
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.fundacionjala.pivotal.cucumber"},
//        tags = {"~@Ignore"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    /**
     * After the tests.
     */
    @AfterClass
    public void close() {
        WebDriverManager.getInstance().getDriver().close();
    }
}
