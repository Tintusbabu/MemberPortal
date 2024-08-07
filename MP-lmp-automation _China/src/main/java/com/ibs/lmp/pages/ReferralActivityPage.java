package com.ibs.lmp.pages;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.model.TestData;
import com.ibs.services.TestDataServices;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;

/**
 * This page handles the functionalities in my activity page
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
public class ReferralActivityPage extends CommonUtility {
	
	/**
	 * XPATH - Locators of elements in the page
	 */
	public static XPATH LMP_REFERRALACTIVITY_PAGE_VERIFY_MSSG = new XPATH("lmp-referralactivity-page-verify-label",readXpathStringFromPropertyFile("XPATH_LMP_REFERRALACTIVITY_PAGE_VERIFY_MSSG"));
	public static XPATH LMP_REFERRALACTIVITY_PAGE_EMAIL_INPUT = new XPATH("lmp-memberprofile-page-title-label",readXpathStringFromPropertyFile("XPATH_LMP_REFERRALACTIVITY_PAGE_EMAIL_INPUT"));
	public static XPATH LMP_REFERRALACTIVITY_PAGE_SEND_BUTTON = new XPATH("lmp-referralactivity-page-verify-label",readXpathStringFromPropertyFile("XPATH_LMP_REFERRALACTIVITY_PAGE_SEND_BUTTON"));
	public static XPATH LMP_REFERRALACTIVITY_PAGE_SENDVERIFY_MSSG = new XPATH("lmp-memberprofile-page-title-label",readXpathStringFromPropertyFile("XPATH_LMP_REFERRALACTIVITY_PAGE_SENDVERIFY_MSSG"));
	
	
	
	/**
	 * driver
	 */
	private WebDriver driver ;
	
	/**
	 * logger
	 */
	private ExtentTest logger;

	/**
	 * constructor - MyActivityPage
	 * @param driver
	 * @param logger
	 */
	public ReferralActivityPage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}

	/**
	 * This handles the title is visible in My referral page
	 * @return
	 */
	public boolean verifyReferralActivityTitle() throws Exception{
		boolean verifyTitleMssg =isWebElementVisible(driver, LMP_REFERRALACTIVITY_PAGE_VERIFY_MSSG);
		
		if(!verifyTitleMssg) {
			throw new RuntimeException(LMP_REFERRALACTIVITY_PAGE_VERIFY_MSSG.getelementName()+" not visible in the page.");
		}else {
			TestNGUtils.reportLog(logger,"Verified the referral screen loading");

		}
		return verifyTitleMssg;
	}

	/**
	 * sendReferral
	 * @param testData
	 * @return
	 * @throws Exception
	 */
	public boolean sendReferral(TestData testData) throws Exception {
		
		String email = getRandomAlphaNumberString()+"@gmail.com";
		clearTextAndEnterValueWithNullCheck(driver, LMP_REFERRALACTIVITY_PAGE_EMAIL_INPUT, email);
		clickElementJSIfExists(driver, LMP_REFERRALACTIVITY_PAGE_SEND_BUTTON);
		boolean verifySuccessMssg =isWebElementVisible(driver, LMP_REFERRALACTIVITY_PAGE_SENDVERIFY_MSSG);
		
		if(!verifySuccessMssg) {
			throw new RuntimeException(LMP_REFERRALACTIVITY_PAGE_VERIFY_MSSG.getelementName()+" not visible in the page.");
		}else {
			String textMssg = getText(driver, LMP_REFERRALACTIVITY_PAGE_VERIFY_MSSG);
			TestNGUtils.reportLog(logger,"Referral send successfully.. \n Success Message: "+textMssg+ " \n Email: "+email);
			String referedBy = " referred by ";
			if (!TestDataServices.getTestDataValue(testData, "loginMembershipID").contains("MP##NA")) {
				referedBy = referedBy.concat(TestDataServices.getTestDataValue(testData, "loginMembershipID"));
			}
			else if (!TestDataServices.getTestDataValue(testData, "loginEmail").contains("MP##NA")) {
				referedBy = referedBy.concat(TestDataServices.getTestDataValue(testData, "loginEmail"));
			}
			String dataToPrint =  getCurrentDateWithTimeStamp()+" ####  emailId: "+email+ referedBy;
			writeToFile(logger,"userreferralmail", dataToPrint );
		}
		return verifySuccessMssg;
	}

	

	
	
}
