
package com.Dollardays.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dollardays.pageObject.LoginPage;

public class Tc_LoginTest_001 extends BaseClass 
{
	
     @Test
	public void loginTest() throws IOException
	{
    	 
     //baseURL = baseURL + "/sitelogin.aspx";	
		Logger.info("URL is opened");
		
		  LoginPage lp=new LoginPage(driver);
		  lp.setsignin();
		  Logger.info("Signin option is available");
		  
		  lp.setsigninDD();
		  Logger.info("Clicked signin Dropdown");
		  
		  
		  lp.setusername(username);
		  Logger.info("Entered username");
		  
		  lp.setpassword(password);
		  Logger.info("Entered password");
		  
		  lp.ClickSubmit();
		  Logger.info("Submit button clicked");
			 
	 
	 //Assert.assertEquals(driver.getTitle(),"DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products");
		
		  if(driver.getTitle().equals("DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products")) 
		  {
			  	Assert.assertTrue(true);
			  	Logger.info("Test passed");
		  }
		  else
		  { 
			  captureScreen(driver,"LoginTest");
			  Assert.assertTrue(false); 
			  Logger.info("Test failed");
			  
		  }
 
	}	
}