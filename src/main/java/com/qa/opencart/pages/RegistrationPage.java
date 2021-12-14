package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {
	
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By email=By.id("input-email");
    private By telephone=By.id("input-telephone");
    private By password=By.id("input-password");
    private  By confirmPassword=By.id("input-confirm");
    private By subYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
    private By SubNO=By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
    private By checkbox=By.name("agree");
    private By contbtn=By.xpath("//input[@type='submit' and @value='Continue']");
    private By message=By.xpath("//div[@id='content']/h1");
    private By logout=By.linkText("logout");
    private By register=By.linkText("register");
    
    public RegistrationPage(WebDriver driver) {
    	this.driver=driver;
    	eleUtil=new ElementUtil(driver);
    	   	
    }
    public void accRegister(String firstName, String lastName, String email, String telphone,
			String password, String subscribe) {
    	eleUtil.doSendKeys(this.firstName, firstName);
    	eleUtil.doSendKeys(this.lastName, lastName);
    	eleUtil.doSendKeys(this.email, email);
    	eleUtil.doSendKeys(this.telephone, telphone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmPassword, password);
    }
    

	
	
	
	
	

}
