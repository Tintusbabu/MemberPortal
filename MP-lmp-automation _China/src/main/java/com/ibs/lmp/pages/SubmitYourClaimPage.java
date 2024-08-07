package com.ibs.lmp.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.model.TestData;
import com.ibs.services.TestDataServices;
import com.ibs.utils.SeleniumUtils;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;
import org.openqa.selenium.WebDriver;

public class SubmitYourClaimPage extends CommonUtility {

    /**
     * XPATH - Locators of elements in the page
     */
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_VERIFY_MESS = new XPATH("lmp-claimsubmission-page-verify-label", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_VERIFY_MESS"));
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_PARTNERCODE_INPUT = new XPATH("lmp-claimsubmission-page-partnercode-input", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_PARTNERCODE_INPUT"));
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_FLIGHTNUMBER_INPUT = new XPATH("lmp-claimsubmission-page-flightnumber-input", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_FLIGHTNUMBER_INPUT"));
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_ORIGINAIRPORT_INPUT = new XPATH("lmp-claimsubmission-page-originairport-input", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_ORIGINAIRPORT_INPUT"));
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_DESTINATIONAIRPORT_INPUT = new XPATH("lmp-claimsubmission-page-destinationairport-input", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_DESTINATIONAIRPORT_INPUT"));
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_TICKETNUMBER_INPUT = new XPATH("lmp-claimsubmission-page-ticketnumber-input", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_TICKETNUMBER_INPUT"));
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_FIRSTNAME_INPUT = new XPATH("lmp-claimsubmission-page-firstname-input", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_FIRSTNAME_INPUT"));
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_LASTNAME_INPUT = new XPATH("lmp-claimsubmission-page-lastname-input", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_LASTNAME_INPUT "));
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_REF_INPUT = new XPATH("lmp-claimsubmission-page-referencenumber-input", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_REF_INPUT"));
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_DEPARTURE_DATE = new XPATH("lmp-claimsubmission-page-departuredte-input", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_DEPARTURE_DATE"));
    public static XPATH LMP_CLAIMSUBMISSION_PAGE_CLAIMSUBMIT_BTN  = new XPATH("lmp-claimsubmission-page-submit_btn", readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUBMISSION_PAGE_CLAIMSUBMIT_BTN"));



    /*






XPATH_LMP_CLAIMSUBMISSION_PAGE_REF_INPUT   =//input[@id= 'submitClaim_id-bookingReferenceNumber']

     */

    /**
     * driver
     */
    private WebDriver driver;

    /**
     * logger
     */
    private ExtentTest logger;

    /**
     * constructor - SubmitYourClaimPage
     *
     * @param driver
     * @param logger
     */
    public SubmitYourClaimPage(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
    }

    /**
     * This handles the title is visible in Claim Submission Page
     *
     * @return
     */
    public boolean verifySubmitYourClaimPageTitle() throws Exception {
        boolean verifyTitleMssg = isWebElementVisible(driver, LMP_CLAIMSUBMISSION_PAGE_VERIFY_MESS);

        if (!verifyTitleMssg) {
            throw new RuntimeException(LMP_CLAIMSUBMISSION_PAGE_VERIFY_MESS.getelementName() + " not visible in the page.");
        } else {
            TestNGUtils.reportLog(logger, "Verified the Claim Submission Page loading");

        }
        return verifyTitleMssg;
    }

    /**
     * This handles entering the airline code
     */
    public void enterAirlineCode(String airlineCode) throws Exception {

        clearTextAndEnterValueWithNullCheck(driver, LMP_CLAIMSUBMISSION_PAGE_PARTNERCODE_INPUT, airlineCode);
        TestNGUtils.reportLog(logger, "Enter the Airline code as: " + airlineCode);


    }

    /**
     * Enter the Flight number
     */
    public void enterFlightNumber(String flightNumber) throws Exception {

        clearTextAndEnterValueWithNullCheck(driver, LMP_CLAIMSUBMISSION_PAGE_FLIGHTNUMBER_INPUT, flightNumber);
        TestNGUtils.reportLog(logger, "Enter the Flight Number as: " + flightNumber);


    }

    /**
     * Enter the Departure Date
     *
     */
    public void enterDepartureDate(String departureDate) throws Exception {

        clearTextAndEnterValueWithNullCheck(driver, LMP_CLAIMSUBMISSION_PAGE_DEPARTURE_DATE, departureDate);
        TestNGUtils.reportLog(logger, "Enter the Departure date as: " + departureDate);


    }
    /**
     * Enter the Origin Location
     *
     */
    public void enterOriginLocation(String departureDate) throws Exception {

        clearTextAndEnterValueWithNullCheck(driver, LMP_CLAIMSUBMISSION_PAGE_ORIGINAIRPORT_INPUT, departureDate);
        TestNGUtils.reportLog(logger, "Enter the Origin Location as: " + departureDate);


    }
    /**
     * Enter the Destination Location
     *
     */
    public void enterDestinationLocation(String departureDate) throws Exception {

        clearTextAndEnterValueWithNullCheck(driver, LMP_CLAIMSUBMISSION_PAGE_DESTINATIONAIRPORT_INPUT, departureDate);
        TestNGUtils.reportLog(logger, "Enter the Destination Location  as: " + departureDate);


    }
    /**
     * Enter the Ticket Number
     *
     */
    public void enterTicketNumber(String ticketNumber) throws Exception {

        clearTextAndEnterValueWithNullCheck(driver, LMP_CLAIMSUBMISSION_PAGE_TICKETNUMBER_INPUT, ticketNumber);
        TestNGUtils.reportLog(logger, "Enter the TicketNumber   as: " + ticketNumber);


    }
    /**
     * Enter the Passenger First Name
     *
     */
    public void enterPassengerFirstName(String firstName) throws Exception {

        clearTextAndEnterValueWithNullCheck(driver, LMP_CLAIMSUBMISSION_PAGE_FIRSTNAME_INPUT, firstName);
        TestNGUtils.reportLog(logger, "Enter the First Name  as: " + firstName);


    }

    /**
     * Enter the Passenger Last Name
     *
     */
    public void enterPassengerLastName(String lasttName) throws Exception {

        clearTextAndEnterValueWithNullCheck(driver, LMP_CLAIMSUBMISSION_PAGE_LASTNAME_INPUT, lasttName);
        TestNGUtils.reportLog(logger, "Enter the LastName as: " + lasttName);


    }
    /**
     * Enter the Rference Number
     *
     */
    public void enterReferenceNumber(String referenceNumber) throws Exception {

        clearTextAndEnterValueWithNullCheck(driver,  LMP_CLAIMSUBMISSION_PAGE_REF_INPUT, referenceNumber);
        TestNGUtils.reportLog(logger, "Enter the Refrence Number as: " + referenceNumber);


    }
    /**
     * clic on Claim submit button
     *
     */
    public void clickOnSubmitBtn() throws Exception {

        SeleniumUtils.clickElement(driver,  LMP_CLAIMSUBMISSION_PAGE_VERIFY_MESS);
        SeleniumUtils.clickElementUsingActionClass(driver,LMP_CLAIMSUBMISSION_PAGE_CLAIMSUBMIT_BTN);


    }
    public void claimSumbission(TestData testData) throws Exception {
        System.out.println("Flight Number::" + TestDataServices.getTestDataValue(testData, "Flight Number"));
        enterAirlineCode(TestDataServices.getTestDataValue(testData, "Airline"));
        enterFlightNumber(TestDataServices.getTestDataValue(testData, "Flight Number"));
        enterDepartureDate(TestDataServices.getTestDataValue(testData, "Departure Date"));
        enterOriginLocation(TestDataServices.getTestDataValue(testData, "Origin"));
        enterDestinationLocation(TestDataServices.getTestDataValue(testData, "Destination"));
        enterTicketNumber(TestDataServices.getTestDataValue(testData, "Ticket Number"));
        enterPassengerFirstName(TestDataServices.getTestDataValue(testData, "Passenger first name"));
        enterPassengerLastName(TestDataServices.getTestDataValue(testData, "Passenger last name"));
        enterReferenceNumber(TestDataServices.getTestDataValue(testData, "Booking Reference Number"));
        clickOnSubmitBtn();
    }

}
