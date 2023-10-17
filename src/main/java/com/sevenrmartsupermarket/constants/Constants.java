package com.sevenrmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class Constants {

	ExcelReader excelReader = new ExcelReader();
	
	public static final String CONFIG_FILE_PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	public static final String EXCEL_FILE_PATH = System.getProperty("user.dir")+"\\src\\main\\resources\\ExcelFiles\\";
	public static final String EXTENT_REPORT_PATH = System.getProperty("user.dir")+"\\ExtentReport";
	public static final String SCREENSHOT_FILE_PATH = System.getProperty("user.dir")+"\\Screenshots\\";
	
	
	                          /**Expected Results **/
	
	/**Login Page**/
	public static String expectedProfileName = "Invalid username";
	
	                          /**Data Providers**/
	@DataProvider (name="User login")
	public Object[][] userLoginData(){
		excelReader.setExcelFile("LoginData", "Set of valid credentials");
		return excelReader.getMultidimentionalData(3, 2);
	}
	
	
}
