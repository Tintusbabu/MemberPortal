package com.ibs.lmp.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.model.TestData;
import com.ibs.services.TestDataServices;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ClaimSummaryPage  extends CommonUtility {


    /**
     * XPATH - Locators of elements in the page
     */
    public static XPATH LMP_CLAIMSUMMARY_PAGE_VERIFY_MESS  = new XPATH("lmp-claimsummary-page-verify-label",readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUMMARY_PAGE_VERIFY_MESS"));
    public static XPATH LMP_CLAIMSUMMARY_PAGE_COLUMNLABELS_TABLE =  new XPATH("lmp-claimsummary-page-columnheader-table",readXpathStringFromPropertyFile("XPATH_LMP_CLAIMSUMMAR_PAGE_COLUMNLABELS_TABLE"));
    public static XPATH LMP_ADDFAMILYMEMEBER_PAGE_MEMBERSHIPNAME_INPUT = new XPATH("lmp-addfamilymember-page-membershipgivenname-input",readXpathStringFromPropertyFile("XPATH_LMP_ADDFAMILYMEMEBER_PAGE_MEMBERSHIPNAME_INPUT"));
    public static XPATH LMP_ADDFAMILYMEMEBER_PAGE_CHECKMEMBERSHIP_BUTTON  = new XPATH("lmp-addfamilymember-page-check-button",readXpathStringFromPropertyFile("XPATH_LMP_ADDFAMILYMEMEBER_PAGE_CHECKMEMBERSHIP_BUTTON"));
    public static XPATH LMP_ADDFAMILYMEMEBER_PAGE_RELATIONSHIP_DROPDOWN  = new XPATH("lmp-addfamilymember-page-relationship-dropdown", readXpathStringFromPropertyFile("XPATH_LMP_ADDFAMILYMEMEBER_PAGE_RELATIONSHIP_DROPDOWN"));
    /**
     * driver
     */
    private WebDriver driver ;

    /**
     * logger
     */
    private ExtentTest logger;

    /**
     * constructor - HomePage
     * @param driver
     * @param logger
     */
    public ClaimSummaryPage(WebDriver driver,ExtentTest logger) {
        this.driver=driver;
        this.logger=logger;
    }

    /**
     * verify Claim summary page
     * @return
     */
    public boolean verifyClaimSummaryPage() throws Exception {
        boolean verifyClaimSummaryStatus =isWebElementVisible(driver, LMP_CLAIMSUMMARY_PAGE_VERIFY_MESS );
        if(!verifyClaimSummaryStatus) {
            throw new RuntimeException( LMP_CLAIMSUMMARY_PAGE_VERIFY_MESS .getelementName()+" not visible in the page.");
        }
        else {
            TestNGUtils.reportLog(logger,"Verified the Claim Summary page");

        }
        return verifyClaimSummaryStatus;
    }

    /**
     * This handles the update of member profile.
     * Updation of latest promotion checkbox
     * @return
     */
    public boolean viewAndVerifyClaimSummaryColumns(TestData testData) throws Exception {
        List<String> actualDataList = getTextListFromWebElements(driver, LMP_CLAIMSUMMARY_PAGE_COLUMNLABELS_TABLE);

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
            TestNGUtils.reportLog(logger, "Claim Summary columns matching");

        }
        return allMatch;
    }

}
