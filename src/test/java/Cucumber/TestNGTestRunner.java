package Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

//CucumberOptions - feature file path of the package where 
//TestNGTestRunner class is present from the project directory, 
//glue - path of the package of stepdefination class from project directory , 
//monochrome = true , plugin - what kind of report we want like html and it's path meantioned 
//in format html:path

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Cucumber", glue = "rahulshettyacademy.stepdefinations", monochrome = true, plugin = {
		"html:target/Cucumber.html"} ,tags ="@Regression")
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
