package com.ibs.lmp.pages;


import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.model.TestData;
import com.ibs.services.TestDataServices;
import com.ibs.utils.TestNGUtils;

import com.ibs.utils.XPATH;

/**
 * This page handles the functionalities in home page
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
public class UserActivationPage extends CommonUtility {
	
	/**
	 * XPATH - Locators of elements in the page
	 */
	public static XPATH LMP_USERACTIVATION_PAGE_VERIFY_LABEL = new XPATH("lmp-useractivation-page-verify-label",readXpathStringFromPropertyFile("XPATH_LMP_USERACTIVATION_PAGE_VERIFY_LABEL"));
	public static XPATH LMP_USERACTIVATION_PAGE_PASSWORD_INPUT = new XPATH("lmp-useractivation-page-profile-pic-label",readXpathStringFromPropertyFile("XPATH_LMP_USERACTIVATION_PAGE_PASSWORD_INPUT"));
	public static XPATH LMP_USERACTIVATION_PAGE_CONFIRMPASSWORD_INPUT = new XPATH("lmp-useractivation-page-confirmpassword-input",readXpathStringFromPropertyFile("XPATH_LMP_USERACTIVATION_PAGE_CONFIRMPASSWORD_INPUT"));
	public static XPATH LMP_USERACTIVATION_PAGE_ACTIVATION_BUTTON = new XPATH("lmp-useractivation-page-activation-button",readXpathStringFromPropertyFile("XPATH_LMP_USERACTIVATION_PAGE_ACTIVATION_BUTTON"));
	public static XPATH LMP_USERACTIVATION_PAGE_ACTIVATION_MSSG =  new XPATH("lmp-useractivation-page-activation-mssg",readXpathStringFromPropertyFile("XPATH_LMP_USERACTIVATION_PAGE_ACTIVATION_MSSG")); 
	
	public static XPATH LMP_USERACTIVATION_PAGE_MEMBERSHIPNUMBER_LABEL =  new XPATH("lmp-useractivation-page-membership-label",readXpathStringFromPropertyFile("XPATH_LMP_USERACTIVATION_PAGE_MEMBERSHIPNUMBER_LABEL")); 
	
	/**
	 * driver
	 */
	private WebDriver driver ;
	
	/**
	 * logger
	 */
	private ExtentTest logger;

	/**
	 * constructor - HomePage
	 * @param driver
	 * @param logger
	 */
	public UserActivationPage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}

	/**
	 * verifyWelcomeMssg
	 * @return
	 */
	public boolean verifyActivationPageLoad() throws Exception {
		boolean verifyActivationPageLoad =isWebElementVisible(driver, LMP_USERACTIVATION_PAGE_VERIFY_LABEL);
		if(!verifyActivationPageLoad) {
			throw new RuntimeException(LMP_USERACTIVATION_PAGE_VERIFY_LABEL.getelementName()+" not visible in the page.");
		}
		else {
			TestNGUtils.reportLog(logger,"Verified the activation page load");

		}
		return verifyActivationPageLoad;
	}
	
	/**
	 * logout
	 * @param testData
	 */
	public boolean setPassword(TestData testData) throws Exception {
		clearTextAndEnterValueWithNullCheck(driver, LMP_USERACTIVATION_PAGE_PASSWORD_INPUT, TestDataServices.getTestDataValue(testData, "loginPassword"));
		clearTextAndEnterValueWithNullCheck(driver, LMP_USERACTIVATION_PAGE_CONFIRMPASSWORD_INPUT,TestDataServices.getTestDataValue(testData, "loginPassword"));
		String password = getAttributeValue(driver, LMP_USERACTIVATION_PAGE_PASSWORD_INPUT);
		clickElementJSIfExists(driver, LMP_USERACTIVATION_PAGE_ACTIVATION_BUTTON);
		boolean verifyActivationMssg =isWebElementVisible(driver, LMP_USERACTIVATION_PAGE_ACTIVATION_MSSG);
		if(!verifyActivationMssg) {
			throw new RuntimeException(LMP_USERACTIVATION_PAGE_ACTIVATION_MSSG.getelementName()+" not visible in the page.");
		}
		else {
			TestNGUtils.reportLog(logger,"Verified the activation message");
			
			String membershipIDStr = 	getText(driver, LMP_USERACTIVATION_PAGE_MEMBERSHIPNUMBER_LABEL);
			String[] memArr = membershipIDStr.split(":");
			String membershipID =null;
			if(memArr!= null && memArr.length>=2) {
				membershipID = memArr[1].trim();
			}
			String dataToPrint =  getCurrentDateWithTimeStamp()+" ####  MembershipID: "+membershipID +" Password:"+ password;
			
			writeToFile(logger,"useractivation", dataToPrint);

		}
		return verifyActivationMssg;

	}
	
	

	

}
