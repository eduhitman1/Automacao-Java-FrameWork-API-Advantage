package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//Web
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/features/GETDadosComplexos.feature" }, glue = { "steps" }, format = {
		"json:target/cucumber-json-report.json", "html:target/cucumber-report-html" }, plugin = {
				"json:target/cucumber-json-report.json", "html:target/cucumber-report-html",
				"com.cucumber.listener.ExtentCucumberFormatter:extent-reporting/CucumberExtentReport.html" })
public class Runner {
}
