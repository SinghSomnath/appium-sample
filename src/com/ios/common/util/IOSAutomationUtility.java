package com.ios.common.util;

import io.appium.java_client.ios.IOSDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ios.common.IOSAutomationBase;
import com.ios.common.IOSAutomationInit;


public class IOSAutomationUtility {
	
	
	public IOSAutomationUtility()
	{
		
	}
	
	
	public static String getProperty(String sFileName, String sPreopertyName) throws FileNotFoundException, IOException
	{
		
		String sVal = "";
		Properties props = new Properties();
		props.load(new FileInputStream("./props/" + sFileName));
		sVal = props.getProperty(sPreopertyName);
		
		return sVal;
		
	}
	
	
	public WebElement getWebElement(WebDriver driver,String sXpath)
	{
				
		WebElement element = driver.findElement(By.xpath(sXpath));		
		return element;
		
	}
	
	
	public void click(WebDriver driver, String sXpath)	
	{
		WebElement element = getWebElement(driver, sXpath);
		element.click();
		
	}
	
	public String getText(WebDriver driver, String sXpath)	
	{
		WebElement element = getWebElement(driver, sXpath);
		String sText = element.getText();
		return sText;
		
	}
	
	public boolean  waitForElementVisible(WebDriver driver, String sXpath, long timeOutInSeconds)	
	{
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		
		
		WebElement element;
		try {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sXpath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return element.isDisplayed();
		
	}
	
	
	public boolean  waitForElementNotVisible(WebDriver driver, String sXpath, long timeOutInSeconds)	
	{
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		Boolean isAbsent = true;
		try {
			isAbsent = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(sXpath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			isAbsent = false;
			
		}
		
		return isAbsent;
		
	}
	
	public void sendText(WebDriver driver, String sXpath,String sText)	
	{
		WebElement element = getWebElement(driver, sXpath);
		element.sendKeys(sText);
		
	}
	
	public void sendKeys(WebDriver driver, String sXpath,Keys key)	
	{
		
		WebElement element = getWebElement(driver, sXpath);
		element.sendKeys(key);
		
	}
	
	public String getAttributeValue(WebDriver driver, String sXpath,String attributeName)	
	{
		WebElement element = getWebElement(driver, sXpath);
		String sText = element.getAttribute(attributeName);	
		return sText;
		
	}
	
	
	
	public void scrollTo(IOSDriver<WebElement> driver, String sText)	
	{
		
	   driver.scrollTo(sText);
	   driver.scrollToExact(sText);
		
	}

}
