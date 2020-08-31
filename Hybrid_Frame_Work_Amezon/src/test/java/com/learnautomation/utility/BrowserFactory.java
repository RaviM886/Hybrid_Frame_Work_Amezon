package com.learnautomation.utility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class BrowserFactory {
    public static WebDriver StartApplication(WebDriver driver,String browsername,String appURL)
    {
    	if(browsername.equals("Chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            driver=new ChromeDriver();   	
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	}else if(browsername.equals("Firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
            driver=new FirefoxDriver(); 	
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	}else if(browsername.equals("IE"))
    	{
    		System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
            driver=new InternetExplorerDriver();	
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    	}else {
    		System.out.println("browser not found ");
    	}
    	  
    	   driver.manage().window().maximize();
    	   driver.get(appURL);
    	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    	   
    	   return driver;
    }    
    public static void quitBrowser(WebDriver driver)
    {
    	driver.quit();
    }
}
