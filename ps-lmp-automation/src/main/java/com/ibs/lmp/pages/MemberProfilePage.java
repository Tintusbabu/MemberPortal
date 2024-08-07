package com.ibs.lmp.pages;


import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.model.TestData;
import com.ibs.services.TestDataServices;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;

/**
 * This page handles the functionalities in member profile page
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
public class MemberProfilePage extends CommonUtility {
	
	/**
	 * XPATH - Locators of elements in the page
	 */
	public static XPATH LMP_MEMBERPROFILE_PAGE_VERIFY_MSSG = new XPATH("lmp-memberprofile-page-verify-label",readXpathStringFromPropertyFile("XPATH_LMP_MEMBERPROFILE_PAGE_VERIFY_MSSG"));
	public static XPATH LMP_MEMBERPROFILE_PAGE_MOBILENUMBER_TEXTBOX = new XPATH("lmp-memberprofile-page-title-label",readXpathStringFromPropertyFile("XPATH_LMP_MEMBERPROFILE_PAGE_MOBILENUMBER_TEXTBOX"));
	public static XPATH LMP_MEMBERPROFILE_PAGE_UPDATEPROFILE_BUTTON = new XPATH("lmp-memberprofile-page-updateprofile-button",readXpathStringFromPropertyFile("XPATH_LMP_MEMBERPROFILE_PAGE_UPDATEPROFILE_BUTTON"));
	public static XPATH LMP_MEMBERPROFILE_PAGE_UPDATEPROFILE_MSSG = new XPATH("lmp-memberprofile-page-updateprofile-mssg",readXpathStringFromPropertyFile("XPATH_LMP_MEMBERPROFILE_PAGE_UPDATEPROFILE_MSSG"));

	/**
	 * driver
	 */
	private WebDriver driver ;
	
	/**
	 * logger
	 */
	private ExtentTest logger;

	/**
	 * constructor - MemberProfilePage
	 * @param driver
	 * @param logger
	 */
	public MemberProfilePage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}

	/**
	 * This handles the title is visible in profile page
	 * @return
	 */
	public boolean verifyProfileTitle() throws Exception{
		boolean verifyTitleMssg =isWebElementVisible(driver, LMP_MEMBERPROFILE_PAGE_VERIFY_MSSG);
		
		if(!verifyTitleMssg) {
			throw new RuntimeException(LMP_MEMBERPROFILE_PAGE_VERIFY_MSSG.getelementName()+" not visible in the page.");
		}else {
			TestNGUtils.reportLog(logger,"Verified the profile screen loading");

		}
		return verifyTitleMssg;
	}

	/**
	 * This handles the update of member profile.
	 * Updation of latest promotion checkbox
	 * @return
	 */
	public boolean updateProfile(TestData testData) throws Exception {
		// Enter MobileNumber
		clearText(driver, LMP_MEMBERPROFILE_PAGE_MOBILENUMBER_TEXTBOX);
				clearTextAndEnterValueWithNullCheck(driver, LMP_MEMBERPROFILE_PAGE_MOBILENUMBER_TEXTBOX,
						TestDataServices.getTestDataValue(testData, "MobileNumber"));
		clickElementJSIfExists(driver,LMP_MEMBERPROFILE_PAGE_UPDATEPROFILE_BUTTON);
		
		boolean verifyUpdateMssg =isWebElementVisible(driver, LMP_MEMBERPROFILE_PAGE_UPDATEPROFILE_MSSG);
		
		if(!verifyUpdateMssg) {
			throw new RuntimeException(LMP_MEMBERPROFILE_PAGE_UPDATEPROFILE_MSSG.getelementName()+" not visible in the page.");
		}else {
			TestNGUtils.reportLog(logger,"Verified the profile screen updation");

		}
		return verifyUpdateMssg;	
	}
	
}
