package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        openBrowser();
    }

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() {
        sendText(ConfigReader.read("hrms.admin"), loginPage.usernameField);
        sendText(ConfigReader.read("hrms.password"), loginPage.passwordField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        clickOnElement(loginPage.loginButton);
    }

    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        Assert.assertTrue(dashboardPage.messageText.isDisplayed());
        System.out.println("test passed");
    }

    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        String err = loginPage.errorMessage.getText();
        Assert.assertEquals("Invalid credentials", err);
        System.out.println("Error message shown");
    }

}
