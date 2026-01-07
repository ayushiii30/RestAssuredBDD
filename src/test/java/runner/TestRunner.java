package runner;

import org.testng.annotations.Listeners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ExtentTestNGListener;


@Listeners({ExtentTestNGListener.class})
@CucumberOptions(
        features = "src/test/java/features",        
        glue = {"stepdefinitions"},                 
        plugin = {
                "pretty",                          
                "html:target/cucumber-report.html", 
                "json:target/cucumber-report.json"  
        },
        monochrome = true                           
)
public class TestRunner extends AbstractTestNGCucumberTests {
}



