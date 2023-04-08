package com.qa.qaboat.pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.qaboat.utils.Constants;
import com.qa.qaboat.utils.ElementUtil;

public class LoginPage {
	
	// 1. declare private driver
	private ChromeDriver driver;
	private ElementUtil eleUtil;
	
	// 2. page constructor
	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	// 3. By locators
	private By email = By.cssSelector("#email");   // id("username");
	private By password = By.cssSelector("#password");   // id("password");
	private By signIn = By.xpath("//button[contains(text() , 'SIGN IN')]");
	private By forgotPwdLink = By.linkText("forgot password?");
//	private By accountInfoText = By.cssSelector(".panel-header");
	
	
	// 4. page actions
	public String getLoginPageTitle() {
		return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, 5);
	}
	
	public boolean getLoginPageUrl() {
		return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION, 5);
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
	}
	
	public AccountsPage doLogin(String un, String pwd) throws InterruptedException {
		System.out.println("login with: " + un + " : " + pwd);
		eleUtil.doSendKeys(email, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(signIn);
		Thread.sleep(5000);
		return new AccountsPage(driver);
	}
	
}
