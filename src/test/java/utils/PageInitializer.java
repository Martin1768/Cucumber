package utils;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SearchEmployeePage;

public class PageInitializer {
    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;
    public static SearchEmployeePage searchEmployeePage;
    public static DashboardPage dashboardPage;

    public static void initPageObjects() {
        loginPage = new LoginPage();
        addEmployeePage = new AddEmployeePage();
        searchEmployeePage = new SearchEmployeePage();
        dashboardPage = new DashboardPage();
    }
}
