package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest{

	@BeforeClass
	public void accPageSetup() {
		accPage=loginPage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test
	public void accPageTest() {
	String title=	accPage.getAccountPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.ACCOUNT_Login_PAGE_TITLE);
	}
	
//	@Test
//public void isLogoutExist() {
//	Assert.assertTrue(accPage.isLogoutExist());
//		
//	}
	@Test
	public void accsecsTest() {
	List<String> accSecList=	accPage.getAccountSections();
	Assert.assertEquals(accSecList, Constants.getExpectedAccSecList());
		
	}
	@Test
	public void searchTest() {
		accPage.doSearch("MacBook Pro");
	}
}
