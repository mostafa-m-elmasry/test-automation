package com.flairstech.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BakeryPage extends BasePage {

    public BakeryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@href='/molto-magnum-chocolate-stuffed-croissant-24-pcs-32315374.html']")
    public WebElement itemselection;

    @FindBy(xpath = "(//*[text()='Add To Cart'])[1]")
    public WebElement AddToCartBtn;

    @FindBy(xpath = "//*[@aria-label='increase cart quantity']")
    public WebElement IncreaseBtn;
}
