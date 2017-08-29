package testrunner;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cmdtest/cucumber.json",
        detailedReport = true,
        detailedAggregatedReport = true,

        toPDF = true,
        overviewReport = true,
        outputFolder = "target/cmdtest")
@CucumberOptions(
        features = "src/test/resources/features/CMD",
        plugin = {"html:target/cmdtest/cucumber-html-report/",
                "json:target/cmdtest/cucumber.json", "pretty:target/cmdtest/cucumber-pretty.txt",
                "usage:target/cmdtest/cucumber-usage.json", "junit:target/cmdtest/cucumber-results.xml"},
        glue = "com.ons.dp.frontend.test",
        tags = {"@cpi"}
)
public class CMDTests extends BaseTestRunner{
}
