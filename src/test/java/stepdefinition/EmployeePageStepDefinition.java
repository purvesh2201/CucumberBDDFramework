package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeePageStepDefinition {

    @Given("I am on the Employee page")
    public void i_am_on_the_employee_page() {

    }
    @When("I click on the {string} button")
    public void i_click_on_the_button(String string) {

    }
    @When("I fill in the employee details with {string}, {string}, and {string}")
    public void i_fill_in_the_employee_details_with_and(String string, String string2, String string3) {

    }
    @Then("I should see a confirmation message indicating that the employee has been added successfully")
    public void i_should_see_a_confirmation_message_indicating_that_the_employee_has_been_added_successfully() {

    }


}
