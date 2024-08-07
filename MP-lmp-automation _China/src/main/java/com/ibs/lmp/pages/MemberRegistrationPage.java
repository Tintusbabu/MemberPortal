package com.ibs.lmp.pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.model.TestData;
import com.ibs.services.TestDataServices;

import com.ibs.utils.TestNGUtils;

import com.ibs.utils.XPATH;

/**
 * This page handles the functionalities in member registration page
 * 
 * @author A-4641
 * 
 * 
 * Revision History
 * 
 * Revision Date         Author Description
 * 0.1      15-June-2023 A-4641 Created
 *  
 */
public class MemberRegistrationPage extends CommonUtility {

	/**
	 * XPATH - Locators of elements in the page
	 */
	/*public static XPATH LMP_LOGIN_PAGE_JOIN_BUTTON = new XPATH("lmp-login-page-join-button",readXpathStringFromPropertyFile("XPATH_LMP_LOGIN_PAGE_JOIN_BUTTON"));
	public static XPATH LMP_REGISTRATION_PAGE_JAPANESELASTNAME_TEXTBOX = new XPATH("lmp-login-page-japaneaseLastName-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_JAPANESELASTNAME_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_JAPANESEFIRSTNAME_TEXTBOX = new XPATH("lmp-login-page-japaneaseFirstName-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_JAPANESEFIRSTNAME_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_KATAKANALASTNAME_TEXTBOX = new XPATH("lmp-login-page-lastNameInKatakana-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_KATAKANALASTNAME_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_KATAKANAFIRSTNAME_TEXTBOX = new XPATH("lmp-login-page-firstNameInKatakana-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_KATAKANAFIRSTNAME_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_ENGLISHFIRSTNAME_TEXTBOX = new XPATH("lmp-login-page-firstNameInEnglish-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_ENGLISHFIRSTNAME_TEXTBOX"));

	public static XPATH LMP_REGISTRATION_PAGE_MEMBERNATIONALITY_DROPDOWN = new XPATH("lmp-login-page-memberNationality-dropDown",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_MEMBERNATIONALITY_DROPDOWN"));
	public static XPATH LMP_REGISTRATION_PAGE_COUNTRYOFRESIDENCE_DROPDOWN = new XPATH("lmp-login-page-countryOfResidence-dropDown",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_COUNTRYOFRESIDENCE_DROPDOWN"));
	public static XPATH LMP_REGISTRATION_PAGE_DATEOFBIRTH_TEXTBOX = new XPATH("lmp-login-page-dateOfBirth-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_DATEOFBIRTH_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_GENDER_DROPDOWN = new XPATH("lmp-login-page-gender-dropDown",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_GENDER_DROPDOWN"));
	public static XPATH LMP_REGISTRATION_PAGE_EMAILADDRESS_TEXTBOX = new XPATH("lmp-login-page-emailAddress-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_EMAILADDRESS_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_MOBILENUMBER_TEXTBOX = new XPATH("lmp-login-page-mobileNumber-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_MOBILENUMBER_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_ZIP_TEXTBOX = new XPATH("lmp-login-page-zip-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_ZIP_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_PREFECTURE_DROPDOWN = new XPATH("lmp-login-page-prefecture-dropDown",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_PREFECTURE_DROPDOWN"));
	public static XPATH LMP_REGISTRATION_PAGE_MUNICIPALITY_TEXTBOX = new XPATH("lmp-login-page-muncipality-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_MUNICIPALITY_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_STREETADDRESS_TEXTBOX = new XPATH("lmp-login-page-streetAddress-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_STREETADDRESS_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_BUILDINGNO_TEXTBOX = new XPATH("lmp-login-page-building-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_BUILDINGNO_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_PHONENUMBER_TEXTBOX = new XPATH("lmp-login-page-phoneNumber-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_PHONENUMBER_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_TERMSANDCONDITION_TEXTBOX = new XPATH("lmp-login-page-termsAndConditions-checkbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_TERMSANDCONDITION_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_JOINNOW_BUTTON = new XPATH("lmp-login-page-joinNow-button",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_JOINNOW_BUTTON"));

*/
	public static XPATH LMP_REGISTRATION_PAGE_SUCCESS_MSSG = new XPATH("lmp-login-page-registerSuccess-message",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_SUCCESS_MSSG"));
	public static XPATH LMP_REGISTRATION_PAGE_LASTNAME_TEXTBOX = new XPATH("lmp-registration-page-lastName-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_LASTNAME_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_FIRSTNAME_TEXTBOX = new XPATH("lmp-registration-page-firstName-textbox", readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_FIRSTNAME_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_MEMBERNATIONALITY_DROPDOWN = new XPATH("lmp-registration-page-page-memberNationality-dropDown",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_MEMBERNATIONALITY_DROPDOWN"));
	public static XPATH LMP_REGISTRATION_PAGE_COUNTRYOFRESIDENCE_DROPDOWN = new XPATH("lmp-registration-page-page-countryOfResidence-dropDown",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_COUNTRYOFRESIDENCE_DROPDOWN"));
	public static XPATH LMP_REGISTRATION_PAGE_LANGUE_SELECT= new XPATH("lmp-registration-page-page-langue_select-dropDown",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_LANGUE_SELECT"));
	public static XPATH LMP_REGISTRATION_PAGE_DATEOFBIRTH_TEXTBOX = new XPATH("lmp-registration-page-page-dateOfBirth-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_DATEOFBIRTH_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_GENDER_DROPDOWN = new XPATH("lmp-registration-page-page-gender-dropDown",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_GENDER_DROPDOWN"));
	public static XPATH LMP_REGISTRATION_PAGE_EMAILADDRESS_TEXTBOX = new XPATH("lmp-registration-page-page-emailAddress-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_EMAILADDRESS_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_MOBILENUMBER_TEXTBOX = new XPATH("lmp-registration-page-page-mobileNumber-textbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_MOBILENUMBER_TEXTBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_AGREEALL_CHKBOX = new XPATH("lmp-registration-page-page-agreeall-chkbox",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_AGREEALL_CHKBOX"));
	public static XPATH LMP_REGISTRATION_PAGE_JOINNOW_BUTTON = new XPATH("lmp-login-page-joinNow-button",readXpathStringFromPropertyFile("XPATH_LMP_REGISTRATION_PAGE_JOINNOW_BUTTON"));
	/**
	 * driver
	 */
	private WebDriver driver;

	/**
	 * logger
	 */
	private ExtentTest logger;

	/**
	 * constructor - MemberRegistrationPage
	 *
	 * @param driver
	 * @param logger
	 */
	public MemberRegistrationPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	/**
	 * Handles the member registration
	 *
	 * @param testData
	 * @return
	 * @throws Exception
	 */
	public boolean registerMember(TestData testData) throws Exception {
		// RTTYTY

		// Enter FirstName
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_FIRSTNAME_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "FirstName"));
		System.out.println("FirstName="+TestDataServices.getTestDataValue(testData, "FirstName"));
		//Enter last Name
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_LASTNAME_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "LastName"));
		// Enter PersonalInfoMemberNationality
		selectValueFromDropdownWithNullCheck(driver, LMP_REGISTRATION_PAGE_MEMBERNATIONALITY_DROPDOWN,
				TestDataServices.getTestDataValue(testData, "Nationality"));
		// Enter PersonalInfoCountryOfResidence
		selectValueFromDropdownWithNullCheck(driver, LMP_REGISTRATION_PAGE_COUNTRYOFRESIDENCE_DROPDOWN,
		TestDataServices.getTestDataValue(testData, "CountryOfResidence"));
        //Enter Langue Select
		selectValueFromDropdownWithNullCheck(driver, LMP_REGISTRATION_PAGE_LANGUE_SELECT,
				TestDataServices.getTestDataValue(testData, "Language"));
		// Enter DateOfBirth
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_DATEOFBIRTH_TEXTBOX,
				getRandomPastDate());
		// Enter Gender
		selectValueFromDropdownWithNullCheck(driver, LMP_REGISTRATION_PAGE_GENDER_DROPDOWN,
				TestDataServices.getTestDataValue(testData, "Gender"));
		// Enter EmailAddress
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_EMAILADDRESS_TEXTBOX,
				getRandomAlphaNumberString()+"@gmail.com");
        // Enter MobileNumber
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_MOBILENUMBER_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "MobileNumber"));
		//Select the Agree ALL checkbox
		clickElementJSIfExists(driver,LMP_REGISTRATION_PAGE_AGREEALL_CHKBOX);
		// Click login button
		clickElementJSIfExists(driver, LMP_REGISTRATION_PAGE_JOINNOW_BUTTON);
		//clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_ENGLISHLASTNAME_TEXTBOX,
			//	getRandomAlphaString());

		/*
		// Enter FirstNameInEnglish
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_ENGLISHFIRSTNAME_TEXTBOX,
				getRandomAlphaString());
		// Enter password
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_ENGLISHLASTNAME_TEXTBOX,
				getRandomAlphaString());
		// Enter PersonalInfoMemberNationality
		selectValueFromDropdownWithNullCheck(driver, LMP_REGISTRATION_PAGE_MEMBERNATIONALITY_DROPDOWN,
				TestDataServices.getTestDataValue(testData, "PersonalInfoMemberNationality"));	
		//ERROR-4641 - disabled needs to check
		// Enter PersonalInfoCountryOfResidence
	  //	selectValueFromDropdownWithNullCheck(driver, LMP_REGISTRATION_PAGE_COUNTRYOFRESIDENCE_DROPDOWN,
			//	TestDataServices.getTestDataValue(testData, "PersonalInfoCountryOfResidence"));
		// Enter DateOfBirth
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_DATEOFBIRTH_TEXTBOX,
				getRandomPastDate());
		// Enter PersonalInfoGender
		selectValueFromDropdownWithNullCheck(driver, LMP_REGISTRATION_PAGE_GENDER_DROPDOWN,
				TestDataServices.getTestDataValue(testData, "PersonalInfoGender"));
		// Enter EmailAddress
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_EMAILADDRESS_TEXTBOX,
				getRandomAlphaNumberString()+"@gmail.com");
		// Enter MobileNumber
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_MOBILENUMBER_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "MobileNumber"));
		// Enter ContactInfoZip
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_ZIP_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "ContactInfoZip"));
		// Enter ContactInfoPrefecture
		selectValueFromDropdownWithNullCheck(driver, LMP_REGISTRATION_PAGE_PREFECTURE_DROPDOWN,
				TestDataServices.getTestDataValue(testData, "ContactInfoPrefecture"));
		// Enter ContactInfoMuncipality
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_MUNICIPALITY_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "ContactInfoMuncipality"));
		// Enter ContactInfoStreetAddress
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_STREETADDRESS_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "ContactInfoStreetAddress"));
		// Enter ContactInfoBuilding
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_BUILDINGNO_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "ContactInfoBuilding"));
		// Enter ContactInfoPhoneNumber
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_PHONENUMBER_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "ContactInfoPhoneNumber"));
		// Enter username
		clickElementJSIfExists(driver, LMP_REGISTRATION_PAGE_TERMSANDCONDITION_TEXTBOX);
		//For writing to file for reference
		String firstName = getAttributeValue(driver, LMP_REGISTRATION_PAGE_ENGLISHFIRSTNAME_TEXTBOX);
		String lastName = getAttributeValue(driver, LMP_REGISTRATION_PAGE_ENGLISHLASTNAME_TEXTBOX);
		String email = getAttributeValue(driver, LMP_REGISTRATION_PAGE_EMAILADDRESS_TEXTBOX);
		// Enter JapaneaseLastName
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_JAPANESELASTNAME_TEXTBOX,
				getRandomAlphaString());
		// Enter JapaneaseFirstName
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_JAPANESEFIRSTNAME_TEXTBOX,
				getRandomAlphaString());
		// Enter LastNameInKatakana
		clearTextAndEnterValueWithNullCheck(driver, LMP_REGISTRATION_PAGE_KATAKANALASTNAME_TEXTBOX,
				TestDataServices.getTestDataValue(testData, "LastNameInKatakana"));
		// Click login button
		clickElementJSIfExists(driver, LMP_REGISTRATION_PAGE_JOINNOW_BUTTON);
		*/
		TestNGUtils.reportLog(logger,"Entered all details");
		boolean registerSuccessMssg = isWebElementVisible(driver, LMP_REGISTRATION_PAGE_SUCCESS_MSSG);
		if (registerSuccessMssg) {
			if (!TestDataServices.getTestDataValue(testData, "Validation_MssgRegisterSucess")
					.equals(getText(driver, LMP_REGISTRATION_PAGE_SUCCESS_MSSG))) {
				throw new RuntimeException(
						LMP_REGISTRATION_PAGE_SUCCESS_MSSG.getelementName() + " not visible in the page.");
			} else {
				
				TestNGUtils.reportLog(logger,"Member enrolled successfully");
				String dataToPrint =  getCurrentDateWithTimeStamp()+" ####  First Name: "  ;
				
				writeToFile(logger,"userenrollment", dataToPrint);
				return true;
			}
		}
		else {
			throw new RuntimeException(
					LMP_REGISTRATION_PAGE_SUCCESS_MSSG.getelementName() + " not visible in the page.");

		}
		
		// www.gmail.com//gfhags%^#$^(FYUKFHJFHJHGJKGJK 
		
	}



	}
