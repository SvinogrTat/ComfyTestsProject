package com.selenium.hw.context;


import com.selenium.hw.page.CheckoutPage;
import com.selenium.hw.page.CtrsHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CtrsHomeContext {
    private WebDriver driver;
    public CtrsHomePage ctrsHomePage;
    public CheckoutPage checkoutPage;

    public CtrsHomeContext(WebDriver driver){
        this.driver = driver;
        this.ctrsHomePage = new CtrsHomePage(driver);
        this.checkoutPage = new CheckoutPage(driver);
    }


    public void addFirstItemToCart() {
        ctrsHomePage.getFirstItemAddToCart().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ctrsHomePage.getPlaceOrder()));
    }

    public int getFirstItemPrice() {
        return Integer.parseInt(ctrsHomePage.getFirstItemPrice().getAttribute("data-price"));
    }

    public void placeOrderClick() {
        ctrsHomePage.getPlaceOrder().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(checkoutPage.getTotalPriceHeader()));
    }

    public void goToCartFromPopUp() {
        ctrsHomePage.getGoToCartButton().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ctrsHomePage.getPlaceOrderFromSecondPopUp()));
    }

    public void placeOrderFromSecondPopUp() {
        ctrsHomePage.getPlaceOrderFromSecondPopUp().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(checkoutPage.getTotalPriceHeader()));
    }

    public void closePopUp() {
        ctrsHomePage.getClosePopUp().click();
    }

    public void clickCartButton() {
        ctrsHomePage.getCartButton().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ctrsHomePage.getPlaceOrderFromSecondPopUp()));
    }

    public int getCartItemsCount() {
        return Integer.parseInt(ctrsHomePage.getCartItemsCount().getText());
    }

    public void deleteItemFromCartInPopUp() {
        ctrsHomePage.getDeleteItemFromCartInPopUp().click();
        ctrsHomePage.getConfirmDeleteItemFromCartInPopUp().click();
    }

    public WebElement getCartButton() {
        return ctrsHomePage.getCartButton();
    }

}
