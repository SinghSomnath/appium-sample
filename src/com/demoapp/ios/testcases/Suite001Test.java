package com.demoapp.ios.testcases;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.demoapp.common.DemoAppInit;
import com.demoapp.ios.locators.UIAApplicationMainView_Locators;
import com.demoapp.ios.locators.ActionSheetView_Locators;
import com.ios.common.IOSAutomationBase;
import com.ios.common.IOSAutomationInit;

import bsh.Capabilities;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)




public class Suite001Test extends DemoAppInit{





	@Test
	public void test001_verifyActionSheet() throws Exception
	{
        boolean isPresentOkayOrCancel = false;
        boolean isPresentOther = false;
		iosAutomationUtility.waitForElementVisible(driver, UIAApplicationMainView_Locators.uiaStaticTextActionSheet, 20);	
		iosAutomationUtility.scrollTo(driver, "Action Sheets");
		iosAutomationUtility.click(driver, UIAApplicationMainView_Locators.uiaStaticTextActionSheet);
		
		Thread.sleep(5000);
		iosAutomationUtility.click(driver, ActionSheetView_Locators.uiaStaticTextOkayOrCancel);
		
		Thread.sleep(5000);
		
//		isPresentOkayOrCancel = iosAutomationUtility.waitForElementVisible(driver, ActionSheetView_Locators.uiaStaticTextOkayOrCancel, 10);
//		isPresentOther = iosAutomationUtility.waitForElementVisible(driver, ActionSheetView_Locators.uiaStaticTextOther, 10);
//		
//		Assert.assertTrue("Okay/Cancel option is not present..." , isPresentOkayOrCancel );
//		Assert.assertTrue("Other option is not present..." , isPresentOther );
		
		

	}


	

}
