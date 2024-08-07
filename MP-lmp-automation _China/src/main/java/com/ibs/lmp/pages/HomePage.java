package com.ibs.lmp.pages;


import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.ibs.lmp.common.CommonUtility;
import com.ibs.model.TestData;
import com.ibs.utils.TestNGUtils;

import com.ibs.utils.XPATH;

/**
 * This page handles the functionalities in home page
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
public class HomePage extends CommonUtility {
	
	/**
	 * XPATH - Locators of elements in the page
	 */
	public static XPATH LMP_HOME_PAGE_WELCOME_LABEL = new XPATH("lmp-home-page-welcome-label",readXpathStringFromPropertyFile("XPATH_LMP_HOME_PAGE_WELCOME_LABEL"));
	public static XPATH LMP_HOME_PAGE_PROFILE_PIC_LABEL = new XPATH("lmp-home-page-profile-pic-label",readXpathStringFromPropertyFile("XPATH_LMP_HOME_PAGE_PROFILE_PIC_LABEL"));
	public static XPATH LMP_HOME_PAGE_LOGOUT_LINK = new XPATH("lmp-home-page-logout-link",readXpathStringFromPropertyFile("XPATH_LMP_HOME_PAGE_LOGOUT_LINK"));
	public static XPATH LMP_HOME_PAGE_MENU_LINK = new XPATH("lmp-home-page-menu-link",readXpathStringFromPropertyFile("XPATH_LMP_HOME_PAGE_MENU_LINK"));
	public static XPATH LMP_HOME_PAGE_SUBMENU_LINK = new XPATH("lmp-home-page-submenu-link",readXpathStringFromPropertyFile("XPATH_LMP_HOME_PAGE_SUBMENU_LINK"));
	
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
	public HomePage(WebDriver driver,ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
	}

	/**
	 * verifyWelcomeMssg
	 * @return
	 */
	public boolean verifyWelcomeMssg() throws Exception {
		boolean verifyWelcomeMssg =isWebElementVisible(driver, LMP_HOME_PAGE_WELCOME_LABEL);
		if(!verifyWelcomeMssg) {
			throw new RuntimeException(LMP_HOME_PAGE_WELCOME_LABEL.getelementName()+" not visible in the page.");
		}
		else {
			TestNGUtils.reportLog(logger,"Verified the home page");

		}
		return verifyWelcomeMssg;
	}
	
	/**
	 * logout
	 * @param testData
	 */
	public void logout(TestData testData) throws Exception {
		clickElementJSIfExists(driver, LMP_HOME_PAGE_PROFILE_PIC_LABEL);
		clickElementJSIfExists(driver, LMP_HOME_PAGE_LOGOUT_LINK);
	}
	
	/**
	 * selectSubMenu
	 * @param menu
	 * @param subMenu
	 */
	public void selectSubMenu(String menu, String subMenu)throws Exception  {

		mouseHover(driver, LMP_HOME_PAGE_MENU_LINK.replace("##MENU##", menu));
		clickElementUsingActionClass(driver, LMP_HOME_PAGE_SUBMENU_LINK.replace("##SUBMENU##", subMenu));
		TestNGUtils.reportLog(logger,"Selected menu "+menu+" and submenu "+subMenu);

	}

	public void selectMainMenu(String menu)throws Exception  {

		mouseHover(driver, LMP_HOME_PAGE_MENU_LINK.replace("##MENU##", menu));
		clickElementUsingActionClass(driver, LMP_HOME_PAGE_MENU_LINK.replace("##MENU##", menu));
		TestNGUtils.reportLog(logger,"Selected menu "+menu);

	}




}
