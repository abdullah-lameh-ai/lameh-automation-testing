package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    // Constructor to initialize elements
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Top-left Home button
    @FindBy(xpath = "PLACEHOLDER")
            WebElement homeButton;

    // Top-right menu icon
    @FindBy(xpath = "PLACEHOLDER")
            WebElement menuIcon;

    // Menu option - Sign Out
    @FindBy(xpath = "PLACEHOLDER")
            WebElement signOutOption;

    // Menu option - Change Password
    @FindBy(xpath = "PLACEHOLDER")
            WebElement changePasswordOption;

    // Add Company button
    @FindBy(xpath = "PLACEHOLDER")
            WebElement addCompanyButton;

    // Lameh AI button
    @FindBy(xpath = "PLACEHOLDER")
            WebElement lamehAIButton;

    // Search bar
    @FindBy(xpath = "PLACEHOLDER")
            WebElement searchBar;

    // Filters dropdown
    @FindBy(xpath = "PLACEHOLDER")
            WebElement filtersDropdown;

    // Sorting dropdown
    @FindBy(xpath = "PLACEHOLDER")
            WebElement sortingDropdown;

    // View Analysis/Update Analysis/Start Analysis button
    @FindBy(xpath = "PLACEHOLDER")
            WebElement viewAnalysisButton;

    // Add Documents button
    @FindBy(xpath = "PLACEHOLDER")
            WebElement addDocumentsButton;

    // Dialog for uploading a document
    @FindBy(xpath = "PLACEHOLDER")
            WebElement uploadDocumentDialog;

    // Actions
    public void clickHomeButton() {
        homeButton.click();
    }

    public void openMenu() {
        menuIcon.click();
    }

    public void clickSignOut() {
        signOutOption.click();
    }

    public void clickChangePassword() {
        changePasswordOption.click();
    }

    public void clickAddCompany() {
        addCompanyButton.click();
    }

    public void clickLamehAI() {
        lamehAIButton.click();
    }

    public void search(String query) {
        searchBar.sendKeys(query);
    }

    public void openFiltersDropdown() {
        filtersDropdown.click();
    }

    public void openSortingDropdown() {
        sortingDropdown.click();
    }

    public void clickViewAnalysis() {
        viewAnalysisButton.click();
    }

    public void clickAddDocuments() {
        addDocumentsButton.click();
    }

    public void uploadDocument(String filePath) {
        uploadDocumentDialog.sendKeys(filePath); // Adjust if the dialog requires a different interaction
    }
}
