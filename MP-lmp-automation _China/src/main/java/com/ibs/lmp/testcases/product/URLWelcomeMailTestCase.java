package com.ibs.lmp.testcases.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.lmp.pages.HomePage;
import com.ibs.lmp.pages.LandingPage;
import com.ibs.lmp.pages.UserActivationPage;
import com.ibs.model.TestData;
import com.ibs.services.TestDataServices;
import com.ibs.utils.ExtentReportUtils;
import com.ibs.utils.TestInitializeUtils;

/**
 * Login using membership number and email
 * 
 * @author A-4641
 * 
 * This is the test script to access welcome mail and navigate to the same and record the credentials
 * 
 * Revision History
 * 
 * Revision Date         Author Description
 * 0.1      15-June-2023 A-4641 Created
 *  
 */
public class URLWelcomeMailTestCase extends ExtentReportUtils {

	
	/**
	 * Product_TC_002 - Login using membership number and email
	 * @throws Exception
	 */
	@Test (groups={"Product_TestCases"})
	public void Product_TC_006() throws Exception{
		String testCaseName = new Exception().getStackTrace()[0].getMethodName();
		TestInitializeUtils testStart= new TestInitializeUtils();
		ExtentTest loggerRoot = extentReports.createTest(testCaseName);
		ExtentTest logger = loggerRoot;
		WebDriver driver = null;
		try{
			List<TestData> testDataList = CommonUtility.getTestDataListForTestCase("Sample", testCaseName);
			for(TestData testData: testDataList) {
				if(testCaseName.equals(testData.getTestCaseName())) {
					 driver=testStart.initializeDriver();
					 driver.get(TestDataServices.getTestDataValue(testData, "urlWelcomeMail"));
					
					 
					 
					 logger = loggerRoot.createNode("User Activation"); 
					 UserActivationPage userActivationPage = new UserActivationPage(driver,logger);
					 userActivationPage.verifyActivationPageLoad();
					 userActivationPage.setPassword(testData);
					 
						
					
					testStart.closeDriver(driver);
					TestInitializeUtils.onTestPass(logger, testCaseName);
				}
			}		
		}
		catch(Exception e){
			logger.log(Status.FAIL,MarkupHelper.createLabel(e.getMessage(), ExtentColor.RED));
			TestInitializeUtils.onTestFailureScreenshot(driver, logger,testCaseName,e);
			testStart.closeDriver(driver);
			org.testng.Assert.fail(e.getMessage());
		}
		
	}
	
}
