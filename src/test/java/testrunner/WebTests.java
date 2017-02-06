package testrunner;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/webtest/cucumber.json",
        detailedReport = true,
        detailedAggregatedReport = true,

        toPDF = true,
        overviewReport = true,
        outputFolder = "target/webtest")
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"html:target/webtest/cucumber-html-report/",
                "json:target/webtest/cucumber.json", "pretty:target/webtest/cucumber-pretty.txt",
                "usage:target/webtest/cucumber-usage.json", "junit:target/webtest/cucumber-results.xml"},
        glue = "com.ons.dp.frontend.test",
        tags = {"@Media"}
)

public class WebTests extends BaseTestRunner {
}
