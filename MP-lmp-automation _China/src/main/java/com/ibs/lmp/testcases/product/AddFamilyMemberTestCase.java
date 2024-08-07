package com.ibs.lmp.testcases.product;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.lmp.pages.AddFamilyMemberPage;
import com.ibs.lmp.pages.HomePage;
import com.ibs.lmp.pages.LandingPage;
import com.ibs.lmp.pages.MyWalletPage;
import com.ibs.model.TestData;
import com.ibs.utils.ExtentReportUtils;
import com.ibs.utils.TestInitializeUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class AddFamilyMemberTestCase  extends ExtentReportUtils {


    /**
     * Product_TC_006 - Add Family Member Page
     * @throws Exception
     */
    @Test(groups={"Product_TestCases"})
    public void Product_TC_008() throws Exception{
        String testCaseName = new Exception().getStackTrace()[0].getMethodName();
        //Driver initialization
        TestInitializeUtils testStart= new TestInitializeUtils();
        //Create test in Extent Report
        ExtentTest loggerRoot = extentReports.createTest(testCaseName);
        ExtentTest logger = loggerRoot;
        WebDriver driver = null;
        LandingPage landingPage= null;
        HomePage homePage = null;
        AddFamilyMemberPage addFamilyMemberPage = null;
        try{
            List<TestData> testDataList = CommonUtility.getTestDataListForTestCase("Sample", testCaseName);
            for(TestData testData: testDataList) {
                if(testCaseName.equals(testData.getTestCaseName())) {
                    driver=testStart.initializeDriver();
                    logger = loggerRoot.createNode("Landing Page");
                    landingPage=new LandingPage(driver,logger);
                    landingPage.login(testData);
                    logger = loggerRoot.createNode("Home Page");
                    homePage = new HomePage(driver, logger);
                    homePage.verifyWelcomeMssg();
                    homePage.selectSubMenu("My Family","Add Family Member");
                    logger = loggerRoot.createNode("Add Family Member");
                    addFamilyMemberPage= new AddFamilyMemberPage(driver, logger);
                    addFamilyMemberPage.verifyAddFamilyMemberPage();
                    addFamilyMemberPage.enterMemberShipNumber(testData);
                    addFamilyMemberPage.enterMemberShipFirstName(testData);
                    addFamilyMemberPage.selectRelationship();
                    addFamilyMemberPage.clickOnCheckMembership();
                    //ERROR-4641
                    //currently redirecting to japanense site
					/*homePage.logout(testData);
					boolean isLogout = landingPage.verifyLandingPage();
					if(!isLogout) {
						throw new Exception("Application not logged out successfully");
					}
					*/
                    testStart.closeDriver(driver);
                    TestInitializeUtils.onTestPass(logger, testCaseName);
                }
            }
        }
        catch(Exception e){
            logger.log(Status.FAIL, MarkupHelper.createLabel(e.getMessage(), ExtentColor.RED));
            TestInitializeUtils.onTestFailureScreenshot(driver, logger,testCaseName,e);
            testStart.closeDriver(driver);
            org.testng.Assert.fail(e.getMessage());
        }
    }


}
