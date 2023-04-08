package com.qa.qaboat.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.qaboat.factory.DriverFactory;
//import com.qa.qaboat.factory.DriverFactory;
import com.qa.qaboat.pages.AccountsPage;
import com.qa.qaboat.pages.LoginPage;
import com.qa.qaboat.pages.ProductDetailsPage;
import com.qa.qaboat.pages.SearchResultsPage;

public class BaseTest {

	DriverFactory df;
	Properties prop;
	ChromeDriver driver;
	LoginPage loginPage;
	AccountsPage accountsPage;
	SearchResultsPage searchResultsPage;
	ProductDetailsPage productDetailsPage;
	
	
	@BeforeTest
	public void setup() {
//		df = new DriverFactory();
		
		System.out.println("Setup Method");
		prop = new Properties();
		try {
			FileReader reader = new FileReader("./src/test/resources/config/config.properties");
			prop.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		driver = df.init_driver(prop);
		
		System.setProperty("webdriver.chrome.driver","C://Users//nidhi//Downloads//chromedriver_win32_new//chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		System.out.println(prop.getProperty("url"));

		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Teardown Method");
		driver.quit();
	}
	
}
