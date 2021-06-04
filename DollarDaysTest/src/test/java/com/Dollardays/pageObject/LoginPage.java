package com.Dollardays.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public	LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//Sign in xpath
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[2]/div/div/div[3]/div/ul/li[1]/a/span")
	WebElement signIn;
	public void setsignin()
	{ 
		signIn.click();
	} 
	
	//@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[2]/div/div/div[3]/div/ul/li[1]")
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[2]/div/div/div[3]/div/ul/li[1]/ul/li[2]")
	WebElement signinDropdown;
	public void setsigninDD()
	{ 
		signinDropdown.click();
	}
	
	
	
	              //*[@id="aspnetForm"]/header/div[2]/div/div/div[3]/div/ul/li[1]/ul/li[2]
	@FindBy(name="username")
	WebElement txtUserName;
	public void setusername(String uname)
	{ 
		txtUserName.sendKeys(uname);
	}
	
	@FindBy(name="password")
	WebElement txtpassword;
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	@FindBy(xpath="//button[@type='submit']")
	//@FindBy(xpath = //*[@id="aspnetForm"]/div[5]/div/div/div/div[2]/div/div[1]/div/div/div[4]/button)
	WebElement Submitbtn;
	public void ClickSubmit()
	{	
		Submitbtn.click();
	}
	
	
	
	
	
	
	
	
}
