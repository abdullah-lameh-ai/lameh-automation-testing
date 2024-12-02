package tests;

import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class ForgotPasswordTest  {
    private WebDriver driver;
    private LoginPage loginPage;



    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\IdeaProjects\\LamehAI\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://frontend-uat-36462279645.me-central2.run.app/login");
        loginPage = new LoginPage(driver);
    }




    private ForgotPasswordPage forgotPasswordPage;



    @Test
    public void testValidEmailSubmission() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(loginPage.forgotPasswordLink));
        // Navigate to Forgot Password page
        forgotPasswordPage = loginPage.clickForgotPassword();

        // Perform actions on Forgot Password page
        forgotPasswordPage.enterEmail("m.ramez@lameh.ai");
        forgotPasswordPage.clickSubmit();


        wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage.successMessage));

        Assert.assertTrue(forgotPasswordPage.getSuccessMessageText().contains("Reset code sent to your email"));
    }

    @Test
    public void testInvalidEmailSubmission() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(loginPage.forgotPasswordLink));
        forgotPasswordPage = loginPage.clickForgotPassword();

        forgotPasswordPage.enterEmail("invalidemail@lameh.ai");
        forgotPasswordPage.clickSubmit();

        wait.until(ExpectedConditions.visibilityOf(forgotPasswordPage.errorMessage));

        Assert.assertTrue(forgotPasswordPage.getErrorMessageText().contains("Couldn't find your account."));
    }

    @Test
    public void testEmptyEmailFieldSubmission() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(loginPage.forgotPasswordLink));
        forgotPasswordPage = loginPage.clickForgotPassword();

        forgotPasswordPage.clickSubmit();

        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='email'][@required]")));
        Assert.assertTrue(emailField.getAttribute("validationMessage").contains("Please fill out this field"));
    }

    @Test
    public void testBackToLoginLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(loginPage.forgotPasswordLink));
        forgotPasswordPage = loginPage.clickForgotPassword();

        LoginPage loginPageAfterClick = forgotPasswordPage.clickBackToLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
