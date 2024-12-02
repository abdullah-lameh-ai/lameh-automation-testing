package Tests;

import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends base.BaseTest {
    private LoginPage loginPage;


    @Test
    public void testValidLogin() {
        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Create an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the email input field to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));

        // Enter valid credentials and attempt login
        loginPage.enterEmail("m.ramez@lameh.ai");
        loginPage.enterPassword("rt-0103676999");
        loginPage.clickSignIn();

        // Wait for the URL to change after login
        wait.until(ExpectedConditions.urlToBe("https://frontend-uat-36462279645.me-central2.run.app/"));

        // Validate successful login
        Assert.assertTrue(driver.getCurrentUrl().equals("https://frontend-uat-36462279645.me-central2.run.app/"), "User should be redirected to the dashboard.");
    }

    @Test
    public void testInvalidLogin() {
        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Create an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        // Wait for the email input field to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));

        // Enter invalid credentials and attempt login
        loginPage.enterEmail("invaliduser@lameh.ai");
        loginPage.enterPassword("invalid");
        loginPage.clickSignIn();

        // Wait for the error message to appear
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='go3958317564']")));

        // Validate error message
        Assert.assertTrue(errorMessage.getText().contains("Couldn't find your account."), "Error message should be displayed for invalid login.");
    }

    @Test
    public void testInvalidPasswordForValidUsernameLogin() {
        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Create an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        // Wait for the email input field to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));

        // Enter invalid credentials and attempt login
        loginPage.enterEmail("m.ramez@lameh.ai");
        loginPage.enterPassword("invalid");
        loginPage.clickSignIn();

        // Wait for the error message to appear
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='go3958317564']")));

        // Validate error message
        Assert.assertTrue(errorMessage.getText().contains("Password is incorrect. Try again, or use another method."), "Error message should be displayed for invalid login.");
    }
    @Test
    public void testPasswordCaseSensitivity() {
        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Create an explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        // Wait for the email input field to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));

        // Enter invalid credentials and attempt login
        loginPage.enterEmail("m.ramez@lameh.ai");
        loginPage.enterPassword("Rt-0103676999");
        loginPage.clickSignIn();

        // Wait for the error message to appear
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='go3958317564']")));

        // Validate error message
        Assert.assertTrue(errorMessage.getText().contains("Password is incorrect. Try again, or use another method."), "Error message should be displayed for invalid login.");
    }

    @Test
    public void testEmptyFields() {
        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Attempt to login without entering any credentials
        loginPage.clickSignIn();

        // Wait for the email and password fields' validation
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        // Validate the browser's native validation messages
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));

        Assert.assertEquals(emailField.getAttribute("validationMessage"), "Please fill out this field.", "Email required message should be displayed.");
        Assert.assertEquals(passwordField.getAttribute("validationMessage"), "Please fill out this field.", "Password required message should be displayed.");
    }


    @Test
    public void testForgotPasswordLink() {
        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Create an explicit wait for the URL to change
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement forgetPasswordButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/forgot-password']")));

        // Click on the Forgot Password link
        loginPage.clickForgotPassword();

        wait.until(ExpectedConditions.urlContains("/forgot-password"));

        // Validate navigation to the Forgot Password page
        Assert.assertTrue(driver.getCurrentUrl().contains("/forgot-password"), "User should be redirected to the forgot password page.");
    }


}
