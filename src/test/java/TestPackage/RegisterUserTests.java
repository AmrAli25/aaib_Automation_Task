package TestPackage;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.SuccessfulRegistrationPage;


@Epic("Test cases for AAIB Case interview")
@Feature("User Management")
@Story("Register New User")

public class RegisterUserTests {

    // Variables
    private final String timeStamp = String.valueOf(System.currentTimeMillis());
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON registrationTestData;
    private SHAFT.TestData.JSON validationTestData;

    @BeforeClass(description = "Setup Test Data.")
    public void beforeClass() {
        registrationTestData = new SHAFT.TestData.JSON("RegisterUserData.json");
        validationTestData = new SHAFT.TestData.JSON("ValidationData.json");
    }

    @BeforeClass(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver).navigate();
    }

    @Description("Given I am navigating to Register page,\nThen user starts to create account and add his required data," +
            "\nThen submit it successfully")
    @Test(description = "Register New User Test - GUI")
    public void successfullyRegisterNewAccount() {
        new HomePage(driver).verifyNavigationToHomePage()
                .verifyVisibilityOfRegisterButton()
                .clickRegisterBtn();
        new RegisterPage(driver)
                .verifyCreateAccountTextVisibility(validationTestData.getTestData("registerHeader"))
                .enterUserPersonalInfo(registrationTestData.getTestData("firstName"),
                        registrationTestData.getTestData("lastName"),
                        registrationTestData.getTestData("days"),
                        registrationTestData.getTestData("month"),
                        registrationTestData.getTestData("year"),
                        registrationTestData.getTestData("email") + timeStamp + "@test.com")
                .enterUserCompanyDetails(registrationTestData.getTestData("company"))
                .enterUserPassword(registrationTestData.getTestData("password"))
                .clickContinueBtn();
        new SuccessfulRegistrationPage(driver)
                .verifyAccountCreatedSuccessfully(validationTestData.getTestData("accountCreated"))
                .clickContinueToAccountPageBtn();
        new HomePage(driver)
                .verifySuccessfulRegistration();
    }


    @AfterClass(description = "TearDown Browser instance.")
    public void afterMethod() {
        driver.quit();
    }
}
