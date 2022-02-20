package com.selenium.hw.context;

import com.selenium.hw.page.CheckoutPage;

import static com.selenium.hw.tests.TestBase.driver;

public class CheckoutContext {
    public static CheckoutPage checkoutPage = new CheckoutPage(driver);

    public static int getTotalPriceValue(){
        String totalPrice= checkoutPage.getTotalPrice().getText();
        totalPrice = totalPrice.replaceAll("\\s+","");
        return Integer.parseInt(totalPrice);
    }
}
