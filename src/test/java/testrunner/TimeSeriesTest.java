package testrunner;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber.json",
        detailedReport = true,
        detailedAggregatedReport = true,
        toPDF = true,
        overviewReport = true,
        outputFolder = "target")
@CucumberOptions(
        features = "src/test/resources/features/e2e-scenarios",
          plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
        glue = "com.ons.dp.frontend.test",
        tags = "@time_series")
public class TimeSeriesTest extends BaseTestRunner {



}
