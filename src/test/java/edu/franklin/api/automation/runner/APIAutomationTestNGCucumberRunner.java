package edu.franklin.api.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/api/automation/features", glue = "edu.franklin.api.automation.step.definition", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/html/ExtentReport.html" })//target/html/ExtentReport.html
public class APIAutomationTestNGCucumberRunner extends AbstractTestNGCucumberTests {

	

}
