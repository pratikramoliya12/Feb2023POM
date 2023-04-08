package com.qa.qaboat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductDetailsPage {

			// 1. declare private driver
			private ChromeDriver driver;
			
			// 2. page constructor
			public ProductDetailsPage(ChromeDriver driver) {
				this.driver = driver;
			}
			
			// 3. By locators
			
			
			// 4. page actions
//			public String getAccountsPageTitle() {
//				return driver.getTitle();
//			}
			
			public String getProductDetailsPageUrl() {
				return driver.getCurrentUrl();
			}
			
}
