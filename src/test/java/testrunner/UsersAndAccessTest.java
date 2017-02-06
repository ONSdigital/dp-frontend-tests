package testrunner;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/florence/cucumber.json",
        detailedReport = true,
        detailedAggregatedReport = true,
        toPDF = true,
        overviewReport = true,
        outputFolder = "target/florence")
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"html:target/florence/cucumber-html-report/",
                "json:target/florence/cucumber.json", "pretty:target/florence/cucumber-pretty.txt",
                "usage:target/florence/cucumber-usage.json", "junit:target/florence/cucumber-results.xml"},
        glue = "com.ons.dp.frontend.test",
        //  tags = {"@admin,@publisher,@users_and_access,@viewer,@visualisation_publisher,@time_series,@release_calendar,@searchindex_updates,@Media"})
        tags = {"@time_series,@manual_collection,@schedule_collection,@delete_content,@release_calendar,@searchindex_updates,@admin,@publisher,@users_and_access,@viewer,@visualisation_publisher"})
//  tags = {"@manual_collection"})

public class UsersAndAccessTest extends BaseTestRunner {


}


