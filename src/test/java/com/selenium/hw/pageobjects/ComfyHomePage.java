package com.selenium.hw.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComfyHomePage {
    WebDriver driver;

    @FindBy(xpath = "//*[@class = 'header-bottom-cart__image-cart']")
    WebElement headerBottomCart;

    @FindBy(xpath = "(//button [@class = 'base-button row justify-center items-center no-wrap buy-small-btn products-list-control__item products-list-control__item--small'])")
    WebElement listOfItems;

    public ComfyHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItemToCart(){
        listOfItems.click();
    }

    public int getCartItemsQuantity(){
        int cartItemsQuantity = Integer.parseInt(headerBottomCart.getAttribute("data-qty"));
        return cartItemsQuantity;
    }

    public void addItemsToCart(int numberOfItems){
        String baseXPath = "(//button [@class = 'base-button row justify-center items-center no-wrap buy-small-btn products-list-control__item products-list-control__item--small'])";
        for (int i = 1; i <= numberOfItems; i++) {
            driver.findElement(By.xpath(baseXPath + "[" + i + "]")).click();
        }
    }


}
