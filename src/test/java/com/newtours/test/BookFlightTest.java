package com.newtours.test;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

//    @BeforeTest
//    public void initialize(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(chromeOptions);
//    }

    @Test
    public void registrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(this.driver);
        registrationPage.goToURL("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        registrationPage.enterUserDetails("Rahul", "Gupta", "9975977373", "RahulGupta2249@gmail.com", "INDIA");
        registrationPage.enterUserCredentials("Rahul", "Gupta");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.gotoFlightsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    @Parameters("noOfPassenger")
    public void flightDetailsPage(String noOfPassenger) {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.fillFlightDetailsPage(noOfPassenger);
        flightDetailsPage.continueBtn();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void flightSelectPage() {
        FlightSelectPage flightSelectPage = new FlightSelectPage(driver);
        flightSelectPage.continueBtn();
    }

    @Test(dependsOnMethods = "flightSelectPage")
    public void addressPage() {
        AddressPage addressPage = new AddressPage(driver);
        addressPage.setBuyFlightBtn();
    }

    @Test(dependsOnMethods = "addressPage")
    @Parameters("expectedPrice")
    public void flightConfirmationPage(String expectedPrice) {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.checkFlightDetails();
        Assert.assertEquals(expectedPrice, actualPrice);
    }


}
