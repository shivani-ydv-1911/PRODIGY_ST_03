package com.prodigy.tests;

import com.prodigy.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Task-03: Automated Login Test Suite for SauceDemo (Java + Selenium + TestNG)
 */
public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private final String BASE_URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Headless for CI/Fast execution
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BASE_URL);

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ==========================================
    // POSITIVE TEST CASES (Valid Credentials)
    // ==========================================

    @Test(priority = 1, description = "TC-01: Verify successful login with standard_user")
    public void testValidLoginStandardUser() {
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "URL should contain /inventory.html");
        Assert.assertEquals(loginPage.getPageTitle(), "Products", "Page title should be 'Products'");
        Assert.assertTrue(loginPage.isInventoryDisplayed(), "Inventory list should be visible");
    }

    @Test(priority = 2, description = "TC-02: Verify successful login with performance_glitch_user")
    public void testValidLoginPerformanceGlitchUser() {
        loginPage.login("performance_glitch_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "URL should contain /inventory.html");
        Assert.assertEquals(loginPage.getPageTitle(), "Products", "Page title should be 'Products'");
        Assert.assertTrue(loginPage.isInventoryDisplayed(), "Inventory list should be visible");
    }

    @Test(priority = 3, description = "TC-03: Verify successful logout after login")
    public void testSuccessfulLogout() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "User should be logged in");

        loginPage.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"), "Should redirect to landing/login page");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button should be visible after logout");
    }

    // ==========================================
    // NEGATIVE TEST CASES (Invalid Credentials & Empty Fields)
    // ==========================================

    @Test(priority = 4, description = "TC-04: Login attempt with invalid username and valid password")
    public void testInvalidUsername() {
        loginPage.login("invalid_user_123", "secret_sauce");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match any user in this service"),
                "Error message text did not match expected");
    }

    @Test(priority = 5, description = "TC-05: Login attempt with valid username and wrong password")
    public void testInvalidPassword() {
        loginPage.login("standard_user", "wrong_pass_999");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match any user in this service"),
                "Error message text did not match expected");
    }

    @Test(priority = 6, description = "TC-06: Login attempt with invalid username and invalid password")
    public void testBothCredentialsInvalid() {
        loginPage.login("fake_user", "fake_pass");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match any user in this service"),
                "Error message text did not match expected");
    }

    @Test(priority = 7, description = "TC-07: Login attempt with empty username")
    public void testEmptyUsername() {
        loginPage.login("", "secret_sauce");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"),
                "Error message should mention 'Username is required'");
    }

    @Test(priority = 8, description = "TC-08: Login attempt with empty password")
    public void testEmptyPassword() {
        loginPage.login("standard_user", "");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"),
                "Error message should mention 'Password is required'");
    }

    @Test(priority = 9, description = "TC-09: Login attempt with both fields empty")
    public void testBothFieldsEmpty() {
        loginPage.login("", "");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"),
                "Error message should mention 'Username is required'");
    }

    @Test(priority = 10, description = "TC-10: Login attempt with locked out account")
    public void testLockedOutUser() {
        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Sorry, this user has been locked out."),
                "Error message should indicate user is locked out");
    }
}
