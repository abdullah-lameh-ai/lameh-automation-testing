package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    // Locators for the Login Page elements
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href='/forgot-password']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[@class='go3958317564']")
    private WebElement couldntFindCredentialsErrorMessage;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with the elements

    /**
     * Enter email into the email input field.
     * @param email - The email to be entered.
     */
    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    /**
     * Enter password into the password input field.
     * @param password - The password to be entered.
     */
    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    /**
     * Click the "Sign In" button.
     */
    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement signInButtonVisible = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButtonVisible.click();
    }


    /**
     * Click the "Forgot Password" link.
     */
    public ForgotPasswordPage clickForgotPassword() {
        forgotPasswordLink.click();
        return new ForgotPasswordPage(driver); // Return the ForgotPasswordPage object
    }

    /**
     * Get the error message text for invalid credentials.
     * @return - The error message text.
     */
    public String getCouldntFindCredentialsErrorMessage() {
        return couldntFindCredentialsErrorMessage.getText();
    }
}
