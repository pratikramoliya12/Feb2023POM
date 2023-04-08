package com.qa.qaboat.factory;

import java.io.File;
import java.io.IOException;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	public static ChromeDriver driver;
	public Properties prop;
	
	/**
	 * This method is used to initialize the webdriver
	 * @param browserName
	 * @return driver
	 */
//	public ChromeDriver init_driver(Properties prop) {
//	System.setProperty("webdriver.chrome.driver","C://Users//nidhi//Downloads//chromedriver_win32_new//chromedriver.exe");		
//	ChromeOptions options = new ChromeOptions();
//	options.addArguments("--remote-allow-origins=*");
//	DesiredCapabilities capabilities = new DesiredCapabilities();
//	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//	options.merge(capabilities);
//	ChromeDriver driver = new ChromeDriver(options);
//	
//	driver.get(prop.getProperty("url"));
//	System.out.println(prop.getProperty("url"));
//	System.out.println("base class driver:" + driver);
//	
//	return driver;
//		
//	}
//	/**
//	 * This method is used to initialize the properties
//	 * @return
//	 * properties prop reference
//	 */
//	public Properties init_prop() {
//		prop = new Properties();
//		try {
//			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return prop;
//	}
	
	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		System.setProperty("webdriver.chrome.driver","C://Users//nidhi//Downloads//chromedriver_win32_new//chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
}
