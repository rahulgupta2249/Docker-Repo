package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(name = "phone")
    private WebElement phoneTxt;

    @FindBy(name = "userName")
    private WebElement emailTxt;

    @FindBy(name = "country")
    private WebElement countryDrpDown;

    @FindBy(id = "email")
    private WebElement userIdTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(id = "register-btn")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void goToURL(String url){
        this.driver.get(url);
        this.webDriverWait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
    }

    public void enterUserDetails(String firstName,String lastName,String phNo,String email,String country){
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
        this.phoneTxt.sendKeys(phNo);
        this.emailTxt.sendKeys(email);
        Select select = new Select(this.countryDrpDown);
        select.selectByVisibleText(country);
    }

    public void enterUserCredentials(String userName,String password){
        this.userIdTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
    }

    public void submit(){
        this.submitBtn.click();
    }

}
