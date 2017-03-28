package com.cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features ="Feature"
		,glue={"StepDefinition"}
		,format={"html:target/cucumber-html-report"}
		)

public class TestRunner {

}
