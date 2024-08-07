package com.ibs.lmp.testcases.product;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.lmp.pages.*;
import com.ibs.model.TestData;
import com.ibs.utils.ExtentReportUtils;
import com.ibs.utils.TestInitializeUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TransferPointsTestCase extends ExtentReportUtils {


    /**
     * Product_TC_008 - Transfer points
     * @throws Exception
     */
    @Test(groups={"Product_TestCases"})
    public void Product_TC_008() throws Exception{
        String testCaseName = new Exception().getStackTrace()[0].getMethodName();
        TestInitializeUtils testStart= new TestInitializeUtils();
        WebDriver driver=null;
        ExtentTest loggerRoot = extentReports.createTest(testCaseName);
        ExtentTest logger = loggerRoot;
        LandingPage landingPage= null;
        HomePage homePage = null;
        TransferPointsPage transferPointsPage = null;
        try{
            List<TestData> testDataList = CommonUtility.getTestDataListForTestCase("Sample", testCaseName);
            //int i=1;
            for(TestData testData: testDataList) {
                driver=testStart.initializeDriver();
                logger = loggerRoot.createNode("Landing Page");
                landingPage=new LandingPage(driver,logger);
                landingPage.login(testData);
                logger = loggerRoot.createNode("Home Page");
                homePage = new HomePage(driver, logger);
                homePage.verifyWelcomeMssg();
                homePage.selectSubMenu("My Points","Transfer Points");
                logger = loggerRoot.createNode("Transfer Points ");
                transferPointsPage= new TransferPointsPage(driver, logger);

                transferPointsPage.verifyTransferPointsTitle();


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
