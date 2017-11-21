package runnerPackage;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


 
@RunWith(Cucumber.class)
@CucumberOptions(features={"features"}, glue="stepdefinition",dryRun = false)
public class Runner {

}