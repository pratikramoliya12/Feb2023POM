package com.qa.qaboat.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.qaboat.utils.Constants;

public class ProductDetailsPageTest extends BaseTest{

	@BeforeClass
	public void productDetailsPageSetup() throws InterruptedException {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		searchResultsPage = accountsPage.doSearch("apple");
		productDetailsPage = searchResultsPage.DoClickOnProduct();
	}
	
	@Test(priority = 1)
	public void productDetailsPageUrlTest() {
		String ProductDetailsPageUrl = productDetailsPage.getProductDetailsPageUrl();
		System.out.println("Accounts page title: " + ProductDetailsPageUrl);
		Assert.assertTrue(ProductDetailsPageUrl.contains(Constants.PRODUCT_DETAILS_PAGE_URL));
	}
	
}
