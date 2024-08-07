package com.ibs.lmp.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;
import org.openqa.selenium.WebDriver;

public class PointsCalculatorPage extends CommonUtility {

    /**
     * XPATH - Locators of elements in the page
     */
    public static XPATH LMP_POINTSCALCULATOR_PAGE_VERIFY_MSSG  = new XPATH("lmp-pointscalculator-page-verify-label",readXpathStringFromPropertyFile("XPATH_LMP_POINTSCALCULATOR_PAGE_VERIFY_MSSG"));


    /**
     * driver
     */
    private WebDriver driver ;

    /**
     * logger
     */
    private ExtentTest logger;

    /**
     * constructor - PointsCalculatorPage
     * @param driver
     * @param logger
     */
    public PointsCalculatorPage(WebDriver driver, ExtentTest logger) {
        this.driver=driver;
        this.logger=logger;
    }

    /**
     * This handles the title is visible in My Activity page
     * @return
     */
    public boolean verifyPointsCalculatorPageTitle() throws Exception{
        boolean verifyTitleMssg =isWebElementVisible(driver, LMP_POINTSCALCULATOR_PAGE_VERIFY_MSSG);

        if(!verifyTitleMssg) {
            throw new RuntimeException(LMP_POINTSCALCULATOR_PAGE_VERIFY_MSSG.getelementName()+" not visible in the page.");
        }else {
            TestNGUtils.reportLog(logger,"Verified the Points Calculator Page loading");

        }
        return verifyTitleMssg;
    }
}
