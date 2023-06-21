package com.flairstech.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Cart (2)']")
    public WebElement numberofitems;

    @FindBy(xpath = "//*[text()='EGP 480.00']")
    public WebElement subtotalnumber;

    @FindBy(xpath = "//*[@aria-label='increase cart quantity']")
    public WebElement IncreaseBtn;
}
