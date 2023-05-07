package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationConfirmationPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBy(linkText = "Flights")
    private WebElement flightLink;

    public RegistrationConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void gotoFlightsPage(){
        this.flightLink.click();
    }


}
