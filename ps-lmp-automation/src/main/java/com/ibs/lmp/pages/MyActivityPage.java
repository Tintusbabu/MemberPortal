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
public class MyActivityPage extends CommonUtility {
	
	/**
	 * XPATH - Locators of elements in the page
	 */
	public static XPATH LMP_MYACTIVITY_PAGE_VERIFY_MSSG = new XPATH("lmp-memberprofile-page-verify-label",readXpathStringFromPropertyFile("XPATH_LMP_MYACTIVITY_PAGE_VERIFY_MSSG"));
	public static XPATH LMP_MYACTIVITY_PAGE_COLUMNLABELS_TABLE = new XPATH("lmp-memberprofile-page-title-label",readXpathStringFromPropertyFile("XPATH_LMP_MYACTIVITY_PAGE_COLUMNLABELS_TABLE"));
	
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
	public MyActivityPage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}

	/**
	 * This handles the title is visible in My Activity page
	 * @return
	 */
	public boolean verifyMyActivityTitle() throws Exception{
		boolean verifyTitleMssg =isWebElementVisible(driver, LMP_MYACTIVITY_PAGE_VERIFY_MSSG);
		
		if(!verifyTitleMssg) {
			throw new RuntimeException(LMP_MYACTIVITY_PAGE_VERIFY_MSSG.getelementName()+" not visible in the page.");
		}else {
			TestNGUtils.reportLog(logger,"Verified the My Activity screen loading");

		}
		return verifyTitleMssg;
	}

	/**
	 * This handles the update of member profile.
	 * Updation of latest promotion checkbox
	 * @return
	 */
	public boolean viewAndVerifyMyActivityColumns(TestData testData) throws Exception {
		List<String> actualDataList = getTextListFromWebElements(driver, LMP_MYACTIVITY_PAGE_COLUMNLABELS_TABLE);

		String expectedCoulmn = TestDataServices.getTestDataValue(testData, "expectedColumnHeaders");
		String[] expectedColumnArr = expectedCoulmn.split("##");
		List<String> expectedDataList = new ArrayList<String>();
		for (String expVal : expectedColumnArr) {
			if (expVal != null && !expVal.isEmpty()) {
				expectedDataList.add(expVal);
			}
		}

		// To check actual data list exist in expected data list
		boolean allMatch = listEqualsIgnoreOrder(actualDataList, expectedDataList);
		//System.err.println("almatch:::::" + allMatch);

		if (!allMatch) {
			throw new RuntimeException("Columns mismatching");
		} else {
			TestNGUtils.reportLog(logger, "My Activity columns matching");

		}
		return allMatch;
	}
	
}
