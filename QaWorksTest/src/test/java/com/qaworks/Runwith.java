package com.qaworks;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(dryRun = false , strict = false , features = "." , tags = "@cool" , format = {"pretty","html:target/cucumber"}, plugin = {"html:target/cucumber-html-report"})
@org.junit.runner.RunWith(Cucumber.class)
public class Runwith {
}
