package com.ibs.lmp.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;
import org.openqa.selenium.WebDriver;
/**
        * This page handles the functionalities in MyWalletPage
        *
        *
        *
        *
        * Revision History
        *
        * Revision Date         Author Description
        *
        *
        */

public class MyWalletPage extends CommonUtility {

    /**
     * XPATH - Locators of elements in the page
     */
    public static XPATH LMP_MYWALLET_PAGE_VERIFY_MSSG = new XPATH("lmp-memberprofile-page-verify-label",readXpathStringFromPropertyFile("XPATH_LMP_MYWALLET_PAGE_VERIFY_MSSG"));


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
    public MyWalletPage(WebDriver driver,ExtentTest logger) {
        this.driver=driver;
        this.logger=logger;
    }

    /**
     * This handles the title is visible in My Activity page
     * @return
     */
    public boolean verifyMyWalletPageTitle() throws Exception{
        boolean verifyTitleMssg =isWebElementVisible(driver, LMP_MYWALLET_PAGE_VERIFY_MSSG);

        if(!verifyTitleMssg) {
            throw new RuntimeException(LMP_MYWALLET_PAGE_VERIFY_MSSG.getelementName()+" not visible in the page.");
        }else {
            TestNGUtils.reportLog(logger,"Verified the My Activity screen loading");

        }
        return verifyTitleMssg;
    }
}
