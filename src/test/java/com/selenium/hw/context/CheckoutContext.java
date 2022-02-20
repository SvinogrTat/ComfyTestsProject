package com.selenium.hw.context;

import com.selenium.hw.page.CheckoutPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static com.selenium.hw.tests.TestBase.driver;

public class CheckoutContext {
    public static CheckoutPage checkoutPage = new CheckoutPage(driver);

    public static int getTotalPriceValue(){
        String totalPrice= checkoutPage.getTotalPrice().getText();
        totalPrice = totalPrice.replaceAll("\\s+","");
        return Integer.parseInt(totalPrice);
    }

    public static WebElement getConfirmOrderButton(){
        return checkoutPage.getConfirmOrderButton();
    }

    public static void clickFirstProceedButton(){
        checkoutPage.getProceedButton().click();
    }

    public static String returnNameErrorText(){
        return checkoutPage.getNameErrorSection().getText();
    }

    public static String returnPhoneErrorText(){
        return checkoutPage.getPhoneErrorSection().getText();
    }

    public static void enterPhone(String phone){
        checkoutPage.getPhoneInput().sendKeys(phone);
    }

    public static void enterName(String name){

        checkoutPage.getNameInput().sendKeys(name);
    }

    public static void addShippingInfoAndProceed(){
        checkoutPage.getKharkivShipping().click();
        checkoutPage.getChoseSelfDelivery().click();
//        checkoutPage.getChoseUnitInput().click();
        checkoutPage.getChoseAnyUnit().click();
        checkoutPage.getSecondProceedButton().click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(checkoutPage.getConfirmOrderButton()));
    }
}
