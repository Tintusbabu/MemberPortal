package com.ibs.lmp.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.ibs.model.TestData;
import com.ibs.services.TestDataServices;
import com.ibs.utils.SeleniumUtils;
import com.ibs.utils.TestNGUtils;
import com.ibs.utils.XPATH;



/**
 * This page handles the common functionalities specifically needed for Member portal
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
public class CommonUtility extends SeleniumUtils {



	/**
	 * This function handles data entry to a text box - clearTextAndEnterValueWithNullCheck
	 * @param driver
	 * @param xpath
	 * @param value
	 * @throws EXCEPTION
	 */
	public void clearTextAndEnterValueWithNullCheck(WebDriver driver, XPATH xpath, String value) throws Exception {
		if (!"MP##NA".equals(value)) {

			if (!SeleniumUtils.isVisible(driver, xpath, 20)) {
				try {
					SeleniumUtils.scrollPageToAnElement(driver, xpath);
				} catch (Exception e) {
					TestNGUtils.reportLog("Issue in scroll" + xpath.getelementName());
				}
			}

			if (SeleniumUtils.isVisible(driver, xpath, 20) && !value.isEmpty() && value != null) {
				SeleniumUtils.waitForElement(driver, xpath);
				SeleniumUtils.clearTextEnterValueAndValidate(driver, xpath, value);
			}
		}
	}
	
	/**
	 * This function handles to get data from value attribute
	 * @param driver
	 * @param xpath
	 * @throws EXCEPTION
	 */
	public String getAttributeValue(WebDriver driver, XPATH xpath) throws Exception {

		String value = null;
		if (!SeleniumUtils.isVisible(driver, xpath, 20)) {
			try {
				SeleniumUtils.scrollPageToAnElement(driver, xpath);
			} catch (Exception e) {
				TestNGUtils.reportLog("Issue in scroll" + xpath.getelementName());
			}
		}

		if (SeleniumUtils.isVisible(driver, xpath, 20)) {
			SeleniumUtils.waitForElement(driver, xpath);
			value = SeleniumUtils.findElement(driver, xpath).getAttribute("value");
		}
		return value;

	}

	/**
	 * This function handles selection of value in drop down - selectValueFromDropdownWithNullCheck
	 * @param driver
	 * @param xpath
	 * @param value
	 */
	public void selectValueFromDropdownWithNullCheck(WebDriver driver, XPATH xpath, String value) throws Exception{
		if (!"MP##NA".equals(value)) {
		if (!SeleniumUtils.isVisible(driver, xpath, 20)) {
			try {
				SeleniumUtils.scrollPageToAnElement(driver, xpath);
			} catch (Exception e) {
				TestNGUtils.reportLog("Issue in scroll" + xpath.getelementName());
			}
		}

		if (!value.isEmpty() && value != null) {
			SeleniumUtils.waitForElement(driver, xpath);
			SeleniumUtils.selectValueFromDropdown(driver, xpath, value);
		}
		}

	}

	/**
	 * This function handles button click using JS scripts - clickElementJSIfExists
	 * @param driver
	 * @param xpath
	 */
	public void clickElementJSIfExists(WebDriver driver, XPATH xpath) throws Exception{

		if (!SeleniumUtils.isVisible(driver, xpath, 15)) {
			try {
				SeleniumUtils.scrollPageToAnElement(driver, xpath);
			} catch (Exception e) {
				TestNGUtils.reportLog("Issue in scroll" + xpath.getelementName());
			}
		}

		if (SeleniumUtils.isVisible(driver, xpath, 15)) {
			SeleniumUtils.waitForElement(driver, xpath);
			WebElement m = driver.findElement(By.xpath(xpath.getelementValue()));
			// click with Javascript Executor
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", m);
			TestNGUtils
			.reportLog("Click action done for " + xpath.getelementName());
			// SeleniumUtils.clickElement(driver, xpath);
		}
	}

	/**
	 * This function handles whether a particular webelement is visible - isWebElementVisible
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public boolean isWebElementVisible(WebDriver driver, XPATH xpath) throws Exception{

		if (!SeleniumUtils.isVisible(driver, xpath, 15)) {
			try {
				SeleniumUtils.scrollPageToAnElement(driver, xpath);
			} catch (Exception e) {
				TestNGUtils.reportLog("Issue in scroll" + xpath.getelementName());
			}
		}

		return SeleniumUtils.isVisible(driver, xpath, 15);
	}

	/**
	 * This function handles read Xpath String From Property File
	 * 
	 * @param property
	 * @return
	 */
	public static String readXpathStringFromPropertyFile(String property) {
		
		/* code to fetch values from properties file */
		Properties props = new Properties();
		try {
		InputStream is = null;
		String userDir = System.getProperty("user.dir");
		// String propertyPath = userDir
		// + "\src\resources\Properties\ProjectConfig.properties";
		
		String propertyPath = String.valueOf(userDir) + "/src/main/resources/Properties/xpath.properties";

		// First try loading from the current directory
		try {
			File f = new File(propertyPath);
			is = new FileInputStream(f);
			props.load(is);
		} catch (IOException e) {
			is = null;
		}
		} catch (Exception e) {
			TestNGUtils.reportLog("Error in read Xpath String From Property File "+ property);
			throw new RuntimeException("Error in read Xpath String From Property File " + property  );
		}
		return props.getProperty(property);
	}

	/**
	 * This function handles get text data
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public String getText(WebDriver driver, XPATH xpath)throws Exception {
		String textVal = null;

		if (!SeleniumUtils.isVisible(driver, xpath, 20)) {
			try {
				SeleniumUtils.scrollPageToAnElement(driver, xpath);
			} catch (Exception e) {
				TestNGUtils.reportLog("Issue in scroll" + xpath.getelementName());
			}
		}

		if (SeleniumUtils.isVisible(driver, xpath, 20)) {
			SeleniumUtils.waitForElement(driver, xpath);
			textVal = SeleniumUtils.findElement(driver, xpath).getText();
		}
		return textVal;
	}
	/**
	 * This function handles checks the checkbox
	 * @param driver
	 * @param xpath
	 */
	public void checkCheckBoxIfNot(WebDriver driver, XPATH xpath)throws Exception {

		if (!SeleniumUtils.isVisible(driver, xpath, 20)) {
			try {
				SeleniumUtils.scrollPageToAnElement(driver, xpath);
			} catch (Exception e) {
				TestNGUtils.reportLog("Issue in scroll" + xpath.getelementName());
			}
		}

		if (SeleniumUtils.isVisible(driver, xpath, 20)) {
			SeleniumUtils.waitForElement(driver, xpath);
			SeleniumUtils.findElement(driver, xpath).click();
			TestNGUtils.reportLog("clicked " + xpath.getelementName());
		}

	}

	/**
	 * This function handles getTestDataListForTestCase
	 * 
	 * @param moduleName
	 * @param testCaseName
	 * @return
	 */
	public static List<TestData> getTestDataListForTestCase(String moduleName, String testCaseName) throws Exception{
		List<TestData> matchingTestDataList = new ArrayList<>();
		// TestData testDataObj = null;
		try {
			Boolean isFound = false;
			List<TestData> testDataList = new ArrayList<>();

			// Get the test data list
			testDataList = TestDataServices.getTestDataList(moduleName);
			if (testDataList.size() == 0) {
				TestNGUtils.reportLog("Test Data list corresponding to the module " + moduleName + " is empty");
				throw new RuntimeException("Test Data list corresponding to the module " + moduleName + " is empty");
			}
			// iterating through the list
			for (TestData testData : testDataList) {
				if (testData.getTestCaseName().equalsIgnoreCase(testCaseName)) {
					isFound = true;
					matchingTestDataList.add(testData);
					// break;
				}
			}
			if (isFound == false) {
				TestNGUtils
						.reportLog("Couldn't find test data for test case: " + testCaseName + " from meta data sheet");
				throw new RuntimeException(
						"Couldn't find test data for test case: " + testCaseName + " from meta data sheet");
			}
		} catch (Exception e) {
			TestNGUtils.reportLog(
					"Exception while filtering the test data for test case " + testCaseName + ": " + e.getMessage());
			throw new RuntimeException(
					"Exception while filtering the test data for test case " + testCaseName + ": " + e.getMessage());
		}
		return matchingTestDataList;
	}
	
	/**
	 * This function handles get TextList From Web Elements
	 * @param driver
	 * @param xpath
	 * @return
	 */
	public List<String> getTextListFromWebElements(WebDriver driver, XPATH xpath){
		List<WebElement> webElementList =  findElements(driver, xpath);
		List<String> dataList = new ArrayList<String>();
		for(WebElement webElement : webElementList) {
			if(webElement.getText()!=null && !webElement.getText().isEmpty()) {
			dataList.add(webElement.getText());
			}
		}
		return dataList;
	}
	
	/**
	 * This function handles the check of 2 list comparison
	 * @param <T>
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static <T> boolean listEqualsIgnoreOrder(List<T> list1, List<T> list2) {
	    return new HashSet<>(list1).equals(new HashSet<>(list2));
	}
	
	
	/**
	 * getRandomAlphaString
	 * @return
	 */
	public static String getRandomAlphaString() {
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvxyz";
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 6; i++) {
			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());
			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}
	/**
	 * getRandomAlphaNumberString
	 * @return
	 */
	public static String getRandomAlphaNumberString() {
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0987654321"
				+ "abcdefghijklmnopqrstuvxyz";
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 6; i++) {
			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());
			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}
	
	/**
	 * getRandomAlphaNumberString
	 * Format YYYY/MM/DD
	 * @return
	 */
	public static String getRandomPastDate() {

        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1950, 2010);

        gc.set(GregorianCalendar.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));

        gc.set(GregorianCalendar.DAY_OF_YEAR, dayOfYear);

        return(gc.get(GregorianCalendar.YEAR) + "/" + (gc.get(GregorianCalendar.MONTH) + 1) + "/" + gc.get(GregorianCalendar.DAY_OF_MONTH));
		

    }

	/**
	 * Random number inbetween
	 * @param start
	 * @param end
	 * @return
	 */
	public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
	/**
	 * This function handles data clear from a field
	 * @param driver
	 * @param xpath
	 * @param value
	 * @throws EXCEPTION
	 */
	public void clearText(WebDriver driver, XPATH xpath) throws Exception {
		

			if (!SeleniumUtils.isVisible(driver, xpath, 20)) {
				try {
					SeleniumUtils.scrollPageToAnElement(driver, xpath);
				} catch (Exception e) {
					TestNGUtils.reportLog("Issue in scroll" + xpath.getelementName());
				}
			}

			if (SeleniumUtils.isVisible(driver, xpath, 20) ) {
				SeleniumUtils.waitForElement(driver, xpath);
				SeleniumUtils.findElement(driver, xpath).clear();
			}
	
	}
	
	/**
	 * writeToFile
	 * @param filepath
	 * @param pnr
	 * @param testcaseName
	 */
	public void writeToFile(ExtentTest logger,String fileName, String data) {
        try {
        	  String filepath = System.getProperty("user.dir")+"/test-results/"+fileName+".txt";
        	  String dataToPrint =   " ------ " + data;
              File file = new File(filepath);

              if (!file.exists()) {
                    file.createNewFile();
              }

              FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
              BufferedWriter bw = new BufferedWriter(fw);
              bw.newLine();
              bw.write(dataToPrint);
              bw.newLine();
              bw.write("------------------------------------------------------------------------");
              bw.close();
              
              logger.createNode("Data Capturing: "+data);
             
              
              //System.out.println("Done");

        } catch (Exception e) {
        	TestNGUtils.reportLog("Exception while writing the data " +data+ e );
        }
	
	}

	/**
	 * getCurrentDateWithTimeStamp
	 * @return
	 */
	public String getCurrentDateWithTimeStamp() {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			return (dtf.format(now));
		} catch (Exception e) {
			TestNGUtils.reportLog("Exception while getting time" + e);
		}
		return null;
	}

}
