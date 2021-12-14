package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String Login_PAGE_TITLE="Account Login";
	public static final String PAGE_URL="https://demo.opencart.com/index.php?route=account/login";
	public static final String ACCOUNT_Login_PAGE_TITLE="My Account";
	
	public static List<String>getExpectedAccSecList() {
		List<String> expList=new ArrayList<String>();
		expList.add("My Account");
		expList.add("My Orders");
		expList.add("My Affiliate Account");
		expList.add("Newsletter");
		return expList;
	}
	
}
