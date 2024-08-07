package com.ibs.lmp.pages;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.services.TestDataServices;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;
import com.ibs.model.TestData;
import org.openqa.selenium.WebDriver;

public class AddFamilyMemberPage  extends CommonUtility {
    /**
     * XPATH - Locators of elements in the page
     */
    public static XPATH LMP_ADDFAMILYMEMEBER_PAGE_VERIFY_MSSG = new XPATH("lmp-addfamilymember-page-verify-label",readXpathStringFromPropertyFile("XPATH_LMP_ADDFAMILYMEMEBER_PAGE_VERIFY_MSSG"));
    public static XPATH LMP_ADDFAMILYMEMEBER_PAGE_MEMBERSHIPNUMBER_INPUT = new XPATH("lmp-addfamilymember-page-membershipnumber-input",readXpathStringFromPropertyFile("XPATH_LMP_ADDFAMILYMEMEBER_PAGE_MEMBERSHIPNUMBER_INPUT"));
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
    public AddFamilyMemberPage(WebDriver driver,ExtentTest logger) {
        this.driver=driver;
        this.logger=logger;
    }

    /**
     * verifyWelcomeMssg
     * @return
     */
    public boolean verifyAddFamilyMemberPage() throws Exception {
        boolean verifyAddFamilyMemberPage =isWebElementVisible(driver, LMP_ADDFAMILYMEMEBER_PAGE_VERIFY_MSSG );
        if(!verifyAddFamilyMemberPage) {
            throw new RuntimeException( LMP_ADDFAMILYMEMEBER_PAGE_VERIFY_MSSG .getelementName()+" not visible in the page.");
        }
        else {
            TestNGUtils.reportLog(logger,"Verified the Add Family Member page");

        }
        return verifyAddFamilyMemberPage;
    }
    public void enterMemberShipNumber(TestData testData) throws Exception {
        boolean verifyWelcomeMssg =isWebElementVisible(driver,  LMP_ADDFAMILYMEMEBER_PAGE_MEMBERSHIPNUMBER_INPUT  );
        if(!verifyWelcomeMssg) {
            throw new RuntimeException( LMP_ADDFAMILYMEMEBER_PAGE_MEMBERSHIPNUMBER_INPUT .getelementName()+" not visible in the page.");
        }
        else {
           clearTextAndEnterValue(driver,LMP_ADDFAMILYMEMEBER_PAGE_MEMBERSHIPNUMBER_INPUT, TestDataServices.getTestDataValue(testData, "AddFamilyMemberNumber"));
            TestNGUtils.reportLog(logger,"Enter the membership number as "+TestDataServices.getTestDataValue(testData, "AddFamilyMemberNumber"));
        }

    }
    public void enterMemberShipFirstName(TestData testData) throws Exception {
        boolean verifyWelcomeMssg =isWebElementVisible(driver,  LMP_ADDFAMILYMEMEBER_PAGE_MEMBERSHIPNAME_INPUT  );
        if(!verifyWelcomeMssg) {
            throw new RuntimeException( LMP_ADDFAMILYMEMEBER_PAGE_MEMBERSHIPNAME_INPUT .getelementName()+" not visible in the page.");
        }
        else {
            clearTextAndEnterValue(driver,LMP_ADDFAMILYMEMEBER_PAGE_MEMBERSHIPNAME_INPUT, TestDataServices.getTestDataValue(testData, "AddFamilyMemberFirstName"));
            TestNGUtils.reportLog(logger,"Enter the membership first name as "+TestDataServices.getTestDataValue(testData, "AddFamilyMemberFirstName"));
        }

    }
    public void clickOnCheckMembership() throws Exception {
        boolean verifyCheckButton =isWebElementVisible(driver,  LMP_ADDFAMILYMEMEBER_PAGE_CHECKMEMBERSHIP_BUTTON );
        if(!verifyCheckButton) {
            throw new RuntimeException( LMP_ADDFAMILYMEMEBER_PAGE_CHECKMEMBERSHIP_BUTTON .getelementName()+" not visible in the page.");
        }
        else {
            clickElementJSIfExists(driver, LMP_ADDFAMILYMEMEBER_PAGE_CHECKMEMBERSHIP_BUTTON);
            TestNGUtils.reportLog(logger,"Click on the Check button");
        }

    }
    public void selectRelationship() throws Exception {
        boolean verifydropdown =isWebElementVisible(driver,  LMP_ADDFAMILYMEMEBER_PAGE_RELATIONSHIP_DROPDOWN );
        if(!verifydropdown) {
            throw new RuntimeException( LMP_ADDFAMILYMEMEBER_PAGE_RELATIONSHIP_DROPDOWN .getelementName()+" not visible in the page.");
        }
        else {
           selectValueFromDropdown(driver,LMP_ADDFAMILYMEMEBER_PAGE_RELATIONSHIP_DROPDOWN,"Mother");
            TestNGUtils.reportLog(logger,"Selected the dropdown value");
        }

    }
}
