package com.selenium.hw.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class = 'payment__total-price']/span[@class = 'price']")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[contains(text(), 'Итого')]")
    private WebElement totalPriceHeader;

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getTotalPriceHeader() {
        return totalPriceHeader;
    }
}
