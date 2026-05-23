package hooks;

import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    /**
     * Initialize WebDriver before each scenario
     * This ensures each thread gets its own driver instance
     */
    @Before
    public void setupDriver() {
        DriverFactory.initializeDriver();
    }

    /**
     * Quit WebDriver after each scenario
     * This cleans up thread-local storage
     */
    @After
    public void teardownDriver() {
        DriverFactory.quitDriver();
    }
}


