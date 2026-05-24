package stepdefinition;

import Pages.EmployeePage;
import Pages.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class EmployeePageStepDefinition {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    EmployeePage employeePage = new EmployeePage(DriverFactory.getDriver());

    @Given("I am logged into OrangeHRM")
    public void i_am_logged_into_orange_hrm() {
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage.enterUsernameandPassword("admin", "admin123");
        loginPage.clickLoginButton();
    }
    @And("I navigate to the Employee page")
    public void i_navigate_to_the_employee_page() {

        employeePage.clickPIMTab();
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String string) {
        employeePage.clickAddEmployeeTab();
    }

    @When("I fill in the employee details with {string},{string}, {string} and {string}")
    public void i_fill_in_the_employee_details_with_and(String fname, String mname, String lname,String id) throws InterruptedException {
        employeePage.enterFirstName(fname);
        employeePage.enterMiddleName(mname);
        employeePage.enterLastName(lname);
        employeePage.enterEmployeeId(id);
        Thread.sleep(1000);
        employeePage.clickSaveButton();
    }
    @Then("I should see a confirmation message indicating that the employee has been added successfully")
    public void i_should_see_a_confirmation_message_indicating_that_the_employee_has_been_added_successfully() {
        Assert.assertTrue(employeePage.employeeImageIsDisplayed());

    }

    @When("I search for the employee with {string}")
    public void i_search_for_the_employee_with(String empId1) {
        employeePage.searchEmpIdToBeDeleted(empId1);
    }

    @When("I click on the delete button for that employee")
    public void i_click_on_the_delete_button_for_that_employee() {employeePage.clickDeleteButton();
    }

    @Then("I should see a confirmation message indicating that the employee has been deleted successfully")
    public void i_should_see_a_confirmation_message_indicating_that_the_employee_has_been_deleted_successfully() {
                Assert.assertTrue(employeePage.validateEmployeeDeletedSuccesfully());
    }




}
