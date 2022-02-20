package com.selenium.hw.tests;

import com.selenium.hw.context.CheckoutContext;
import com.selenium.hw.context.CtrsHomeContext;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddToCartTests extends TestBase {

    @Test(groups = "e2e_test")
    public void addToCartPlaceOrderTest() {
        int priceOnHP = CtrsHomeContext.getFirstItemPrice();
        log.info("First price: " + priceOnHP);
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.placeOrderClick();
        int totalPrice = CheckoutContext.getTotalPriceValue();
        log.info("First price: " + totalPrice);
        Assert.assertEquals(priceOnHP, totalPrice);
    }

    @Test(groups = "e2e_test")
    public void addToCartBuyOnCreditTest() {
        int priceOnHP = CtrsHomeContext.getFirstItemPrice();
        log.info("First price: " + priceOnHP);
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.goToCartFromPopUp();
        CtrsHomeContext.placeOrderFromSecondPopUp();
        int totalPrice = CheckoutContext.getTotalPriceValue();
        log.info("First price: " + totalPrice);
        Assert.assertEquals(priceOnHP, totalPrice);
    }

    @Test(groups = "e2e_test")
    public void addToCartAndPlaceOrderFromCart() {
        int priceOnHP = CtrsHomeContext.getFirstItemPrice();
        log.info("First price: " + priceOnHP);
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.closePopUp();
        CtrsHomeContext.clickCartButton();
        CtrsHomeContext.placeOrderFromSecondPopUp();
        int totalPrice = CheckoutContext.getTotalPriceValue();
        log.info("First price: " + totalPrice);
        Assert.assertEquals(priceOnHP, totalPrice);
    }

    @Test(groups = "advanced_test")
    public void verifyCartCount() {
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.closePopUp();
        int cartItemsCount = CtrsHomeContext.getCartItemsCount();
        log.info("Cart items count: " + cartItemsCount);
        Assert.assertEquals(1, cartItemsCount);
    }

    @Test(groups = "negative_test")
    public void deleteItemsFromCartAndVerifyCartCount() {
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.closePopUp();
        CtrsHomeContext.clickCartButton();
        CtrsHomeContext.deleteItemFromCartInPopUp();
        CtrsHomeContext.closePopUp();
        log.info(CtrsHomeContext.getCartButton().isDisplayed());
        Assert.assertTrue(CtrsHomeContext.getCartButton().isDisplayed());
    }

}
