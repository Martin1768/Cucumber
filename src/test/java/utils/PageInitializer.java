package utils;

import pages.AddEmployeePage;
import pages.LoginPage;

public class PageInitializer {
    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;

    public static void initPageObjects() {
        loginPage = new LoginPage();
        addEmployeePage = new AddEmployeePage();
    }
}
