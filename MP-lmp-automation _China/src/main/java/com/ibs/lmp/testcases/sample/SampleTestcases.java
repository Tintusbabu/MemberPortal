package com.ibs.lmp.testcases.sample;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.pages.LoginPage;
import com.ibs.model.Environment;
import com.ibs.model.TestData;
import com.ibs.services.EnvironmentServices;
import com.ibs.services.TestDataServices;
import com.ibs.utils.ExtentReportUtils;
import com.ibs.utils.TestInitializeUtils;

public class SampleTestcases extends ExtentReportUtils {

	@Test (groups={"LMP_Regression_Testcases","Sample_Testcases","VA_Specific"})
	public void VA_TC_001() throws Exception{
		System.out.println("***************nimy**********");
		/*
		Test Case		:	Sample_TC_001
		Test Module		:	Sample
		Description    	:	Sample test case for demo purpose
		Author 			:   Sreekanth Vadassery
		Date			:   20230529
		*/
		/*
		Steps Defined:
		Step 1:
		Step 2:
		.....
		*/
		String testCaseName = new Exception().getStackTrace()[0].getMethodName();
		//Driver initialization
		TestInitializeUtils testStart= new TestInitializeUtils();
		WebDriver driver=testStart.initializeDriver();
		//Create test in Extent Report
		ExtentTest loggerRoot = extentReports.createTest(testCaseName);
		ExtentTest logger = loggerRoot;
		try{
			//Fetch the test data from meta data sheet for the test case
			//Argument 1 -> Module name. There should be a work sheet present with exactly the same name in meta data sheet.
			TestData testData = TestDataServices.getTestDataForTestCase("Sample", testCaseName);
			//Fetch Environment data from meta data sheet (Sheet name -> 'Environment')
			Environment environment = EnvironmentServices.getEnvironmentDetails("Environment");
			
			//Test Steps starts
			
			//Sample lines to show the test data service functionality (Should remove this line in actual test case)
			System.out.println(TestDataServices.getTestDataValue(testData,"Attribute 1"));
			System.out.println(TestDataServices.getTestDataValue(testData,"Attribute 2"));
			
			//Login and switch to Home Window
			logger = loggerRoot.createNode("MemberRegistration");
			LoginPage loginPage=new LoginPage(driver,logger);
			loginPage
				.validateLMPLoginPage()  
				.loginLMP(environment.getUsername(),environment.getPassword());
			
			testStart.closeDriver(driver);
			TestInitializeUtils.onTestPass(logger, testCaseName);
		}
		catch(Exception e){
			logger.log(Status.FAIL,MarkupHelper.createLabel(e.getMessage(), ExtentColor.RED));
			TestInitializeUtils.onTestFailureScreenshot(driver, logger,testCaseName,e);
			testStart.closeDriver(driver);
			org.testng.Assert.fail(e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
	
}
