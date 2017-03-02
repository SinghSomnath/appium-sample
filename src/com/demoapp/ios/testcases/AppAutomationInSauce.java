package com.demoapp.ios.testcases;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import bsh.Capabilities;

public class AppAutomationInSauce {
	
	public IOSDriver driver = null;
	
	@Before
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appiumVersion", "1.3");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("deviceName", "iPhone 5");
		capabilities.setCapability("app", "sauce-storage:my_app.zip");
		
	
	try
	{
		String url = "http://uday035:4c673377-2407-417b-8de3-c94031a7b302@ondemand.saucelabs.com:80/wd/hub";
		
//		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
//		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver = new IOSDriver(new URL(url),capabilities);
	//	driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) {
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}

	
		finally {
			
		}
	}
	
	@Test
	public void test1() throws InterruptedException
	{
		System.out.println("...Hello World..");
		WebElement element = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]"));
	    element.sendKeys("164.99.117.57");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]")).click();
//	    ((JavascriptExecutor)(driver)).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.63986328125); put("x", 249.0); put("y", 282.0); }});
	    Thread.sleep(60000);
	    
//	    Set<String> set = driver.getContextHandles();
//	    
//	   for (String string : set) {
//		   
//		   System.out.println(string);
//		
//	}
	    
	    driver.findElement(By.xpath(" //UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();;
	}
	

	

}
