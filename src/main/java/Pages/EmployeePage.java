package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitUtils;

public class EmployeePage {

    private WebDriver driver;
    private WaitUtils wait;

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[text()='PIM']")
    private WebElement pimTab;

    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement addEmployeeTab;

    @FindBy(name="firstName")
    private WebElement firstName;

    @FindBy(name="middleName")
    private WebElement middleName;

    @FindBy(name="lastName")
    private WebElement lastName;

    @FindBy(xpath = "//label[text()='Employee Id']//parent::div//following-sibling::div//child::input")
    private WebElement employeeId;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveButton;

    @FindBy(xpath = "//img[@class='employee-image']/../..//preceding-sibling::div//child::h6" )
    private WebElement employeeImage;

    public void clickPIMTab() {
        wait.waitForClickable(pimTab);
        pimTab.click();
    }

    public void clickAddEmployeeTab() {
        wait.waitForClickable(addEmployeeTab);
        addEmployeeTab.click();
    }

    public void enterFirstName(String name) {
        wait.waitForVisibility(firstName);
        firstName.sendKeys(name);
    }

    public void enterMiddleName(String middlename) {
        middleName.sendKeys(middlename);
    }

    public void enterLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void enterEmployeeId(String id) {
        employeeId.sendKeys(Keys.CONTROL + "a");
        employeeId.sendKeys(Keys.DELETE);
        employeeId.sendKeys(id);
    }

    public void clickSaveButton() {
        saveButton.click();
        wait.waitForVisibility(employeeImage);
    }

}
