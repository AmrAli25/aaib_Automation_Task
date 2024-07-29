package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RegisterPage {

    // Variables
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By pageTitle = By.cssSelector("div[class=\"page-title\"]");
    private By gender = By.id("gender-male");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By daysDropdown = By.cssSelector("select[name=\"DateOfBirthDay\"]");
    private By monthDropdown = By.cssSelector("select[name=\"DateOfBirthMonth\"]");
    private By yearDropdown = By.cssSelector("select[name=\"DateOfBirthYear\"]");
    private By emailAddress = By.id("Email");
    private By company = By.id("Company");
    private By userPassword = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");


    private By registerBtn = By.id("register-button");


    // Constructor
    public RegisterPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    @Step("Enter User required personal information")
    public RegisterPage enterUserPersonalInfo(String fName, String lName, String days, String month, String year, String email) {
        driver.element()
                .click(gender)
                .type(firstName, fName)
                .type(lastName, lName)
                .select(daysDropdown, days)
                .select(monthDropdown, month)
                .select(yearDropdown, year)
                .type(emailAddress, email);
        return this;
    }

    @Step("Enter User Company Details")
    public RegisterPage enterUserCompanyDetails(String companyName) {
        driver.element()
                .type(company, companyName);
        return this;
    }


    @Step("Enter User Password")
    public RegisterPage enterUserPassword(String password) {
        driver.element()
                .type(userPassword, password)
                .type(confirmPassword, password);
        return this;
    }

    @Step("Click on Register button to register new account")
    public RegisterPage clickContinueBtn() {
        driver.element()
                .click(registerBtn);
        return this;
    }


    // Validations
    @Step("Verify correct navigation to RegisterPage")
    public RegisterPage verifyCreateAccountTextVisibility(String message) {
        driver.verifyThat().element(pageTitle).text()
                .isEqualTo(message);
        return this;
    }


}
