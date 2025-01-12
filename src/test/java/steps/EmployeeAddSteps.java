package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ExcelReader;

import java.io.IOException;
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
        sendText("mark", addEmployeePage.firstNameField);
        sendText("jacob", addEmployeePage.lastNameField);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        sendText("mark", addEmployeePage.firstNameField);
        sendText("mark", addEmployeePage.midNameField);
        sendText("jacob", addEmployeePage.lastNameField);
    }

    @When("user enters {string} and {string} and {string} in the application")
    public void user_enters_and_and_in_the_application(String fn, String mn, String ln) {
        sendText(fn, addEmployeePage.firstNameField);
        sendText(mn, addEmployeePage.midNameField);
        sendText(ln, addEmployeePage.lastNameField);
    }

    @When("user adds {string} , {string} and {string}")
    public void user_adds_and(String fn, String mn, String ln) {
        sendText(fn, addEmployeePage.firstNameField);
        sendText(mn, addEmployeePage.midNameField);
        sendText(ln, addEmployeePage.lastNameField);
    }

    @When("user adds multiple employees using table and save them")
    public void user_adds_multiple_employees_using_table_and_save_them(
            io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        for (Map<String, String> employee:employeeNames) {
            sendText(employee.get("firstName"), addEmployeePage.firstNameField);
            sendText(employee.get("middleName"), addEmployeePage.midNameField);
            sendText(employee.get("lastName"), addEmployeePage.lastNameField);
            clickOnElement(addEmployeePage.saveBtn);
            clickOnElement(addEmployeePage.addEmpOption);
        }
    }
    @When("user adds multiple employees from excel file")
    public void user_adds_multiple_employees_from_excel_file() throws IOException {
        ExcelReader data = new ExcelReader();
        List<Map<String, String>> newEmployees = data.getAllSheetCells("List 1");
        for (Map<String, String> employee : newEmployees) {
            sendText(employee.get("firstName"), addEmployeePage.firstNameField);
            sendText(employee.get("middleName"), addEmployeePage.midNameField);
            sendText(employee.get("lastName"), addEmployeePage.lastNameField);
            clickOnElement(addEmployeePage.saveBtn);
            clickOnElement(addEmployeePage.addEmpOption);
        }
    }

    @When("user adds multiple employees from workbook {string} and sheet {string}")
    public void user_adds_multiple_employees_from_workbook_and_sheet(String xlsxFile, String sheet) throws IOException {
        System.out.println("Workbook " + xlsxFile + ", sheet " + sheet);
        ExcelReader data = new ExcelReader(xlsxFile);
        List<Map<String, String>> newEmployees = data.getAllSheetCells(sheet);
        for (Map<String, String> employee : newEmployees) {
            sendText(employee.get("firstName"), addEmployeePage.firstNameField);
            sendText(employee.get("middleName"), addEmployeePage.midNameField);
            sendText(employee.get("lastName"), addEmployeePage.lastNameField);
            clickOnElement(addEmployeePage.saveBtn);
            clickOnElement(addEmployeePage.addEmpOption);
        }
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        clickOnElement(addEmployeePage.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("employee added successfully");
    }

}
