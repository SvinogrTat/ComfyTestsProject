package com.selenium.hw.tests;

import com.selenium.hw.context.CheckoutContext;
import com.selenium.hw.context.CtrsHomeContext;
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
        int priceOnHP = CtrsHomeContext.getFirstItemPrice();
        log.info("First price: " + priceOnHP);
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.placeOrderClick();
        int totalPrice = CheckoutContext.getTotalPriceValue();
        log.info("First price: " + totalPrice);
        Assert.assertEquals(priceOnHP, totalPrice);
    }

    @Test(groups = "hp_test")
    public void confirmOrderDisabledBeforeEnteringPersonalData() {
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.placeOrderClick();
        log.info(CheckoutContext.getConfirmOrderButton().isDisplayed());
        Assert.assertTrue(CheckoutContext.getConfirmOrderButton().isDisplayed());
    }

    @Test(groups = "hp_test")
    public void confirmOrderDisabledBeforeEnteringShippingData() {
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.placeOrderClick();
        CheckoutContext.enterName("Tata");
        CheckoutContext.enterPhone("0675701023");
        CheckoutContext.clickFirstProceedButton();
        log.info(CheckoutContext.getConfirmOrderButton().isDisplayed());
        Assert.assertTrue(CheckoutContext.getConfirmOrderButton().isDisplayed());
    }

    @Test(groups = "hp_test")
    public void confirmOrderEnabledAfterEnteringAllPersonalData() {
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.placeOrderClick();
        CheckoutContext.enterName("Tata");
        CheckoutContext.enterPhone("0675701023");
        CheckoutContext.clickFirstProceedButton();
        CheckoutContext.addShippingInfoAndProceed();
        log.info(CheckoutContext.getConfirmOrderButton().isEnabled());
        Assert.assertTrue(CheckoutContext.getConfirmOrderButton().isEnabled());
    }

    @Test(groups = "e2e_test")
    public void addToCartGoToCartTest() {
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

    @Test(groups = "negative_test")
    public void verifyEmptyNameDataValidation() {
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.placeOrderClick();
        CheckoutContext.clickFirstProceedButton();
        String validationText = CheckoutContext.returnNameErrorText();
        log.info("Name error " + validationText);
        Assert.assertEquals("Обязательно должно быть заполнено", validationText);
    }

    @Test(dataProvider = "negative_phone_input", groups = "negative_test")
    public void verifyEmptyPhoneDataValidation(String phoneToEnter) {
        CtrsHomeContext.addFirstItemToCart();
        CtrsHomeContext.placeOrderClick();
        CheckoutContext.enterPhone(phoneToEnter);
        CheckoutContext.clickFirstProceedButton();
        String validationText = CheckoutContext.returnPhoneErrorText();
        log.info("Phone error " + validationText);
        Assert.assertEquals("Укажите корректный номер телефона", validationText);
    }

}
