package com.demoapp.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.demoapp.common.DemoAppInit;
import com.demoapp.ios.testcases.Suite001Test;

@RunWith(Suite.class)
@SuiteClasses({ Suite001Test.class })
public class AllTests {

}
