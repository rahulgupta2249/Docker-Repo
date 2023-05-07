package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressPage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBy(id = "buyFlights")
    private WebElement buyFlightBtn;

    public AddressPage(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void setBuyFlightBtn(){
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(this.buyFlightBtn));
        this.buyFlightBtn.click();
    }
}
