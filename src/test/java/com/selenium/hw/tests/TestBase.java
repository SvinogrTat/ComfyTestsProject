package com.selenium.hw.tests;

import com.selenium.hw.ConfPropertiesReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;


public class TestBase {
    public static WebDriver driver;

    @BeforeClass
    public static void initializeWebDriver() {
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
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfPropertiesReader.getProperty("baseurl"));

//        driver.navigate().executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})")
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

}
