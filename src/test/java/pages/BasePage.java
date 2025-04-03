package pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        waitFor();
        return driver.getTitle();
    }

    public void waitFor() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
            System.out.println("Page loaded.");
        } catch (TimeoutException e) {
            System.err.println("Page load timed out.");
        }
    }

    public void navigateTo(String urlType) {
        String url;
        if ("web-form".equalsIgnoreCase(urlType)) {
            url = ConfigReader.getProperty("exercise1");
        } else if ("risk-lexisnexis".equalsIgnoreCase(urlType)) {
            url = ConfigReader.getProperty("exercise2");
        } else {
            throw new IllegalArgumentException("Invalid URL type: " + urlType);
        }
        driver.get(url);
    }
}