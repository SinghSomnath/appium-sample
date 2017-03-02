package com.demoapp.common;

import org.junit.BeforeClass;

import com.demoapp.ios.util.IosDemoAppUtil;
import com.ios.common.IOSAutomationBase;
import com.ios.common.IOSAutomationInit;

public class DemoAppInit extends IOSAutomationInit{
	
public static IosDemoAppUtil iosDemoAppUtil ;
	
	@BeforeClass
	public static void setUpIprintInit()
	{
		iosDemoAppUtil = new IosDemoAppUtil();
	}


}
