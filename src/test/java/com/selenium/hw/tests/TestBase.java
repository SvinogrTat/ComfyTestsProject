package com.selenium.hw.tests;

import com.selenium.hw.config.ConfPropertiesReader;

import java.time.Duration;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
    public static WebDriver driver;
    protected static org.apache.log4j.Logger log = Logger.getLogger(AddToCartTests.class);

    @BeforeMethod(alwaysRun = true)
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(ConfPropertiesReader.getProperty("baseurl"));

    }

    @AfterMethod(alwaysRun = true)
    public static void quitDriver() {
        driver.quit();
    }

}
