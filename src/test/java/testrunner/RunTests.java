package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/e2e-scenarios",
          plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
        glue = "com.ons.dp.frontend.test",
        tags = "@time_series")
public class RunTests {


}
