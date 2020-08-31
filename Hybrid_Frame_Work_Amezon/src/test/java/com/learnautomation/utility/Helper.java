package com.learnautomation.utility;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
public class Helper {	
	// capture screenshot 
       public static String  captureScreenshot(WebDriver driver)
       {
    	  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	  String screenshotpath=System.getProperty("user.dir")+"/Screenshots/Amezon_"+getCurrentDateFormat()+".png";
    			  try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("scareen shot capture done ");
		} catch (Exception e) {
			  System.out.println("unble to captutre screen shot - "+e.getMessage());
		}
    	 return screenshotpath;
       }        
       public static  String getCurrentDateFormat()
       {
    	   DateFormat currentFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
    	   Date currentdate=new Date();
    	   return currentFormat.format(currentdate);
       }
}
