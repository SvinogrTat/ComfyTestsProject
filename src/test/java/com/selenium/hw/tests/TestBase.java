package com.selenium.hw.tests;

import com.selenium.hw.config.ConfPropertiesReader;

import java.time.Duration;
import java.util.Collections;

import com.selenium.hw.context.CheckoutContext;
import com.selenium.hw.context.CtrsHomeContext;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class TestBase {
    protected WebDriver driver;
    protected CheckoutContext checkoutContext;
    protected CtrsHomeContext ctrsHomeContext;
    protected static org.apache.log4j.Logger log = Logger.getLogger(AddToCartTests.class);

    @BeforeMethod(alwaysRun = true)
    public void initializeWebDriver() {
        System.err.println("Init web driver");
        //ChromeDriver settings
        System.setProperty("webdriver.chrome.driver", ConfPropertiesReader.getProperty("chromedriver"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito"
//                , "--disable-blink-features"
//                , "--disable-blink-features=AutomationControlled"
//                , "--disable-extensions"
//                , "--start-maximized"
//                ,"--headless"
        );

        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        driver = new ChromeDriver(chromeOptions);
        //SafariDriver settings
//        System.setProperty("webdriver.safari.driver", ConfPropertiesReader.getProperty("safaridriver"));
//        driver = new SafariDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(ConfPropertiesReader.getProperty("baseurl"));
        checkoutContext = new CheckoutContext(driver);
        ctrsHomeContext = new CtrsHomeContext(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        System.err.println("Quit web driver");
        driver.quit();
    }

}
