package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class PopUps extends BasePage {

    private final By targetingCookies = By.id("ot-header-id-4");
    private final By confirmMyChoice = By.xpath("//button[@class='save-preference-btn-handler onetrust-close-btn-handler']");
    private final By cookiesSettingsButton = By.xpath("//button[@class='cookie-setting-link']");

    public void handlePopups(String popupText) {
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(translate(text(), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), 'ACCEPT') or contains(translate(text(), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'), 'AGREE')]")));
            if (acceptCookiesButton.isDisplayed()) {
                System.out.println("Popup detected, accepting cookies...");
                acceptCookiesButton.click();
            }
        } catch (Exception e) {
            System.out.println("No popup appeared, continuing with the test...");
        }
    }

    public void openCookieSettings() {
        waitFor();
        try {
            WebElement cookieSettings = driver.findElement(cookiesSettingsButton);
            if (cookieSettings.isSelected()) {
            cookieSettings.click();
            System.out.println("Navigated to Cookie Settings.");
        }} catch (Exception e) {
            System.out.println("No cookie settings link found.");
        }
    }

    public void manageCookiePreferences() {
        try {
            WebElement targetCookies = driver.findElement(targetingCookies);
            if (targetCookies.isSelected()) {
                targetCookies.click();
                System.out.println("target cookies disabled.");
            }
            WebElement confirmChoice = driver.findElement(confirmMyChoice);
            confirmChoice.click();
            System.out.println("Cookie saved.");
        } catch (Exception e) {
            System.out.println("Could not manage cookie.");
        }
    }
}