package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class AddNewPayee extends BaseTest{
 
	  @BeforeClass
	  public void beforeClass() {
		  	new BasePage(getDriver());
		  	HomePage home=new HomePage();
		  	home.clickSignInButton();
		  	LoginPage login=new LoginPage();
		  	login.doLogin("username", "password");
	  }
	  
	@Test
  public void test() {
  }
  @BeforeMethod
  public void beforeMethod() {
  }



}
