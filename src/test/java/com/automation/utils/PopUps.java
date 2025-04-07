package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class PopUps extends BasePage {

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
}