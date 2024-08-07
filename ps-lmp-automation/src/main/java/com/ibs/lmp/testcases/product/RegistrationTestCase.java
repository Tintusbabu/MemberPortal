package com.ibs.lmp.testcases.product;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.lmp.pages.LandingPage;
import com.ibs.lmp.pages.MemberRegistrationPage;
import com.ibs.model.TestData;
import com.ibs.utils.ExtentReportUtils;
import com.ibs.utils.TestInitializeUtils;

/**
 * Register a new user
 * 
 * @author A-4641
 * 
 * This is the test script to eroll a member
 * 
 * Revision History
 * 
 * Revision Date         Author Description
 * 0.1      15-June-2023 A-4641 Created
 *  
 */
public class RegistrationTestCase extends ExtentReportUtils {

	
	/**
	 * Product_TC_001 - Member Registration
	 * @throws Exception
	 */
	@Test (groups={"Product_TestCases"})
	public void Product_TC_001() throws Exception{
		String testCaseName = new Exception().getStackTrace()[0].getMethodName();
		TestInitializeUtils testStart= new TestInitializeUtils();
		WebDriver driver=null;
		ExtentTest loggerRoot = extentReports.createTest(testCaseName);
		ExtentTest logger = loggerRoot;
		try{
			List<TestData> testDataList = CommonUtility.getTestDataListForTestCase("Sample", testCaseName);
			//int i=1;
			for(TestData testData: testDataList) {
				//logger = loggerRoot.createNode("Data Set: "+ i++);
				
				//TestNGUtils.reportLog(logger,"Verified the home page");
				
				
					driver=testStart.initializeDriver();
					logger = loggerRoot.createNode("Landing Page");
					LandingPage landingPage=new LandingPage(driver,logger);
					landingPage.clickRegister();
					logger = loggerRoot.createNode("Member Enrollment");
					MemberRegistrationPage memberRegistrationPage=new MemberRegistrationPage(driver,logger);
					memberRegistrationPage.registerMember(testData);
					testStart.closeDriver(driver);	
					TestInitializeUtils.onTestPass(logger, testCaseName);
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
