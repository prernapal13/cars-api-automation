package cars.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

// @formatter:off

@RunWith(Cucumber.class)
@CucumberOptions
    (features = {"src\\test\\resources"},
        glue = {"cars.stepDefinitions"},
        monochrome = true,
        tags = {},
        plugin = {"pretty",
            "html:target/cucumber",
            "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"})

//@formatter:on
public class MainRunner extends AbstractTestNGCucumberTests {

}
