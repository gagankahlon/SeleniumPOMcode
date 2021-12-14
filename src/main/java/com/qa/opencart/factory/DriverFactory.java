package com.qa.opencart.factory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {

	
	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	//public OptionsManager optionsManager;

	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();

	public WebDriver int_driver(Properties prop) {
		String browsername=prop.getProperty("browser");
		System.out.println("browser name is :"+browsername);
		
		highlight=prop.getProperty("highlight");
		//optionsManager=new OptionsManager(prop);
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver());
		}
		
		else {
			System.out.println("choose right browser"+ browsername);
					}
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	public Properties init_prop() {
		prop=new Properties();
		FileInputStream ip=null;
		String env=System.getProperty("env");
		if(env==null) {
			System.out.println("Running on prodction env");
			try {
				ip=new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
			}
		
		else {
			System.out.println("running on env:"+env);
			try {
			switch (env) {
			case "qa":
				ip=ip=new FileInputStream("./src/test/resources/config/qa.config.properties");
				
				break;

			default:
				System.out.println("pass right ");
				break;
			}
		}
catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}}
		try {
			prop.load(ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
}
