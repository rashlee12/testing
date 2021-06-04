package com.Dollardays.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dollardays.utilities.ReadConfig;

public class WishList {
	
  WebDriver ldriver;
  
  public WishList(WebDriver rdriver) {
	  ldriver=rdriver;
	  PageFactory.initElements(rdriver, this);
	  
	  ReadConfig rcConfig =new ReadConfig();
	  
	  LoginPage lp=new LoginPage(rdriver);
	  lp.setsignin();
	  lp.setsigninDD();
	  lp.setusername(rcConfig.getUsername());
	  lp.setpassword(rcConfig.getPassword());
	  lp.ClickSubmit();
  }
	
	  //wishlist Xpath
	  //@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[2]/div/div/div[3]/div/ul/li[1]/ul/li[2]")
	  @FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[2]/div/div/div[3]/div/ul/li[2]/a/img")
	  WebElement wishlist;
	  
	  
	  //**
	  //1. Find webelement for search bar
	  @FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div[2]/div/div/div[2]/div[1]/div[1]/input")
      WebElement searchbar;
	  public void setsearchbar()
	  {
		  searchbar.sendKeys("Goodie 10");
	  }
	  
	    //2. call sendkeys with "Goodie 10"
	    @FindBy(xpath="//*[@id=\"rfk_search_container\"]/div[3]/ul/li/a/div[1]/img")
	    WebElement searchproduct;
	    public void setsearchproduct()
	    {
	    	searchproduct.sendKeys("Goodie 10");
	    }
	    		
	    //3. Search button click
	    @FindBy(xpath=" //*[@id=\"aspnetForm\"]/header/div[2]/div/div/div[2]/div[1]/div[1]/div/div/button")
	    WebElement searchbutton;
	    public void setsearchbutton()
	    {
	    	searchbutton.click();
	    }
	  
	    //7. Send keys to 1 to the element
	    @FindBy(xpath="//*[@id=\"ctl00_cphContent_divProductInfo\"]/div[2]/div/div/div[2]/div[1]/div[1]/div/div[3]/div[3]/div/div/input")
	    WebElement wishlistCount;
		public void WishList() {
			// TODO Auto-generated method stub
			wishlistCount.sendKeys("3");
		}
	    
		@FindBy(xpath="//*[@id=\"ctl00_cphContent_divProductInfo\"]/div[2]/div/div/div[2]/div[1]/div[1]/div/div[3]/div[3]/div/div/div/div/button")
		WebElement btnaddtoWishlist;
		public void addtoWishlist()
		{
			btnaddtoWishlist.click();
		}
		
		@FindBy(xpath="//*[@id=\"central-content\"]/div[3]/div[1]/div/div/div/div/div[1]/div[2]/a/div/img\r\n")
		WebElement searchedproduct;
		public void clickImage()
		{
			searchedproduct.click();
		}
		
		@FindBy(xpath="//*[@id=\"ctl00_cphContent_divProductInfo\"]/div[2]/div/div/div[2]/div[1]/div[1]/div/div[3]/div[2]/a")
		WebElement popUpClick;
		public void popupclick()
		{
			popUpClick.click();
		}
		
	    
		//6. find # of cases element		  
		@FindBy(xpath="//*[@id=\"rfk_search_container\"]/div[3]/ul/li/a/div[2]")
		WebElement popupsearch;
		public void popupsearch()
		{
			popupsearch.click();
		}
	  //5. wait for page to load to load with product
	  
		
	  
		//8. find the add to wishlist element
		@FindBy(xpath="//*[@id=\"ctl00_cphContent_divProductInfo\"]/div[2]/div/div/div[2]/div[1]/div[1]/div/div[3]/div[2]/a")
		WebElement addwishlist;
		 public void addwishlist()
		{
		  addwishlist.click();
		}
	  // cases to add 
		 
		@FindBy(xpath="//*[@id=\"ctl00_cphContent_divProductInfo\"]/div[2]/div/div/div[2]/div[1]/div[1]/div/div[3]/div[3]/div/div/input")
		WebElement casestoadd;
		public void casestoadd()
		{
			casestoadd.click();
		}
		
	/*
	 * @FindBy(xpath=
	 * "//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[2]/a/i")
	 * WebElement wishlistcartcount; public void wishlistcartcount() {
	 * wishlistcartcount.getAttribute() }
	 */
	  //10. 
}

