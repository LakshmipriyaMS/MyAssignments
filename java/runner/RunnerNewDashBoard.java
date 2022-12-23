package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import steps.BaseClassSalesForce;

@CucumberOptions(features = "src/test/java/features/NewDashborad.feature",glue = "steps",monochrome = true,publish = true,
dryRun = false,snippets = SnippetType.CAMELCASE,tags="@Sanity")

public class RunnerNewDashBoard extends BaseClassSalesForce{

}
