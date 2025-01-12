package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "steps",
        dryRun = false,  // true is for validating all scenarios and return result if they are ok or not
        // plugin = {"pretty"},   // detailed report of every step
        tags = "@addemployeebydata"
)


public class RunnerClass {
}
