package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

import java.time.Duration;

public class Hooks extends CommonMethods {
    @Before
    public void start() {
        openBrowser();
//        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
    }

    @After
    public void end(Scenario scenario){
        //scenario class - this class contains all the information about execution logs
        //screenshot right before the browser closes
        byte[] pic;
        if(scenario.isFailed()) {
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }

        closeBrowser();
    }
}
