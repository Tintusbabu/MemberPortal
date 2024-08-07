package com.ibs.lmp.pages;


import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;

/**
 * This page handles the functionalities in member preference page
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
public class MemberPreferencePage extends CommonUtility {
	
	/**
	 * XPATH - Locators of elements in the page
	 */
	public static XPATH LMP_MEMBERPREFERENCE_PAGE_VERIFY_MSSG = new XPATH("lmp-memberpreference-page-title-label",readXpathStringFromPropertyFile("XPATH_LMP_MEMBERPREFERENCE_PAGE_VERIFY_MSSG"));
	public static XPATH LMP_MEMBERPREFERENCE_PAGE_LATESTPROMOTION_CHECKBOX = new XPATH("lmp-memberpreference-page-title-label",readXpathStringFromPropertyFile("XPATH_LMP_MEMBERPREFERENCE_PAGE_LATESTPROMOTION_CHECKBOX"));
	public static XPATH LMP_MEMBERPREFERENCE_PAGE_UPDATEPREFERENCE_BUTTON = new XPATH("lmp-memberpreference-page-title-label",readXpathStringFromPropertyFile("XPATH_LMP_MEMBERPREFERENCE_PAGE_UPDATEPREFERENCE_BUTTON"));
	public static XPATH LMP_MEMBERPREFERENCE_PAGE_UPDATEPREFERENCE_MSSG = new XPATH("lmp-memberpreference-page-update-mssg",readXpathStringFromPropertyFile("XPATH_LMP_MEMBERPREFERENCE_PAGE_UPDATEPREFERENCE_MSSG"));
	
	/**
	 * driver
	 */
	private WebDriver driver ;
	
	/**
	 * logger
	 */
	private ExtentTest logger;

	/**
	 * constructor - MemberPreferencePage
	 * @param driver
	 * @param logger
	 */
	public MemberPreferencePage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}

	/**
	 * This handles the title is visible in e-Newsletter
	 * @return
	 */
	public boolean verifyPreferenceTitle() throws Exception{
		boolean verifyTitleMssg =isWebElementVisible(driver, LMP_MEMBERPREFERENCE_PAGE_VERIFY_MSSG);
		
		if(!verifyTitleMssg) {
			throw new RuntimeException(LMP_MEMBERPREFERENCE_PAGE_VERIFY_MSSG.getelementName()+" not visible in the page.");
		}else {
			TestNGUtils.reportLog(logger,"Verified the preference screen loading");

		}
		return verifyTitleMssg;
	}

	/**
	 * This handles the update of member preference.
	 * Updation of latest promotion checkbox
	 * @return
	 */
	public boolean updatePrefernce() throws Exception {
		checkCheckBoxIfNot(driver,LMP_MEMBERPREFERENCE_PAGE_LATESTPROMOTION_CHECKBOX);
		clickElementJSIfExists(driver,LMP_MEMBERPREFERENCE_PAGE_UPDATEPREFERENCE_BUTTON);
		boolean isUpdated = isWebElementVisible(driver, LMP_MEMBERPREFERENCE_PAGE_UPDATEPREFERENCE_MSSG);
		if(!isUpdated) {
			throw new RuntimeException(LMP_MEMBERPREFERENCE_PAGE_UPDATEPREFERENCE_MSSG.getelementName()+" not visible in the page.");
		}else {
			TestNGUtils.reportLog(logger,"Updated the member preference");

		}
		return isUpdated;	
	}
	
}
