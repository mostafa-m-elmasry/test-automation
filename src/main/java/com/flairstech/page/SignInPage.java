package com.flairstech.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input_identifierValue")
    public WebElement emailTextBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement continueBtn;

    @FindBy(xpath = "(//*[@class='mdc-button__ripple'])[1]")
    public WebElement continueBtn2;

    @FindBy(xpath = "(//*[@class='mdc-button__ripple'])[2]")
    public WebElement continueBtn3;

    @FindBy(xpath = "//*[text()='Get Started']")
    public WebElement GetStarted;

    @FindBy(name = "password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//*[@autocomplete='confirm-password']")
    public WebElement confirmPasswordButton;

    @FindBy(id = "input_first_name")
    public WebElement firstNameTextBox;

    @FindBy(id = "input_last_name")
    public WebElement lastNameTextBox;

    @FindBy(name = "phone[number]")
    public WebElement phoneNumberTextBox;

    @FindBy(id = "gender")
    public WebElement genderDropdown;

    @FindBy(xpath = "//*[@aria-label='Gender']/li ")
    public List<WebElement> genderDropdownOptions;

    @FindBy(id = "input_birth_date")
    public WebElement birthDate;

    @FindBy(xpath = "//*[text()='Good']")
    public WebElement goodText;

    @FindBy(id = "acceptTC")
    public WebElement termsAndConditionsCheckBox;

    @FindBy(xpath = "//*[contains(text(),'Your account has been created')]")
    public WebElement creationSuccessMsg;

    public String generateRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();

        while (salt.length() < 10) { // length of the random string.
            int index = (int) (random.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        return salt.toString();
    }

    public void fillsignupdata() {
        String randomString = generateRandomString();
        String newEmail = randomString + "@gmail.com";
        emailTextBox.click();
        emailTextBox.sendKeys(newEmail);
        continueBtn.click();
    }

    public void selectgender() {
        genderDropdown.click();
        genderDropdownOptions.get(0).click();
        birthDate.click();
    }
}
