package com.salesforce.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/salesforcefeature.feature"},
		glue = {"com.salesforce.steps"},
		monochrome=true,
				dryRun=false,
				plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
					
		)

public class RunnerForSalesforce extends AbstractTestNGCucumberTests{

}
