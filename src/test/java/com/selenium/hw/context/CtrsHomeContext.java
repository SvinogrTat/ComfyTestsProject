package com.selenium.hw.context;


import com.selenium.hw.page.CheckoutPage;
import com.selenium.hw.page.CtrsHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.hw.tests.TestBase.driver;

import java.time.Duration;

public class CtrsHomeContext {
    public static CtrsHomePage ctrsHomePage = new CtrsHomePage(driver);
    public static CheckoutPage checkoutPage = new CheckoutPage(driver);

    //move out xpathes

    public static void addFirstItemToCart() {
        ctrsHomePage.getFirstItemAddToCart().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ctrsHomePage.getPlaceOrder()));
    }

    public static int getFirstItemPrice() {
        return Integer.parseInt(ctrsHomePage.getFirstItemPrice().getAttribute("data-price"));
    }

    public static void placeOrderClick() {
        ctrsHomePage.getPlaceOrder().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(checkoutPage.getTotalPriceHeader()));
    }

    public static void goToCartFromPopUp() {
        ctrsHomePage.getGoToCartButton().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ctrsHomePage.getPlaceOrderFromSecondPopUp()));
    }

    public static void placeOrderFromSecondPopUp() {
        ctrsHomePage.getPlaceOrderFromSecondPopUp().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(checkoutPage.getTotalPriceHeader()));
    }

    public static void closePopUp() {
        ctrsHomePage.getClosePopUp().click();
    }

    public static void clickCartButton() {
        ctrsHomePage.getCartButton().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ctrsHomePage.getPlaceOrderFromSecondPopUp()));
    }

    public static int getCartItemsCount() {
        return Integer.parseInt(ctrsHomePage.getCartItemsCount().getText());
    }

    public static void deleteItemFromCartInPopUp() {
        ctrsHomePage.getDeleteItemFromCartInPopUp().click();
        ctrsHomePage.getConfirmDeleteItemFromCartInPopUp().click();
    }

    public static WebElement getCartButton() {
        return ctrsHomePage.getCartButton();
    }


//    public void addItemsToCart(int numberOfItems){
//        String baseXPath = "(//button [@class = 'base-button row justify-center items-center no-wrap buy-small-btn products-list-control__item products-list-control__item--small'])";
//        for (int i = 1; i <= numberOfItems; i++) {
//            TestBase.driver.findElement(By.xpath(baseXPath + "[" + i + "]")).click();
//        }
}
