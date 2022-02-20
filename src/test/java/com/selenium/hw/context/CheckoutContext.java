package com.selenium.hw.context;

import com.selenium.hw.page.CheckoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutContext {
    private WebDriver driver;
    public CheckoutPage checkoutPage;

    public CheckoutContext(WebDriver driver) {
        this.driver = driver;
        this.checkoutPage = new CheckoutPage(driver);
    }

    public int getTotalPriceValue() {
        String totalPrice = checkoutPage.getTotalPrice().getText();
        totalPrice = totalPrice.replaceAll("\\s+", "");
        return Integer.parseInt(totalPrice);
    }

    public WebElement getConfirmOrderButton() {
        return checkoutPage.getConfirmOrderButton();
    }

    public void clickFirstProceedButton() {
        checkoutPage.getProceedButton().click();
    }

    public String returnNameErrorText() {
        return checkoutPage.getNameErrorSection().getText();
    }

    public String returnPhoneErrorText() {
        return checkoutPage.getPhoneErrorSection().getText();
    }

    public void enterPhone(String phone) {
        checkoutPage.getPhoneInput().sendKeys(phone);
    }

    public void enterName(String name) {
        checkoutPage.getNameInput().sendKeys(name);
    }

    public void addShippingInfoAndProceed() {
        checkoutPage.getKharkivShipping().click();
        checkoutPage.getChoseSelfDelivery().click();
//        checkoutPage.getChoseUnitInput().click();
        checkoutPage.getChoseAnyUnit().click();
        checkoutPage.getSecondProceedButton().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(checkoutPage.getConfirmOrderButton()));
    }
}
