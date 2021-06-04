package com.Dollardays.testcases;

import org.testng.annotations.Test;

import com.Dollardays.pageObject.LoginPage;
import com.Dollardays.pageObject.WishList;

public class Tc_Wishlist_003 extends BaseClass
{
	
 @Test
  public void Wishlist() throws InterruptedException
  {
		
		
		/*
		 * LoginPage lp=new LoginPage(driver);
		 * 
		 * lp.setsignin(); lp.setsigninDD(); lp.setusername(username);
		 * lp.setpassword(password); lp.ClickSubmit();
		 * 
		 * Thread.sleep(3000);
		 */
	  WishList additem= new WishList(driver);
	  
	  
	  additem.setsearchbar();
	  Logger.info("after searchbar");
	  
	  //additem.setsearchproduct();
	  //Logger.info("after product set");
	  
	  additem.setsearchbutton();
	  Logger.info("after searchclick");
	  
	  additem.clickImage();
	  Logger.info("after imageclick");
	  
	  //Thread.sleep(1000);
	
	  additem.popupclick();
	  Logger.info("after popupclick");
	  
	  
	  additem.WishList();
	  Logger.info("after adding 3 to item field");
	  
	  additem.addtoWishlist();
	  Logger.info("after add to wishlist");
	  
	  
}
}