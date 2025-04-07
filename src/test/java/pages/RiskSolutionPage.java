package pages;

import com.automation.utils.PopUps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static com.automation.utils.DriverManager.getDriver;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.findAll;

public class RiskSolutionPage extends PopUps {

    private final WebDriverWait wait;

    public RiskSolutionPage() {
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    private final By aboutUsLink = By.xpath("//*[@id='mm-32882528-f67d-4cb9-8509-f6d48ac579c5']/div/div/ul/li[4]/a[1]");
    private final By careersLink = By.xpath("//*[@id='mm-32882528-f67d-4cb9-8509-f6d48ac579c5']/div/div/ul/li[4]/ul/li/div/div/div/div[3]/div[4]/div[2]/div[2]/a[2]");
    private final By searchJobsButton = By.xpath("//*[@id='large-left-padding']/div[2]/div[2]/div[1]/a");
    private final By searchJobsTetArea = By.xpath("//*[@id='search-box-d3ba3a32752d48908f4061d0129326bf']");
    private final By searchJobResultButton = By.xpath("//*[@id='search-box-button']/span");

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

    public void clickSearchJobsButton() {
        WebElement searchAllJobsButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchJobsButton));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchAllJobsButtonElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(searchAllJobsButtonElement).perform();
        searchAllJobsButtonElement.sendKeys(Keys.ENTER);
    }

    public void searchForJobs(String inputText) {
        WebElement searchJobsInputTextArea = wait.until(ExpectedConditions.elementToBeClickable(searchJobsTetArea));
        searchJobsInputTextArea.sendKeys(inputText);
        WebElement searchJobResultButtonElement = wait.until(ExpectedConditions.elementToBeClickable(searchJobResultButton));
        searchJobResultButtonElement.click();
    }

    public boolean isResultAvailable() {
        return !findAll(By.cssSelector(".search-results__item")).isEmpty();
    }
}