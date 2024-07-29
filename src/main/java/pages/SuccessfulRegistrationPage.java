package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SuccessfulRegistrationPage {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    // Locators
    private By registerCompleteText = By.cssSelector("div[class=\"result\"]");
    private By continueBtn = By.cssSelector("a[class=\"button-1 register-continue-button\"]");

    // Constructor
    public SuccessfulRegistrationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    @Step("Click on continue button to go to Homepage")
    public SuccessfulRegistrationPage clickContinueToAccountPageBtn() {
        driver.element()
                .click(continueBtn);
        return this;
    }

    // Validations
    @Step("Verify That account is created successfully")
    public SuccessfulRegistrationPage verifyAccountCreatedSuccessfully(String message) {
        driver.verifyThat().element(registerCompleteText).text()
                .isEqualTo(message);
        return this;
    }


}
