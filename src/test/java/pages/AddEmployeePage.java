package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(id="firstName")
    public WebElement firstNameField;

    @FindBy(id="middleName")
    public WebElement midNameField;

    @FindBy(id="lastName")
    public WebElement lastNameField;

    @FindBy(id="btnSave")
    public WebElement saveBtn;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmpOption;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}
