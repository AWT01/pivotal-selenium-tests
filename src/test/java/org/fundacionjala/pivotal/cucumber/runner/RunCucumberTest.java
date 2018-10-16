package org.fundacionjala.pivotal.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * .
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

}
