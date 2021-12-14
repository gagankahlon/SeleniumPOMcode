package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
private WebDriver driver;
private ElementUtil eleUtil;

	private By header=By.cssSelector("div#logo a");
	private By accountsSections=By.cssSelector("div#content h2");
	private By searchfields=By.name("search");
	private By searchbtn=By.cssSelector("div#search button");
	private By logout=By.linkText("logout");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
		}
	public String getAccountPageTitle() {
		return driver.getTitle();
			}
	public String headerText() {
		return eleUtil.doGetText(header);
	}
	public boolean isLogoutExist() {
		return eleUtil.doIsDisplayed(logout);
		
	}
	public void logout() {
		if(isLogoutExist()) {
			eleUtil.doClick(logout);
		}
	}
		public List<String> getAccountSections() {
	List<WebElement> accSecList=	eleUtil.getElements(accountsSections);
	List<String> accSecValList=new ArrayList<String>();
	for(WebElement e:accSecList) {
		String text=e.getText();
		accSecValList.add(text);
	}
	return accSecValList;
	
		}
		
		public boolean isSearchExist() {
			return eleUtil.doIsDisplayed(searchfields);
			}
	public SearchResultsPage doSearch(String productName) {
		System.out.println(productName);
		eleUtil.doSendKeys(searchfields, productName);
		eleUtil.doClick(searchbtn);
		return new SearchResultsPage(driver);
	}
}
