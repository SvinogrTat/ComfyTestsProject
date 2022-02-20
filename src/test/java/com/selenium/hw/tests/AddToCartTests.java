package com.selenium.hw.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AddToCartTests extends TestBase {

    @DataProvider(name = "negative_phone_input")
    public Object[][] dpMethod() {
        return new Object[][]{{""}, {"067"}, {"000"}};
    }

    @Test(groups = {"e2e_test", "hp_test"})
    public void addToCartPlaceOrderTest() {
        int priceOnHP = ctrsHomeContext.getFirstItemPrice();
        log.info("First price: " + priceOnHP);
        ctrsHomeContext.addFirstItemToCart();
        ctrsHomeContext.placeOrderClick();
        int totalPrice = checkoutContext.getTotalPriceValue();
        log.info("First price: " + totalPrice);
        Assert.assertEquals(priceOnHP, totalPrice);
    }

    @Test(groups = "hp_test")
    public void confirmOrderDisabledBeforeEnteringPersonalData() {
        ctrsHomeContext.addFirstItemToCart();
        ctrsHomeContext.placeOrderClick();
        log.info(checkoutContext.getConfirmOrderButton().isDisplayed());
        Assert.assertTrue(checkoutContext.getConfirmOrderButton().isDisplayed());
    }

    @Test(groups = "hp_test")
    public void confirmOrderDisabledBeforeEnteringShippingData() {
        ctrsHomeContext.addFirstItemToCart();
        ctrsHomeContext.placeOrderClick();
        checkoutContext.enterName("Tata");
        checkoutContext.enterPhone("0675701023");
        checkoutContext.clickFirstProceedButton();
        log.info(checkoutContext.getConfirmOrderButton().isDisplayed());
        Assert.assertTrue(checkoutContext.getConfirmOrderButton().isDisplayed());
    }

    @Test(groups = "hp_test")
    public void confirmOrderEnabledAfterEnteringAllPersonalData() {
        ctrsHomeContext.addFirstItemToCart();
        ctrsHomeContext.placeOrderClick();
        checkoutContext.enterName("Tata");
        checkoutContext.enterPhone("0675701023");
        checkoutContext.clickFirstProceedButton();
        checkoutContext.addShippingInfoAndProceed();
        log.info(checkoutContext.getConfirmOrderButton().isEnabled());
        Assert.assertTrue(checkoutContext.getConfirmOrderButton().isEnabled());
    }

    @Test(groups = "e2e_test")
    public void addToCartGoToCartTest() {
        int priceOnHP = ctrsHomeContext.getFirstItemPrice();
        log.info("First price: " + priceOnHP);
        ctrsHomeContext.addFirstItemToCart();
        ctrsHomeContext.goToCartFromPopUp();
        ctrsHomeContext.placeOrderFromSecondPopUp();
        int totalPrice = checkoutContext.getTotalPriceValue();
        log.info("First price: " + totalPrice);
        Assert.assertEquals(priceOnHP, totalPrice);
    }

    @Test(groups = "e2e_test")
    public void addToCartAndPlaceOrderFromCart() {
        int priceOnHP = ctrsHomeContext.getFirstItemPrice();
        log.info("First price: " + priceOnHP);
        ctrsHomeContext.addFirstItemToCart();
        ctrsHomeContext.closePopUp();
        ctrsHomeContext.clickCartButton();
        ctrsHomeContext.placeOrderFromSecondPopUp();
        int totalPrice = checkoutContext.getTotalPriceValue();
        log.info("First price: " + totalPrice);
        Assert.assertEquals(priceOnHP, totalPrice);
    }

    @Test(groups = "advanced_test")
    public void verifyCartCount() {
        ctrsHomeContext.addFirstItemToCart();
        ctrsHomeContext.closePopUp();
        int cartItemsCount = ctrsHomeContext.getCartItemsCount();
        log.info("Cart items count: " + cartItemsCount);
        Assert.assertEquals(1, cartItemsCount);
    }

    @Test(groups = "negative_test")
    public void deleteItemsFromCartAndVerifyCartCount() {
        ctrsHomeContext.addFirstItemToCart();
        ctrsHomeContext.closePopUp();
        ctrsHomeContext.clickCartButton();
        ctrsHomeContext.deleteItemFromCartInPopUp();
        ctrsHomeContext.closePopUp();
        log.info(ctrsHomeContext.getCartButton().isDisplayed());
        Assert.assertTrue(ctrsHomeContext.getCartButton().isDisplayed());
    }

    @Test(groups = "negative_test")
    public void verifyEmptyNameDataValidation() {
        ctrsHomeContext.addFirstItemToCart();
        ctrsHomeContext.placeOrderClick();
        checkoutContext.clickFirstProceedButton();
        String validationText = checkoutContext.returnNameErrorText();
        log.info("Name error " + validationText);
        Assert.assertEquals("Обязательно должно быть заполнено", validationText);
    }

    @Test(dataProvider = "negative_phone_input", groups = "negative_test")
    public void verifyEmptyPhoneDataValidation(String phoneToEnter) {
        ctrsHomeContext.addFirstItemToCart();
        ctrsHomeContext.placeOrderClick();
        checkoutContext.enterPhone(phoneToEnter);
        checkoutContext.clickFirstProceedButton();
        String validationText = checkoutContext.returnPhoneErrorText();
        log.info("Phone error " + validationText);
        Assert.assertEquals("Укажите корректный номер телефона", validationText);
    }

}
