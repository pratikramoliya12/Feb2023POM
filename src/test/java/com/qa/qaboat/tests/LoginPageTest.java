package com.qa.qaboat.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("Login page title: " + actTitle);
		Assert.assertEquals(actTitle, "Login - EpicDeal");
	}
	
	@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test
	public void loginPageUrlTest() {
		String loginUrl = loginPage.getLoginPageUrl();
		System.out.println("Login page url is: " +loginUrl);
		Assert.assertTrue(loginUrl.contains("/login"));
	}
	
	@Test
	public void loginTest() {
		loginPage.doLogin("test1707@gmail.com", "Test@1707");
	}
}
