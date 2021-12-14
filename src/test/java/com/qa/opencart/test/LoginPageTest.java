package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void loginPagetitleTest() {
		String title=loginPage.getLoginTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Login_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void urlTest() {
		String url=loginPage.currentUrl();
		System.out.println(url);
	Assert.assertEquals(url, Constants.PAGE_URL);
		
	}

	@Test(priority=3)
	public void forgotPasswordTest() {
		Assert.assertTrue(loginPage.isforgotpwdexist());
		
	}
	
	@Test(priority=4)
	public void loginTest()
	{
	accPage=	loginPage.dologin(prop.getProperty("username").trim(),prop.getProperty("password".trim()));
		Assert.assertEquals(accPage.getAccountPageTitle(), Constants.ACCOUNT_Login_PAGE_TITLE);
	}
	
}
