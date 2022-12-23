package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import steps.BaseClassLead;

@CucumberOptions(features = "src/test/java/features/Login.feature",glue = "steps",monochrome = true,publish = true,
dryRun = false,snippets = SnippetType.CAMELCASE,tags="@Smoke")

public class Runner extends BaseClassLead{

}

