package com.qa.qaboat.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.qaboat.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("Login page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test
	public void loginPageUrlTest() {
		Assert.assertTrue(loginPage.getLoginPageUrl());
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		String accUrl = accountsPage.getAccountsPageUrl();
		System.out.println(accUrl);
		Assert.assertTrue(accUrl.contains(Constants.ACCOUNTS_PAGE_URL));
	}
}
