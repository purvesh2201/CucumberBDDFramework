package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // ThreadLocal stores separate WebDriver instance for each thread
    // This ensures thread-safety in parallel execution
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initialize WebDriver for the current thread
     */
    public static void initializeDriver() {
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
        }
    }

    /**
     * Get WebDriver instance for the current thread
     * If not initialized, creates a new instance
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    /**
     * Quit WebDriver and clean up ThreadLocal
     * Must be called after each scenario to prevent thread leaks
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
