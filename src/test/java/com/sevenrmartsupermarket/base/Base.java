package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.Screenshot;
import com.sevenrmartsupermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	FileInputStream is;
	Properties properties = new Properties();
	Screenshot screenshot = new Screenshot();

	/** Constructor for initializing config.properties file **/
	public Base() {
		try {
			is = new FileInputStream(Constants.CONFIG_FILE_PATH); 
			properties.load(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
			e.printStackTrace();
		}
	}

	/** Launching browser **/
	public void initialize(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitUtility.PAGE_LOAD_WAIT));
	}

	@Parameters("browser") 
	@BeforeMethod(enabled = false)
	public void launchBrowser(String browser) {
		String url = properties.getProperty("url"); 
		initialize(browser, url);
	}
	
	@BeforeMethod(enabled = true, alwaysRun = true) 
	public void launchBrowser() {
		String url = properties.getProperty("url"); 
		String browser = properties.getProperty("browser"); 
		initialize(browser,url);
	}

	@AfterMethod(alwaysRun = true)
	public void terminateSession(ITestResult iTestResult) {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			screenshot.takeScreenshot(driver, iTestResult.getName());
		}
		driver.close();
	}

}
