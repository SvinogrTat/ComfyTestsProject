package com.selenium.hw.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CtrsHomePage {
    public WebDriver driver;

    public CtrsHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //cut it off if can
    //section
    @FindBy(xpath = "//button[@class = 'df jcc bd0 cup on aic uppercase medium p0 add-basket button-0-2-159 root-0-2-163 root-d0-0-2-176 medium-0-2-172 contained-0-2-171 auto-width']")
    private WebElement firstItemAddToCart;

    @FindBy(xpath = "(//span[@class ='medium price-0-2-157'])[1]")
    private WebElement firstItemPrice;

    @FindBy(xpath = "//a[contains(@href, 'checkout')]//button")
    private WebElement placeOrder;

    @FindBy(xpath = "//a[@class = 'link link-dashed']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//div[@class = 'df aic jcc pa badge-0-2-80']")
    private WebElement cartItemsCount;

    @FindBy(xpath = "//div[@class = 'orderButtonBlock-0-2-303 f1']//button")
    private WebElement placeOrderAfterClickingToCart;

    @FindBy(xpath = "//div[@class = 'dib df basket-0-2-12']//button[contains(@class, 'pr cup bd0 on aic jcc action-0-2-76')]")
    private WebElement cartButton;

    @FindBy(xpath = "(//a[contains(@href, 'checkout')]//button)[2]")
    private WebElement placeOrderFromSecondPopUp;

    @FindBy(xpath = "//div[contains(@class, 'pa cup df aic jcc close-0-2')]")
    private WebElement closePopUp;

    @FindBy(xpath = "//div[@class = 'pa r0']//div[@class = 'dib']")
    private WebElement deleteItemFromCartInPopUp;

    @FindBy(xpath = "(//div[@class = 'df aic']/button[contains(@class, 'df jcc bd0 cup on aic uppercase medium root-0-2-163')])[1]")
    private WebElement confirmDeleteItemFromCartInPopUp;

    public WebElement getConfirmDeleteItemFromCartInPopUp() {
        return confirmDeleteItemFromCartInPopUp;
    }

    public WebElement getDeleteItemFromCartInPopUp() {
        return deleteItemFromCartInPopUp;
    }

    public WebElement getClosePopUp() {
        return closePopUp;
    }

    public WebElement getPlaceOrderFromSecondPopUp() {
        return placeOrderFromSecondPopUp;
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public WebElement getCartItemsCount() {
        return cartItemsCount;
    }

    public WebElement getPlaceOrderAfterClickingToCart() {
        return placeOrderAfterClickingToCart;
    }

    public WebElement getGoToCartButton() {
        return goToCartButton;
    }

    public WebElement getFirstItemPrice() {
        return firstItemPrice;
    }

    public WebElement getFirstItemAddToCart() {
        return firstItemAddToCart;
    }

    public WebElement getPlaceOrder() {
        return placeOrder;
    }

}
