package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import steps.BaseClassSalesForce;

@CucumberOptions(features = "src/test/java/features/NewOpportunity.feature",glue = "steps",monochrome = true,publish = true,
dryRun = false,snippets = SnippetType.CAMELCASE,tags="@Functional")

public class RunnerSalesforce extends BaseClassSalesForce{

}
