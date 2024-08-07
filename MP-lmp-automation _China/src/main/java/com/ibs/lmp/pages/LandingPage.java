package com.ibs.lmp.pages;

import com.ibs.utils.SeleniumUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.model.TestData;
import com.ibs.services.TestDataServices;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;

/**
 * This page handles the functionalities in landing page
 *
 * @author A-4641
 * 
 * 
 * Revision History
 * 
 * Revision Date         Author Description
 * 0.1      15-June-2023 A-4641 Created
 *  
 */
public class LandingPage extends CommonUtility {
	

	/**
	 * XPATH - Locators of elements in the page
	 */
	public static XPATH LMP_LOGIN_PAGE_JOIN_BUTTON = new XPATH("lmp-login-page-join-button",readXpathStringFromPropertyFile("XPATH_LMP_LOGIN_PAGE_JOIN_BUTTON"));
	public static XPATH LMP_REGISTER_PAGE_LOGO_BUTTON = new XPATH("lmp-register-page-logo-button",readXpathStringFromPropertyFile("XPATH_LMP_REGISTER_PAGE_LOGO_BUTTON"));
	public static XPATH LMP_LOGIN_PAGE_MEMBERID_TEXTBOX =  new XPATH("lmp-login-page-memberid-textbox",readXpathStringFromPropertyFile("XPATH_LMP_LOGIN_PAGE_MEMBERID_TEXTBOX"));
	public static XPATH LMP_LOGIN_PAGE_PASSWORD_TEXTBOX = new XPATH("lmp-login-page-password-textbox",readXpathStringFromPropertyFile("XPATH_LMP_LOGIN_PAGE_PASSWORD_TEXTBOX"));
	public static XPATH LMP_LOGIN_PAGE_LOGIN_BUTTON = new XPATH("lmp-login-page-login-button",readXpathStringFromPropertyFile("XPATH_LMP_LOGIN_PAGE_LOGIN_BUTTON"));
	public static XPATH LMP_LOGIN_PAGE_MEMBERID_CHKBOX = new XPATH("lmp-login-page-memberid-chkbox",readXpathStringFromPropertyFile("XPATH_LMP_LOGIN_PAGE_MEMBERID_CHKBOX"));
    public static XPATH LMP_LOGIN_PAGE_EMAIL_CHKBOX = new XPATH("lmp-login-page-email-chkbox",readXpathStringFromPropertyFile("XPATH_LMP_LOGIN_PAGE_EMAIL_CHKBOX"));
	public static XPATH LMP_LOGIN_PAGE_EMAIL_TEXTBOX= new XPATH("lmp-login-page-email-textbox",readXpathStringFromPropertyFile("XPATH_LMP_LOGIN_PAGE_EMAIL_TEXTBOX"));
	public static XPATH LMP_LOGIN_PAGE_FORGOTPASSWORD_LINK = new XPATH("lmp-login-page_forgotpassword_link",readXpathStringFromPropertyFile("XPATH_LMP_LOGIN_PAGE_FORGOTPASSWORD_LINK"));
	public static XPATH LMP_LOGIN_PAGE_CAPTCHA_CHKBOX = new XPATH("lmp-login-page-captcha_chkbox",readXpathStringFromPropertyFile("XPATH_LMP_LOGIN_PAGE_CAPTCHA_CHKBOX"));

	/**
	 * driver
	 */
	private WebDriver driver ;
	
	/**
	 * logger
	 */
	private ExtentTest logger;

	/**
	 * LandingPage - constructor
	 * @param driver
	 * @param logger
	 */
	public LandingPage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}

	/**
	 * Handles Click of JoinNow Button
	 * @return
	 */
	public boolean clickRegister() throws Exception {
		
		clickElementJSIfExists(driver, LMP_LOGIN_PAGE_JOIN_BUTTON);
		TestNGUtils.reportLog(logger,"Clicked the Join Now Button");
		boolean verifyLogoMssg = isWebElementVisible(driver, LMP_REGISTER_PAGE_LOGO_BUTTON);
		if (!verifyLogoMssg) {
			throw new RuntimeException(LMP_REGISTER_PAGE_LOGO_BUTTON.getelementName() + " not visible in the page.");
		}else {
			TestNGUtils.reportLog(logger,"Member Enrollment page is visible");
		}
		return verifyLogoMssg;
	}

	/**
	 * Handles the verification of landing page loaded correctly or not
	 * @return
	 */
	public boolean verifyLandingPage() throws Exception {
		boolean verifyLandingPage = isWebElementVisible(driver, LMP_LOGIN_PAGE_JOIN_BUTTON);
		if (!verifyLandingPage) {
			throw new RuntimeException(LMP_LOGIN_PAGE_JOIN_BUTTON.getelementName() + " not visible in the page.");
		}
		return verifyLandingPage;
	}

	/**
	 * Handles the login to the portal using membership number and email id
	 * @param testData
	 */
	public void login(TestData testData) throws Exception{
		if (!TestDataServices.getTestDataValue(testData, "loginMembershipID").contains("MP##NA")) {
			checkCheckBoxIfNot(driver, LMP_LOGIN_PAGE_MEMBERID_CHKBOX);
		}
		if (!TestDataServices.getTestDataValue(testData, "loginEmail").contains("MP##NA")) {
			checkCheckBoxIfNot(driver, LMP_LOGIN_PAGE_EMAIL_CHKBOX);
		}
		clearTextAndEnterValueWithNullCheck(driver, LMP_LOGIN_PAGE_MEMBERID_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "loginMembershipID"));
		clearTextAndEnterValueWithNullCheck(driver, LMP_LOGIN_PAGE_EMAIL_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "loginEmail"));
		clearTextAndEnterValueWithNullCheck(driver, LMP_LOGIN_PAGE_PASSWORD_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "loginPassword"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		
		
	   // SeleniumUtils.waitForFrameAndSwitchToFrame(driver, "//iframe[@title='reCAPTCHA']", 5);
		//SeleniumUtils.waitForElement(driver, LMP_LOGIN_PAGE_CAPTCHA_CHKBOX);
		 driver.findElement(By.cssSelector("div.recaptcha-checkbox-border")).click();
		//SeleniumUtils.clickElement(driver, LMP_LOGIN_PAGE_CAPTCHA_CHKBOX);
		//clickElementJSIfExists(driver, LMP_LOGIN_PAGE_CAPTCHA_CHKBOX);
		TestNGUtils.reportLog(logger,"Entered user login credentials");
		
		clickElementJSIfExists(driver, LMP_LOGIN_PAGE_LOGIN_BUTTON);
		TestNGUtils.reportLog(logger,"Clicked on login button");

	}
	//Forgot password Link
	public LandingPage clikOnForgotPasswordLink(){

		TestNGUtils.reportLog(logger,"Clicked on Forgot Password link");
		SeleniumUtils.waitForElement(driver, LMP_LOGIN_PAGE_FORGOTPASSWORD_LINK);
		//Click Forgot Password Link
		SeleniumUtils.clickElement(driver, LMP_LOGIN_PAGE_FORGOTPASSWORD_LINK);
		return this;
	}

}
