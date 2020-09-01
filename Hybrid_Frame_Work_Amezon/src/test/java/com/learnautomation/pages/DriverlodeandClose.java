package com.learnautomation.pages;
import java.io.File;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataReaderAndWriter;
import com.learnautomation.utility.Helper; 
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class DriverlodeandClose {
        public  WebDriver driver; 
        public ExcelDataReaderAndWriter excel;
        public ConfigDataProvider config;
        public ExtentReports report;     
        public ExtentTest logger;
        @BeforeSuite
        public void setUpSuite()
        {
        	 Reporter.log("setting up report and test is getting ready  ",true);
        	excel=new ExcelDataReaderAndWriter();
	       config= new ConfigDataProvider();
	       ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Amezon_"+Helper.getCurrentDateFormat()+".Html"));	 
	     
	       report=new ExtentReports();
	       report.attachReporter(extent);
	       Reporter.log("Setting Done - Test can be started  ",true);
        }
        
       @Parameters("browserabc")
       @BeforeClass
     	public void setup(String browserabc) {
   	
         	Reporter.log("Tring to start browser and application is ready ", true);
 	      driver = BrowserFactory.StartApplication(driver, browserabc,config.getStringURL());  
         //	driver = BrowserFactory.StartApplication(driver, "Chrome", "https://www.amazon.in/");
            System.out.println(driver.getTitle());       
         	Reporter.log("Browser and application is running ", true);         		
   	}
   	@AfterClass
   	public void teardown() {
   		BrowserFactory.quitBrowser(driver);
   	}   	
   	@AfterMethod
   	public void tearDownMethod(ITestResult result) throws Exception
   	{
   		Reporter.log("Test is about to end  ", true);   
   		
   		if(result.getStatus()==ITestResult.FAILURE)
   		{
   		  //Helper.captureScreenshot(driver);
   		  //logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath("").build());
   		  logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
   		}
   		else if(result.getStatus()==ITestResult.SUCCESS)
   		{
     		  logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

   		}
   		report.flush();
   		Reporter.log("Test Completed >> Report generated ", true);   
   	}
}
 