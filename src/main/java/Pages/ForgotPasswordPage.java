package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='go3958317564']")
    public WebElement successMessage;

    @FindBy(xpath = "//div[@class='go3958317564']")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement backToLoginLink;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public LoginPage clickBackToLogin() {
        backToLoginLink.click();
        return new LoginPage(driver); // Return the LoginPage object
    }
}
