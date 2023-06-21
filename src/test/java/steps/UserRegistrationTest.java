package steps;

import com.flairstech.page.HomePage;
import com.flairstech.page.SignInPage;
import com.flairstech.util.Util;
import com.google.gson.JsonObject;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class UserRegistrationTest extends BaseTest {

    private HomePage homePage;
    private SignInPage signInPage;
    private JsonObject userInfo;

    @Before
    public void init() throws FileNotFoundException {
        userInfo = Util.getJsonObject("src/test/java/resources/info.json");
        driver.get(userInfo.get("url").getAsString());
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
    }

    @Given("the user is on the Jumia homepage")
    public void givenTheUserIsOnJumiaHomepage() {
        homePage.accountDropDown.click();
    }

    @When("the user clicks on the Account button")
    public void whenTheUserClicksOnAccountButton() {
        homePage.signInBtn.click();
    }

    @When("fills in all the required personal data")
    public void fillsInAllRequiredPersonalData() {
        String randomString = signInPage.generateRandomString();
        String newEmail = randomString + "@gmail.com";
        signInPage.emailTextBox.click();
        signInPage.emailTextBox.sendKeys(newEmail);
        signInPage.continueBtn.click();
        signInPage.passwordTextBox.sendKeys(userInfo.get("password").getAsString());
        signInPage.confirmPasswordButton.sendKeys(userInfo.get("password").getAsString());

        wait.until(ExpectedConditions.visibilityOf(signInPage.goodText));

        Util.clickOnElementUsingJavaScript(driver, signInPage.continueBtn2);
        signInPage.firstNameTextBox.sendKeys(userInfo.get("firstname").getAsString());
        signInPage.lastNameTextBox.sendKeys(userInfo.get("lastname").getAsString());
        signInPage.phoneNumberTextBox.sendKeys(userInfo.get("phone-number").getAsString());

        Util.clickOnElementUsingJavaScript(driver, signInPage.continueBtn3);

        signInPage.genderDropdown.click();
        signInPage.genderDropdownOptions.get(0).click();
        signInPage.birthDate.click();
        signInPage.birthDate.sendKeys(userInfo.get("birthdate").getAsString());
        signInPage.termsAndConditionsCheckBox.click();
        signInPage.continueBtn.click();
    }

    @Then("the user should receive a successfully registered message")
    public void userReceivesSuccessfullyRegisteredMessage() {
        assertTrue(signInPage.creationSuccessMsg.isDisplayed());
    }
}
