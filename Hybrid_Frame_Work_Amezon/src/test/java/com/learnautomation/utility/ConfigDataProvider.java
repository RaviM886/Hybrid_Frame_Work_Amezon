package com.learnautomation.utility;

import java.io.*;
import java.util.*;

public class ConfigDataProvider {	
	Properties pro;
  public ConfigDataProvider() 
  {
	     File src  = new File("./Config/Config.properties");
	    
			FileInputStream fis;
			try {
				fis = new FileInputStream(src);
				 pro = new Properties();
			     pro.load(fis);
			} catch (Exception e) {
				  System.out.println("unble to lode excel file - "+e.getMessage());
			}
			
  }    
     public String getDataFromConfig(String keyToSearch)
     {
    	   return pro.getProperty(keyToSearch);
     }
     public String getBrowser()
     {
    	 return pro.getProperty("Browser");
     }
     public String getStringURL()
     {
    	 return pro.getProperty("qaURL");
     }
}
