package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

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
