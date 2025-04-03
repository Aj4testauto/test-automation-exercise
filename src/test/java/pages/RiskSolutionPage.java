package pages;

import com.automation.utils.PopUps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static com.automation.utils.DriverManager.getDriver;
import static pages.BasePage.driver;

public class RiskSolutionPage extends PopUps {

    private final WebDriverWait wait;

    public RiskSolutionPage(){
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    private final By aboutUsLink = By.xpath("//*[@id='mm-32882528-f67d-4cb9-8509-f6d48ac579c5']/div/div/ul/li[4]/a[1]");
    private final By careersLink=By.xpath("//*[@id='mm-32882528-f67d-4cb9-8509-f6d48ac579c5']/div/div/ul/li[4]/ul/li/div/div/div/div[3]/div[4]/div[2]/div[2]/a[2]");

    private final By searchJobsButton=By.xpath("//*[@id='large-left-padding']/div[2]/div[2]/div[1]/a") ;

    // Method to click on "About Us" and then "Careers"
    public void navigateToCareers() {
        WebElement aboutUs = wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink));
        aboutUs.click();
        WebElement careers = wait.until(ExpectedConditions.elementToBeClickable(careersLink));
        careers.click();
        switchToNextTab();
    }

    public void switchToNextTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        int currentTabIndex = tabs.indexOf(driver.getWindowHandle());

        if (currentTabIndex < tabs.size() - 1) {
            driver.switchTo().window(tabs.get(currentTabIndex + 1)); // Switch to next tab
        } else {
            System.out.println("Already on the last tab, cannot switch further.");
        }
    }

    public void clickSearchAllJobs() {
        openCookieSettings();
        manageCookiePreferences();
        WebElement searchAllJobsButtonElement = wait.until(ExpectedConditions.elementToBeClickable(searchJobsButton));
        searchAllJobsButtonElement.click();
    }
}
