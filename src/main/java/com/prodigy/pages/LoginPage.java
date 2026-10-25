package com.prodigy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model (POM) representing SauceDemo Login & Post-Login Actions.
 */
public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");
    
    // Inventory Locators
    private final By pageTitle = By.className("title");
    private final By inventoryContainer = By.className("inventory_list");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        element.clear();
        if (username != null && !username.isEmpty()) {
            element.sendKeys(username);
        }
    }

    public void enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        element.clear();
        if (password != null && !password.isEmpty()) {
            element.sendKeys(password);
        }
    }

    public void clickLogin() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        button.click();
    }

    /**
     * Helper to perform complete login action.
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    /**
     * Helper to perform logout action.
     */
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        WebElement logoutBtn = wait.until(ExpectedConditions.presenceOfElementLocated(logoutLink));
        // SauceDemo sidebar animation wait
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    public String getErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.getText();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isInventoryDisplayed() {
        try {
            wait.until(ExpectedConditions.urlContains("/inventory.html"));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }
}
