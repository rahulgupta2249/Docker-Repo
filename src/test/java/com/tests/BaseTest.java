package com.tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void initialize(ITestContext ctx) throws MalformedURLException {
        String host = "localhost";
        MutableCapabilities options = new ChromeOptions();;

        System.out.println("Initialize the Browser");
        if(System.getProperty("BROWSER").equalsIgnoreCase("chrome") || System.getProperty("BROWSER").equalsIgnoreCase(null)){
            options = new ChromeOptions();

        } else if (System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            options = new FirefoxOptions();

        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }
        options.setCapability("test Name",ctx.getCurrentXmlTest().getName());
        driver = new RemoteWebDriver(new URL("http://"+host+":4444/"),options);
        System.out.println("Closing the Browser");
    }


    @AfterTest
    public void closeDriver(){
        this.driver.quit();
    }

}
