package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features"}, glue = {"gui.stepdefinition"},
        plugin = {})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}