package com.ibs.lmp.pages;

import com.ibs.lmp.common.CommonUtility;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.utils.SeleniumUtils;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.TrippleDes;
import com.ibs.utils.XPATH;

public class LoginPage extends CommonUtility {
	
	public static XPATH LMP_LOGIN_PAGE_USERNAME_TEXTBOX = new XPATH("lmp-login-page-username-textbox","//input[@name='username']");
	public static XPATH LMP_LOGIN_PAGE_PASSWORD_TEXTBOX = new XPATH("lmp-login-page-password-textbox","//input[@name='j_password']");
	public static XPATH LMP_LOGIN_PAGE_LOGIN_BUTTON = new XPATH("lmp-login-page-login-button","//input[@class='login_button']");
	
	/**
	 * driver
	 */
	private WebDriver driver ;
	
	/**
	 * logger
	 */
	private ExtentTest logger;

	/**
	 * LoginPage - constructor
	 * @param driver
	 * @param logger
	 */
	public LoginPage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}

	public LoginPage validateLMPLoginPage(){

		TestNGUtils.reportLog(logger,"Validate LMP Login Page");
		SeleniumUtils.waitForElement(driver, LMP_LOGIN_PAGE_USERNAME_TEXTBOX);
		SeleniumUtils.waitForElement(driver, LMP_LOGIN_PAGE_PASSWORD_TEXTBOX);
		return this;
	}
	//Description	: Login to LMP application
	public LoginPage loginLMP(String username,String encryptedPassword){


		TestNGUtils.reportLog(logger,"Login to LMP application");
		TestNGUtils.reportLog(logger,"Username: "+username);
		//decrypting the password
		String password = TrippleDes.getInstance().decrypt(encryptedPassword);
		//Enter username 
		SeleniumUtils.clearTextAndEnterValue(driver, LMP_LOGIN_PAGE_USERNAME_TEXTBOX, username);
		//Enter password
		SeleniumUtils.clearTextAndEnterValue(driver, LMP_LOGIN_PAGE_PASSWORD_TEXTBOX, password);
	
		//SeleniumUtils.waitForElement(driver, LMP_LOGIN_PAGE_CAPTCHA_CHKBOX);

		//Click login button
		SeleniumUtils.clickElement(driver, LMP_LOGIN_PAGE_LOGIN_BUTTON);
		return this;
	}

}
