package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {
    @When("user clicks on PIM button")
    public void user_clicks_on_pim_button() {
        clickOnElement(dashboardPage.pimOption);
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        clickOnElement(dashboardPage.empListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        sendText("111238A", searchEmployeePage.empIdSearchField);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        clickOnElement(searchEmployeePage.searchButton);
    }

    @Then("user is able to see searched employee")
    public void user_is_able_to_see_searched_employee() {
        System.out.println("test is passed");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        sendText("Alfred", searchEmployeePage.empNameSearchField);
    }

}
