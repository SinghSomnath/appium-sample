package com.ios.common.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtils {
	
	/**
	 * This method is to create a logger instance
	 * @param className - Test Test class file which is currently being run
	 * @param testName - The current test method being run .
	 * @return
	 * @throws IOException
	 */
	
	 public static Logger getLogger(String className, String testName) throws IOException {

         Logger logger = null;
         String basePathForLogs  = new File(System.getProperty("user.dir")).getAbsolutePath();
         if(basePathForLogs.contains("build")){
             basePathForLogs  = new File(System.getProperty("user.dir")).getParent();
         }
         basePathForLogs =  basePathForLogs + File.separator + "logs" + File.separator;
         FileHandler handler = null;
         System.out.println(">>> Log File with Path :  " + basePathForLogs + className + "." + testName + "_result.log");
         // Set the Logger Files
         logger = Logger.getLogger(className + "." + testName + "_result.log");
         handler = new FileHandler(basePathForLogs + className + "." + testName + "_result.log", true);
         handler.setEncoding(null);
        
         logger.addHandler(handler);
         logger.setLevel(Level.ALL);
         logger.setUseParentHandlers(false);

         handler.setFormatter(new SimpleFormatter());
         return logger;
     }       
	 
	    /**
	     * This method kills the logger object .
	     * @param logger
	     * @throws Exception
	     */
	    public static void releaselogger(Logger logger) throws Exception {

	        Handler[] handler = logger.getHandlers();
	        for (int i = 0; i < handler.length; i++) {
	            System.out.println(">>> Removing handler.....");
	            logger.removeHandler(handler[i]);
	            handler[i].close();
	        }
	    }
	        
	       
	        


}

