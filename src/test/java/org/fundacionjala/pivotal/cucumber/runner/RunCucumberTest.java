package org.fundacionjala.pivotal.cucumber.runner;

import java.util.Properties;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.core.ui.WebDriverManager;
import org.fundacionjala.core.util.Environment;
import org.fundacionjala.core.util.exceptions.EnvironmentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
@CucumberOptions(
        features = "src/test/resources/features/NewEpics.feature",
        glue = {"org.fundacionjala.pivotal.cucumber"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
/**
 * method which runs all features.
 */
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    private static final Logger LOGGER = LogManager.getLogger(RunCucumberTest.class);

    /**
     * this method execute before the tests.
     */
    @BeforeClass
    public void open() {
        Properties properties = Environment.getInstance().getProperties();
        if (StringUtils.isEmpty(properties.getProperty("user1"))
                || StringUtils.isEmpty(properties.getProperty("password1"))) {
            LOGGER.error("There aren't the request data");
            throw new EnvironmentException();
        }
    }
    /**
     * this method close the browser after the features finish.
     */
    @AfterClass
    public void close() {
        WebDriverManager.getInstance().getDriver().close();
    }
}
