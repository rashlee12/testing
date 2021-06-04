package com.Dollardays.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.commons.io.FileUtils;

import com.Dollardays.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	
    public String baseURL=readconfig.getApplicationURL();
	
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{ 
		Logger=Logger.getLogger("DollarDays");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
	
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		driver = new ChromeDriver();
     
		}
		else if(br.equals ("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			driver= new FirefoxDriver();
		}
			 driver.get(baseURL);
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException{
		   TakesScreenshot ts = (TakesScreenshot) driver;
		   File source = ts.getScreenshotAs(OutputType.FILE);
		   File target = new File(System.getProperty("user.dir") +"/Screenshots/" + tname + ".png");
		   FileUtils.copyFile(source, target);
		   System.out.println("Screenshot taken");
		}

	
	@AfterClass
	public void tearDown()
	{
		
		 //driver.close();
		 Logger.info("driver closing"); 
		 //driver.quit();
		 Logger.info("driver quitting");
		 
	}
	
}
 