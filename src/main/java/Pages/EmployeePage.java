package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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

    @FindBy(xpath = "//button[text()=' Save ']//..//preceding-sibling::button[@type='submit']")
    private WebElement saveButton;


    @FindBy(xpath = "//p[text()='Successfully Saved']")
    private WebElement ToastButton ;

    @FindBy(xpath = "//img[@class='employee-image']" )
    private WebElement employeeImage;

    @FindBy(xpath = "//h6[text()='Test1 Test3']")
    private WebElement empNameVerify;

    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement employeeListTab;

    @FindBy(xpath = "//button[.//i[contains(@class,'bi-caret-up-fill')]]")
    private WebElement caretUpButton;

    @FindBy(xpath = "//button[.//i[contains(@class,'bi-caret-down-fill')]]")
    private WebElement caretDownButton;

    @FindBy(xpath = "//label[text()='Employee Id']//parent::div//following-sibling::div//child::input")
    private WebElement employeeId1;

    //button[text()=' Search ']
    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    private WebElement trashButton;

    @FindBy(xpath = "//*[text()=' Yes, Delete ']")
    private WebElement deleteButton;

    @FindBy(xpath = "//p[text()='Successfully Deleted']")
    private WebElement ToastDeleteButton ;

    public void clickPIMTab() {
        wait.waitForVisibility(pimTab);
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

    public void clickSaveButton() throws InterruptedException {
        wait.waitForVisibility(saveButton);
        saveButton.click();
        wait.waitForVisibility(ToastButton);
        wait.waitForVisibility(empNameVerify);
    }

    public Boolean employeeImageIsDisplayed() {
        String mainWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                driver.close(); // close the unwanted site
            }
        }
        driver.switchTo().window(mainWindow);
        wait.waitForVisibility(employeeImage);
        return employeeImage.isDisplayed();
    }

    public void searchEmpIdToBeDeleted(String empid){
        wait.waitForVisibility(pimTab);
        pimTab.click();

        try {
            wait.waitForVisibility(caretUpButton);
            employeeId1.sendKeys(empid);
            searchButton.click();
        } catch (Exception e) {
            wait.waitForVisibility(caretDownButton);
            caretDownButton.click();
            wait.waitForVisibility(employeeId1);
            employeeId1.sendKeys(empid);
            employeeId1.sendKeys(Keys.CONTROL + "a");
            searchButton.click();
        }

    }

    public void clickDeleteButton() {
        wait.waitForVisibility(trashButton);
        trashButton.click();
        wait.waitForVisibility(deleteButton);
        deleteButton.click();
    }

    public boolean validateEmployeeDeletedSuccesfully() {
            wait.waitForVisibility(ToastDeleteButton);
            return ToastDeleteButton.isDisplayed();
        }


}
