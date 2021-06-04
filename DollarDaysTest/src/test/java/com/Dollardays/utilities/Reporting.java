package com.Dollardays.utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
  public ExtentSparkReporter reporter;
  public ExtentReports extent;
  public ExtentTest logger;
  
  public void onStart(ITestContext testContext)
  {
  
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
    
	String repName="Test-Report-"+ timeStamp +".html";
	reporter =new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);//specify location
	//reporter.loadXMLConfig(System.getProperty("user.dir")+"/extent.config.xml");
	
	extent=new ExtentReports();

	extent.attachReporter(reporter);
	extent.setSystemInfo("Host name","Localhost");
	extent.setSystemInfo("Environment","QA");
	extent.setSystemInfo("Testername","Rashlee");
	
	
	reporter.config().setDocumentTitle(" DD Project");//title of report
	reporter.config().setReportName("Functional Test Report");//name of the report
	reporter.config().setTheme(Theme.DARK);
	
  }
  
  public void onTestSuccess(ITestResult tr)
  { 
	  logger=extent.createTest(tr.getName());
	  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));//Passed information
	   
  }
  
  public void onTestFailure(ITestResult tr)
  {
	  logger=extent.createTest(tr.getName());
	  logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	  
	  String screenshotpath=System.getProperty("user.dir")+ tr.getName()+".png";
	  
	  File f = new File(screenshotpath);
	  
	  if(f.exists())
	  {
		  logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotpath));
	  }
  }
  
  public void onTestSkipped(ITestResult tr)
  {
	  logger=extent.createTest(tr.getName());
	  logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
  }
  public void onFinish(ITestContext testcontext)
  {
	  extent.flush();
  }
}
