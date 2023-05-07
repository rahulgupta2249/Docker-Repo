package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightDetailsPage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBy(id = "passCount")
    private WebElement noOfPassengerDrpDwn;

    @FindBy(xpath = "//input[@value='Business']")
    private WebElement serviceClassRadioBtn;

    @FindBy(id = "findFlights")
    private WebElement continueBtn;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void fillFlightDetailsPage(String noOfPassenger){
        this.webDriverWait.until(ExpectedConditions.visibilityOf(this.serviceClassRadioBtn));
        Select select = new Select(this.noOfPassengerDrpDwn);
        select.selectByValue(noOfPassenger);

        this.serviceClassRadioBtn.click();
    }

    public void continueBtn(){
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(this.continueBtn));
        this.continueBtn.click();
    }

}
