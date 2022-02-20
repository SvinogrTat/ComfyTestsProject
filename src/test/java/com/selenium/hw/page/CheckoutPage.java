package com.selenium.hw.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class = 'payment__total-price']/span[@class = 'price']")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[contains(text(), 'Итого')]")
    private WebElement totalPriceHeader;

    @FindBy(xpath = "//button[@class = 'btn-default btn-md btn-block order__confirm']")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//div[@class = 'outlined-text-form']//input[@autocomplete = 'name']")
    private WebElement nameInput;

    @FindBy(xpath = "//div[@class = 'outlined-text-form']//input[@autocomplete = 'mobile tel']")
    private WebElement phoneInput;

    @FindBy(xpath = "//div[@class = 'error-message error-name-field']")
    private WebElement nameErrorSection;

    @FindBy(xpath = "//div[@class = 'error-message error-phone-field']")
    private WebElement phoneErrorSection;

    @FindBy(xpath = "//button[@class = 'btn-default btn-md to-confirm-step']")
    private WebElement proceedButton;

    @FindBy(xpath = "//li[text() = 'Харьков']")
    private WebElement kharkivShipping;

    @FindBy(xpath = "//span[text() = 'Самовывоз из магазина «Цитрус»']")
    private WebElement choseSelfDelivery;

    @FindBy(xpath = "//input[@placeholder = 'Укажите отделение']")
    private WebElement choseUnitInput;

    @FindBy(xpath = "//span[text() = 'г. Харьков, пл. Свободы, 8']")
    private WebElement choseAnyUnit;

    @FindBy(xpath = "(//div[@class = 'step__body']/button)[3]")
    private WebElement secondProceedButton;

    public WebElement getKharkivShipping() {
        return kharkivShipping;
    }

    public WebElement getChoseSelfDelivery() {
        return choseSelfDelivery;
    }

    public WebElement getChoseUnitInput() {
        return choseUnitInput;
    }

    public WebElement getChoseAnyUnit() {
        return choseAnyUnit;
    }

    public WebElement getSecondProceedButton() {
        return secondProceedButton;
    }

    public WebElement getProceedButton() {
        return proceedButton;
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getPhoneInput() {
        return phoneInput;
    }

    public WebElement getNameErrorSection() {
        return nameErrorSection;
    }

    public WebElement getPhoneErrorSection() {
        return phoneErrorSection;
    }

    public WebElement getConfirmOrderButton() {
        return confirmOrderButton;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getTotalPriceHeader() {
        return totalPriceHeader;
    }
}
