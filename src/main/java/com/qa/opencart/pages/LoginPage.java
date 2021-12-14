package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		}
	private By username=By.id("input-email");
	private By password=By.id("input-password");
	private By forgotpassword=By.linkText("Forgotten Password");
	private By register=By.linkText("Register");
	private By login=By.xpath("//input[@type='submit']");
	
	public String getLoginTitle() {
		return driver.getTitle();
		
	}
	public String currentUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isforgotpwdexist() {
		return eleUtil.doIsDisplayed(forgotpassword);
	}
	public boolean registerlink() {
		return eleUtil.doIsDisplayed(register);}
	
	public AccountsPage dologin(String un,String pwd) {
		System.out.println("register with:"+un+":"+pwd);
		eleUtil.doSendKeys(username, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(login);
		return new AccountsPage(driver);
			
}
	

	
}

