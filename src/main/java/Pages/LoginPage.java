package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils wait;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        wait = new WaitUtils(driver);
    }

    @FindBy(name="username") private WebElement usernameField;
    @FindBy(name="password") private WebElement passwordField;
    @FindBy(xpath="//button[text()=' Login ']" )
    private WebElement loginButton;
    @FindBy(xpath="//p[text()='Invalid credentials']" )
    private WebElement invalidCredentialsMessage;
    //div[@class='oxd-brand-banner']//child::img
    @FindBy(xpath="//div[@class='oxd-brand-banner']//child::img")
    private WebElement orangeHRMLogo;


    public void enterUsernameandPassword(String username, String password) {
        wait.waitForVisibility(usernameField);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public Boolean verifyErrorMessage(String errorMessage) {
        wait.waitForVisibility(invalidCredentialsMessage);
        return invalidCredentialsMessage.getText().equals(errorMessage);
    }

    public Boolean verifyOrangeHRMLogo() {
        wait.waitForVisibility(orangeHRMLogo);
        return orangeHRMLogo.isDisplayed();
    }
}
