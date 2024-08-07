package com.ibs.lmp.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;
import org.openqa.selenium.WebDriver;

/**
 * This page handles the functionalities of Transfer Points  page
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
public class TransferPointsPage extends CommonUtility {
    /**
     * XPATH - Locators of elements in the page
     */
    public static XPATH LMP_TRANSFERPOINTS_PAGE_VERIFY_MSSG  = new XPATH("lmp-transferpoints-page-verify-label",readXpathStringFromPropertyFile("XPATH_LMP_TRANSFERPOINTS_PAGE_VERIFY_MSSG"));
   // XPATH_LMP_TRANSFERPOINTS_PAGE_VERIFY_MSSG"
    //public static XPATH LMP_MYACTIVITY_PAGE_COLUMNLABELS_TABLE = new XPATH("lmp-myactivity-page-column-label",readXpathStringFromPropertyFile("XPATH_LMP_MYACTIVITY_PAGE_COLUMNLABELS_TABLE"));

    /**
     * driver
     */
    private WebDriver driver ;

    /**
     * logger
     */
    private ExtentTest logger;

    /**
     * constructor - TransferPointsPage
     * @param driver
     * @param logger
     */
    public TransferPointsPage(WebDriver driver,ExtentTest logger) {
        this.driver=driver;
        this.logger=logger;
    }

    /**
     * This handles the title is visible in Transfer Points page
     * @return
     */
    public boolean verifyTransferPointsTitle() throws Exception{
       // waitForElement(driver,LMP_TRANSFERPOINTS_PAGE_VERIFY_MSSG,5000);
        boolean verifyTitleMssg =isWebElementVisible(driver, LMP_TRANSFERPOINTS_PAGE_VERIFY_MSSG);

        if(!verifyTitleMssg) {
            throw new RuntimeException(LMP_TRANSFERPOINTS_PAGE_VERIFY_MSSG.getelementName()+" not visible in the page.");
        }else {
            TestNGUtils.reportLog(logger,"Verified the Transfer points screen loading");

        }
        return verifyTitleMssg;
    }


}
