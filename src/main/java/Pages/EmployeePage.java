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

    @FindBy(xpath = "//img[@class='employee-image']" )
    private WebElement employeeImage;

    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement employeeListTab;

    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill']")
    private WebElement employeeIcon;

    @FindBy(xpath = "//label[text()='Employee Id']//parent::div//following-sibling::div//child::input")
    private WebElement employeeId1;

    //button[text()=' Search ']
    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    private WebElement trashButton;

    @FindBy(xpath = "//*[text()=' Yes, Delete ']")
    private WebElement deleteButton;

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

    public Boolean employeeImageIsDisplayed() {
        wait.waitForVisibility(employeeImage);
        return employeeImage.isDisplayed();
    }

    public void searchEmpIdToBeDeleted(String empid){
        wait.waitForVisibility(employeeListTab);
        employeeListTab.click();
        wait.waitForVisibility(employeeIcon);
        employeeIcon.click();
        wait.waitForVisibility(employeeId1);
        employeeId1.sendKeys(empid);
        searchButton.click();
    }

    public void clickDeleteButton() {
        wait.waitForVisibility(trashButton);
        trashButton.click();
        wait.waitForVisibility(deleteButton);
        deleteButton.click();
    }



}
