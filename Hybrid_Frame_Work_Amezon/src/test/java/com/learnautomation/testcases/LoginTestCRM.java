package com.learnautomation.testcases;
import java.sql.Driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.learnautomation.pages.DriverlodeandClose;
import com.learnautomation.pages.LoginPageFirst;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataReaderAndWriter;
import com.learnautomation.utility.Helper;

public class LoginTestCRM extends DriverlodeandClose {  	      
	      @Test(priority=1)
	      public void loginApp()
	      {	    		    
	    	    logger =report.createTest("Login to CRM");
	    	   //  driver = BrowserFactory.StartApplication(driver, "Chrome", "https://www.amazon.in/");
	    	    LoginPageFirst loginpage= PageFactory.initElements(driver, LoginPageFirst.class);
	    	    logger.info("Start application ");
	    	   loginpage.LoginToCRM( excel.getNumericData("UserAndPass", 0, 0),  excel.getStringData("UserAndPass", 0, 1));	    	    
	           logger.pass("login done success ");
	    	    //  loginpage.LoginToCRM( "9921840121", "Ravi@1996");	    	    
	    	    //Helper.captureScreenshot(driver);
	      } 
	      @Test(priority=2)
	      public void loginApp1()
	      {	    		    
	    	    logger =report.createTest("Logout");
	    	    logger.fail("Logout failed ");
	    	   
	      } 	
}	
