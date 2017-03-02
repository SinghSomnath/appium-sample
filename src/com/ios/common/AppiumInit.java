package com.ios.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * This class starts the appium server in a separate thread and ensures the spawned thread starts the server 
 * before main thread tries to Initiate the IOSDriver object .
 * @author Somnath Singh.
 *
 */
public final class AppiumInit {

	private static String appiumPath;
	public static volatile boolean isServerStopped = true;

	private static AppiumInit appiumInit2 = new AppiumInit();
	private AppiumInit() {	

		String osName = System.getProperty("os.name");

		//System.out.println("*******"+osName);
		if (osName.toLowerCase().contains("windows")){

			appiumPath ="C:\\Program Files (x86)\\Appium";

		} else if (osName.toLowerCase().contains("mac")){

			appiumPath = "/Applications/Appium.app";

		}
		else {
			appiumPath = "undefined";
		}


	}

	public static AppiumInit getInstance() throws FileNotFoundException{
		File app = new File(appiumPath);

		if (app.exists() && app.isDirectory())
			return appiumInit2;
		else {
			String appiumUrl = "https://bitbucket.org/appium/appium.app/downloads/appium.dmg";
			String error = "Appium not installed.\n Please download from :\n"+appiumUrl;
			throw new FileNotFoundException(error);
		}
	}

	//Start Appium server Programatically
	public void startAppiumServer() throws Exception{


		String osName = System.getProperty("os.name");
		String nodePath = "";
		String appiumjs = "";

		//System.out.println("*******"+osName);
		if (osName.toLowerCase().contains("windows")) {

			nodePath = appiumPath.concat("\\node.exe");
			appiumjs = appiumPath
					.concat("\\node_modules\\appium\\bin\\appium.js");

		} else if (osName.toLowerCase().contains("mac")) {

			nodePath = appiumPath.concat("/Contents/Resources/node/bin/node");
			appiumjs = appiumPath
					.concat("/Contents/Resources/node_modules/appium/ls/main.js");

		}
		else {
			nodePath = "undefined";
			appiumjs = "undefined";
		}	



		String sCommand = "";
		sCommand = nodePath;
		sCommand = sCommand.concat(" " + appiumjs);
		sCommand = sCommand.concat(" " + "--debug-log-spacing");

		final String c = sCommand;



		try {
			//Stop any previously running server
			stopAppiumServer();
			System.out.println(".......Starting the server..........");						

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 



		Thread startServerThread = new Thread()
		{
			public void run()
			{
				try {
					String start_server = "/Applications/Appium.app/Contents/Resources/node/bin/node /Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js --debug-log-spacing";
					Process p = Runtime.getRuntime().exec(start_server);
					String line="";
					BufferedReader in = new BufferedReader(
							new InputStreamReader(p.getInputStream()) );
					while ((line = in.readLine()) != null) {


						System.out.println(line);
						if(line.contains("listener started on"))
						{
							isServerStopped = false;
						}



					}

					p.waitFor();		

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		startServerThread.setPriority(Thread.MAX_PRIORITY);
		startServerThread.start();
		
		while(isServerStopped)
		{
			Thread.sleep(1000);
			
		}
		
		System.out.println("**************************************************************************");
		System.out.println("**********************APPIUM SERVER STARTED SUCCESSFULLY******************");
		System.out.println("**************************************************************************");

	}

	public void stopAppiumServer() {

		String osName = System.getProperty("os.name");
		String killCmd = "";

		//System.out.println("*******"+osName);
		if (osName.toLowerCase().contains("windows")){

			killCmd = "taskkill /f /im node";

		} else if (osName.toLowerCase().contains("mac")){

			killCmd = "killall node";

		}
		else {
			killCmd =   "undefined";
		}

		try {
			Runtime.getRuntime().exec(killCmd);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

};