package tests;

import com.flairstech.page.BakeryPage;
import com.flairstech.page.CartPage;
import com.flairstech.page.HomePage;
import com.flairstech.page.SignInPage;
import com.flairstech.util.Util;
import com.google.gson.JsonObject;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertTrue;

public class JumiaTest extends BaseTest {
    private HomePage homePage;
    private JsonObject userInfo;
    private BakeryPage bakerypage;
    private CartPage cartpage;
    private SignInPage signinpage;

    @BeforeClass
    public void init() throws FileNotFoundException {
        homePage = new HomePage(driver);
        bakerypage = new BakeryPage(driver);
        cartpage = new CartPage(driver);
        signinpage = new SignInPage(driver);
        userInfo = Util.getJsonObject("src/test/resources/info.json");
    }

    @BeforeMethod
    public void navigateToJumia() {
        driver.get(userInfo.get("url").getAsString());
    }

    /**
     * A test case to validate the sign-up flow
     */
    @Test(priority = 2)
    public void registerNewUser() {

        homePage.accountDropDown.click();

        homePage.signInBtn.click();


        signinpage.fillsignupdata();
        signinpage.passwordTextBox.sendKeys(userInfo.get("password").getAsString());

        signinpage.confirmPasswordButton.sendKeys(userInfo.get("password").getAsString());

        wait.until(ExpectedConditions.visibilityOf(signinpage.goodText));

        Util.clickOnElementUsingJavaScript(driver, signinpage.continueBtn2);
        signinpage.firstNameTextBox.sendKeys(userInfo.get("firstname").getAsString());
        signinpage.lastNameTextBox.sendKeys(userInfo.get("lastname").getAsString());
        signinpage.phoneNumberTextBox.sendKeys(userInfo.get("phone-number").getAsString());

        Util.clickOnElementUsingJavaScript(driver, signinpage.continueBtn3);


        signinpage.selectgender();
        signinpage.birthDate.sendKeys(userInfo.get("birthdate").getAsString());
        signinpage.termsAndConditionsCheckBox.click();
        signinpage.continueBtn.click();
        assertTrue(signinpage.creationSuccessMsg.isDisplayed());
    }

    @Test(priority = 1)
    public void createBakeryOrder() throws InterruptedException {
        homePage.enterSigninpage();

        signinpage.fillsignupdata();
        signinpage.passwordTextBox.sendKeys(userInfo.get("password").getAsString());

        signinpage.confirmPasswordButton.sendKeys(userInfo.get("password").getAsString());

        wait.until(ExpectedConditions.visibilityOf(signinpage.goodText));

        Util.clickOnElementUsingJavaScript(driver, signinpage.continueBtn2);
        signinpage.firstNameTextBox.sendKeys(userInfo.get("firstname").getAsString());
        signinpage.lastNameTextBox.sendKeys(userInfo.get("lastname").getAsString());
        signinpage.phoneNumberTextBox.sendKeys(userInfo.get("phone-number").getAsString());

        Util.clickOnElementUsingJavaScript(driver, signinpage.continueBtn3);

        signinpage.selectgender();
        signinpage.birthDate.sendKeys(userInfo.get("birthdate").getAsString());
        signinpage.termsAndConditionsCheckBox.click();
        signinpage.continueBtn.click();

        homePage.waitTillTheHomePageLoads(homePage.SupermarketSelector);

        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.SupermarketSelector).build().perform();
        homePage.BakerySelection.click();

        actions.moveToElement(bakerypage.itemselection).build().perform();

        Util.clickOnElementUsingJavaScript(driver, bakerypage.AddToCartBtn);

        Util.clickOnElementUsingJavaScript(driver, bakerypage.IncreaseBtn);

        Thread.sleep(2000);

        Util.clickOnElementUsingJavaScript(driver, homePage.CartBtn);

        Assert.assertTrue(cartpage.numberofitems.getText().contains("Cart (2)"));

        Assert.assertTrue(cartpage.subtotalnumber.getText().contains("EGP 480.00"));
    }

    @AfterMethod
    public void closeWebDriverSession() {
        homePage.logout();
    }
}