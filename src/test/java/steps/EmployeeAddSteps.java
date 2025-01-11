package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;
import java.util.Map;

public class EmployeeAddSteps extends CommonMethods {
    @When("user clicks on Add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmpOption = driver.findElement(By.id("menu_pim_addEmployee"));
        addEmpOption.click();
    }

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        firstNameField.sendKeys("mark");
        lastNameField.sendKeys("jacob");
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement midNameField = driver.findElement(By.id("middleName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        firstNameField.sendKeys("mark");
        midNameField.sendKeys("ms");
        lastNameField.sendKeys("jacob");
    }

    @When("user enters {string} and {string} and {string} in the application")
    public void user_enters_and_and_in_the_application(String fn, String mn, String ln) {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement midNameField = driver.findElement(By.id("middleName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        firstNameField.sendKeys(fn);
        midNameField.sendKeys(mn);
        lastNameField.sendKeys(ln);
    }

    @When("user adds {string} , {string} and {string}")
    public void user_adds_and(String fn, String mn, String ln) {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement midNameField = driver.findElement(By.id("middleName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        firstNameField.sendKeys(fn);
        midNameField.sendKeys(mn);
        lastNameField.sendKeys(ln);
    }

    @When("user adds multiple employees using table and save them")
    public void user_adds_multiple_employees_using_table_and_save_them(
            io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        for (Map<String, String> employee:employeeNames) {
            WebElement firstNameField = driver.findElement(By.id("firstName"));
            WebElement midNameField = driver.findElement(By.id("middleName"));
            WebElement lastNameField = driver.findElement(By.id("lastName"));
            firstNameField.sendKeys(employee.get("firstName"));
            midNameField.sendKeys(employee.get("middleName"));
            lastNameField.sendKeys(employee.get("lastName"));

            WebElement saveBtn = driver.findElement(By.id("btnSave"));
            saveBtn.click();

            WebElement addEmpOption = driver.findElement(By.id("menu_pim_addEmployee"));
            addEmpOption.click();

        }
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveBtn = driver.findElement(By.id("btnSave"));
        saveBtn.click();
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("employee added successfully");
    }

}
