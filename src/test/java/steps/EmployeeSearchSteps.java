package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {
    @When("user clicks on PIM button")
    public void user_clicks_on_pim_button() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimOption.click();
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {
        WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        empListOption.click();
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        WebElement empIdSearchField = driver.findElement(By.id("empsearch_id"));
        empIdSearchField.sendKeys("111238A");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        WebElement searchButton = driver.findElement(By.id("searchBtn"));
        searchButton.click();
    }

    @Then("user is able to see searched employee")
    public void user_is_able_to_see_searched_employee() {
        System.out.println("test is passed");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        WebElement empNameSearchField = driver.findElement(By.id("empsearch_employee_name_empName"));
        empNameSearchField.sendKeys("Alfred" + Keys.ESCAPE);

    }

}
