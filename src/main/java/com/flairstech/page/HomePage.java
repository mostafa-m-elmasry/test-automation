package com.flairstech.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@aria-label='newsletter_popup_close-cta']")
    public WebElement CloseBtn;

    @FindBy(xpath = "//*[text()='Account']")
    public WebElement accountDropDown;

    @FindBy(xpath = "//*[text()='Hi, Mostafa']")
    public WebElement loggedInDropDown;

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signInBtn;

    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[text()='Supermarket']")
    public WebElement SupermarketSelector;

    @FindBy(xpath = "//*[text()='Bakery']")
    public WebElement BakerySelection;

    @FindBy(xpath = "//*[@class='-df -i-ctr -gy9 -hov-or5 -phs -fs16']")
    public WebElement CartBtn;

    public boolean isVisibleWebElement(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public void waitTillTheHomePageLoads(WebElement element) {
        while (true) {
            if (isVisibleWebElement(element)) return;
        }
    }

    public void enterSigninpage() {
        CloseBtn.click();
        accountDropDown.click();
        signInBtn.click();
    }

    /**
     * A method that contains the logout logic
     */
    public void logout() {
        loggedInDropDown.click();
        logoutButton.click();
    }
}
