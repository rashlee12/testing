package com.Dollardays.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Dollardays.pageObject.LoginPage;
import com.Dollardays.utilities.XLUtils;

public class Tc_loginDDT_002 extends BaseClass
 {
	@Test(dataProvider="TestData")
	public void loginDDT(String user,String pwd)
	{
      LoginPage lp=new LoginPage(driver);
      lp.setsignin();
      lp.setsigninDD();
      lp.setusername(user);
      lp.setpassword(pwd);
      lp.ClickSubmit();
      Logger.info("Test 2 Done");
      
}
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name= "TestData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir") + "\\src\\test\\java\\com\\Dollardays\\testdata\\TestData.xlsx";
	 
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		Logger.info("rownum = " + rownum);
	    int colcount=XLUtils.getCellCount(path,"Sheet1",rownum);
	    
	    
	  String logindata [][]= new String[rownum][colcount];
	    
	  for(int i=1;i<=rownum;i++)
	  {  
	    for(int j=0;j<colcount;j++)
	    {
	    	logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i, j);//10
	    }
	}
	
	return logindata;
	}
}