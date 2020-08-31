package com.learnautomation.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPageFirst {   
	//hii this is new comment
	   WebDriver driver;
	   public LoginPageFirst(WebDriver ldriver)
	   {
		   this.driver=ldriver;
	   }	   
	   @FindBy(xpath ="//span[contains(text(),'Hello, Sign in')]")WebElement firstclick;
		  @FindBy(xpath="//input[contains(@name,'email')]") WebElement UserName;
		  @FindBy(xpath="//input[contains(@id,'continue')]") WebElement secondclick;
		  @FindBy(xpath = "//input[contains(@name,'password')]") WebElement Passw;
		  @FindBy(xpath="//input[contains(@id,'signInSubmit')]") WebElement threeclick;		  
		  public void LoginToCRM(String usernamerApp,String passwordApp)
		  {			  
			  try {
				
				  Thread.sleep(2000);
			} catch (InterruptedException e) {
				
			}
			  firstclick.click();
			  UserName.sendKeys(usernamerApp);
			  secondclick.click();
			  Passw.sendKeys(passwordApp);
			  threeclick.click();
		  }
		  
}
