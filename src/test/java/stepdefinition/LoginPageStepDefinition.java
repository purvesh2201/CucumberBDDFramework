package stepdefinition;

import Pages.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageStepDefinition {

    private LoginPage loginPage;

    @Before
    public void setup() {
        DriverFactory.initializeDriver();
    }

    @After
    public void teardown() {
        DriverFactory.quitDriver();
    }

    /**
     * Get thread-safe WebDriver instance
     */
    private WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orange_hrm_login_page() {
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(getDriver());
    }

    @When("I enter valid {string} and {string}")
    public void i_enter_valid_and(String username, String password) {
        loginPage.enterUsernameandPassword(username, password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the Home page")
    public void i_should_be_redirected_to_the_home_page() {
        Boolean isLogoDisplayed = loginPage.verifyOrangeHRMLogo();
        Assert.assertTrue(isLogoDisplayed);
    }

    @When("I enter invalid {string} and {string}")
    public void i_enter_invalid_and(String username, String password) {
        loginPage.enterUsernameandPassword(username, password);
    }

    @Then("I should see an {string} indicating invalid credentials")
    public void i_should_see_an_indicating_invalid_credentials(String errorMessage) {
        Boolean isErrorMessageDisplayed = loginPage.verifyErrorMessage(errorMessage);
        Assert.assertTrue(isErrorMessageDisplayed);
    }



}
