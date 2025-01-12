package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt",
        glue = "steps",
        dryRun = false,  // true is for validating all scenarios and return result if they are ok or not
        plugin = {"pretty",  // detailed report of every step
                "html:target/cucumber.html",  // reports
        "rerun:target/failed.txt"},   // generates tyt file contains the path of failed test cases
        tags = "@loggin"
)


public class FailedRunner {
}
