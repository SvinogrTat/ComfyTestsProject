package com.selenium.hw.tests;

import com.selenium.hw.pageobjects.ComfyHomePage;
import org.junit.Assert;
import org.junit.Test;

public class AddToCartTest extends TestBase {

    @Test
    public void addToCartTest(){
        ComfyHomePage comfyHomePage = new ComfyHomePage(driver);
//        comfyHomePage.addItemsToCart(3);
        comfyHomePage.addItemToCart();
        Assert.assertEquals(1, comfyHomePage.getCartItemsQuantity());
    }
}
