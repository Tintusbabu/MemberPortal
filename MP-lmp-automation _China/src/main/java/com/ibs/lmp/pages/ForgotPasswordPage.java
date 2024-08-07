package com.ibs.lmp.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.model.TestData;
import com.ibs.services.TestDataServices;
import com.ibs.utils.SeleniumUtils;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.TrippleDes;
import com.ibs.utils.XPATH;
import org.openqa.selenium.WebDriver;
import com.ibs.lmp.common.CommonUtility;

public class ForgotPasswordPage extends CommonUtility {


    public static XPATH LMP_FORGOTPASSWORD_PAGE_VERIFY_MSSG = new XPATH("lmp-forgotPassword-page-link",readXpathStringFromPropertyFile("XPATH_LMP_FORGOTPASSWORD_PAGE_VERIFY_MSSG"));
    public static XPATH LMP_FORGOTPASSWORD_PAGE_MEMBERSHIPNUM_TEXTBOX = new XPATH("lmp-forgotPassword-page-link_membershipNum",readXpathStringFromPropertyFile("XPATH_LMP_FORGOTPASSWORD_PAGE_MEMBERSHIPNUM_TEXTBOX"));
    public static XPATH LMP_FORGOTPASSWORD_PAGE_CONTINUE_BUTTON = new XPATH("lmp-forgotPassword-page-continue_button",readXpathStringFromPropertyFile("XPATH_LMP_FORGOTPASSWORD_PAGE_CONTINUE_BUTTON"));
    /**
     * driver
     */
    private WebDriver driver ;

    /**
     * logger
     */
    private ExtentTest logger;

    /**
     * constructor - ForgotPassword Page
     * @param driver
     * @param logger
     */
    public ForgotPasswordPage(WebDriver driver,ExtentTest logger) {
        this.driver=driver;
        this.logger=logger;
    }

    /**
     * verifyForgotPassword page
     * @return
     */
    public boolean verifyForgotPasswordPageTitle() throws Exception {
        boolean verifyWelcomeMssg =isWebElementVisible(driver, LMP_FORGOTPASSWORD_PAGE_VERIFY_MSSG);
        if(!verifyWelcomeMssg) {
            throw new RuntimeException(LMP_FORGOTPASSWORD_PAGE_VERIFY_MSSG.getelementName()+" not visible in the page.");
        }
        else {
            TestNGUtils.reportLog(logger,"Verified the Forgot Password page");

        }
        return verifyWelcomeMssg;
    }

    /**
     * Enter Membership number
     * @return
     * @throws Exception
     */
    public ForgotPasswordPage enterMembershipNumber(TestData testData) throws Exception {
        TestDataServices.getTestDataValue(testData, "loginMembershipID");
        String memberShipNum=TestDataServices.getTestDataValue(testData, "loginMembershipID");
        System.out.println("MembershipNum== "+memberShipNum);
        TestNGUtils.reportLog(logger,"Enter Membership Number: "+memberShipNum);
        SeleniumUtils.clearTextAndEnterValue(driver, LMP_FORGOTPASSWORD_PAGE_MEMBERSHIPNUM_TEXTBOX, memberShipNum);
        return this;
    }
    /**
     * Click on continue button
     * @return
     * @throws Exception
     */
    public ForgotPasswordPage clickOnContinueButton() throws Exception {

        SeleniumUtils.clickElement(driver, LMP_FORGOTPASSWORD_PAGE_CONTINUE_BUTTON);
        TestNGUtils.reportLog(logger,"Click on Continue button");
        return this;
    }

}
