package com.ios.common;

import org.junit.BeforeClass;

import com.ios.common.util.IOSAutomationUtility;

public class IOSAutomationInit extends IOSAutomationBase{
	
	public static IOSAutomationUtility iosAutomationUtility ;
	
	@BeforeClass
	public static void setUpIOSAutomation()
	{
		iosAutomationUtility = new IOSAutomationUtility();
	}

}
