package com.qa.qaboat.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.qaboat.utils.Constants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() throws InterruptedException {
		accountsPage = loginPage.doLogin("test1707@gmail.com", "Test@1707");
	}
	
	@Test(priority = 1)
	public void accountsPageTitleTest() {
		String actTitle = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void accountsPageUrlTest() {
		String accUrl = accountsPage.getAccountsPageUrl();
		System.out.println("Accounts page title: " + accUrl);
		Assert.assertTrue(accUrl.contains(Constants.ACCOUNTS_PAGE_URL));
	}
	
	@Test(priority = 3)
	public void dashboardLinkTextTest() {
		Assert.assertTrue(accountsPage.getDashboardLinkText());
	}
	
	@Test(priority = 4)
	public void logoutLinkTextTest() {
		Assert.assertTrue(accountsPage.getLogoutLinkText());
	}
	
	@Test(priority = 5)
	public void searchFieldExistTest() {
		Assert.assertTrue(accountsPage.searchFieldExist());
	}
	
	@DataProvider
	public Object[][] productData(){
		return new Object[][] {
			{"apple"}
//			{"watch"},
//			{"laptop"}
		};
	}
	
	@Test(priority = 6, dataProvider="productData")
	public void doSearchTest(String productName) throws InterruptedException {
		searchResultsPage = accountsPage.doSearch(productName);
		
		Assert.assertTrue(searchResultsPage.isSearchResultsTextExist());
	}
	
	
}
