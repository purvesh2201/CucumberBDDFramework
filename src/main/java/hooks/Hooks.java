package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        DriverFactory.initializeDriver();  // store driver in DriverFactory
    }


    @After
    public void tearDown() {
        if (DriverFactory.getDriver() != null) {
            try {
                DriverFactory.getDriver().quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


