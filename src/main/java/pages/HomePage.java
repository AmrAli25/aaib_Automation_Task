package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {

    // Variables
    private final String url = System.getProperty("baseURL");
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    private final By headerLogo = By.cssSelector("div[class=\"header-logo\"]");
    private final By registerBtn = By.cssSelector("a[class=\"ico-register\"]");
    private final By myAccountBt = By.cssSelector("a[class=\"ico-account\"]");

    // Constructor
    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    @Step("Navigate to HomePage")
    public HomePage navigate() {
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Click on the login or register button from the header")
    public HomePage clickRegisterBtn() {
        driver.element().click(registerBtn);
        return this;
    }

    // Validations
    @Step("Verify Correct navigation to HomePage")
    public HomePage verifyNavigationToHomePage() {
        driver.verifyThat().element(headerLogo).exists().perform();
        return this;
    }

    @Step("Verify visibility of Register button")
    public HomePage verifyVisibilityOfRegisterButton(){
        driver.verifyThat().element(registerBtn).isVisible().perform();
        return this;
    }

    @Step("Verify Visibility of My account button on Homepage Header")
    public HomePage verifySuccessfulRegistration() {
        driver.verifyThat().element(myAccountBt).exists().perform();
        return this;
    }
}
