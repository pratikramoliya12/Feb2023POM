package com.qa.qaboat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountsPage {

		// 1. declare private driver
		private ChromeDriver driver;
		
		// 2. page constructor
		public AccountsPage(ChromeDriver driver) {
			this.driver = driver;
		}
		
		// 3. By locators
		private By dashboardLinkText = By.xpath("//ul[contains(@class, 'account-sidebar')]//a[contains(text(), 'Dashboard')]");
		private By logoutLinkText = By.xpath("//ul[contains(@class, 'account-sidebar')]//a[contains(text(), 'Logout')]");
		private By searchField = By.xpath("//div[contains(@class, 'header-search-lg')]//input[contains(@class, 'search-input')]");
		private By searchButton = By.xpath("//div[contains(@class, 'header-search-right')]/button[contains(@type, 'submit')]");
		
		// 4. page actions
		public String getAccountsPageTitle() {
			return driver.getTitle();
		}
		
		public String getAccountsPageUrl() {
			return driver.getCurrentUrl();
		}
		
		public Boolean getDashboardLinkText() {
			return driver.findElement(dashboardLinkText).isDisplayed();
		}
		
		public Boolean getLogoutLinkText() {
			return driver.findElement(logoutLinkText).isDisplayed();
		}
		
		public Boolean searchFieldExist() {
			return driver.findElement(searchField).isDisplayed();
		}
		
		public SearchResultsPage doSearch(String productName) throws InterruptedException {
			System.out.println("Searching for: " + productName);
			driver.findElement(searchField).clear();
			driver.findElement(searchField).sendKeys(productName);
			driver.findElement(searchButton).click();
			Thread.sleep(5000);
			return new SearchResultsPage(driver);
			
			
		}
}
