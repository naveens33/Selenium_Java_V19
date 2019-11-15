package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountSummaryPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.PayBillsPage;

public class AddNewPayee extends BaseTest {
  
	BaseTest basetest;
	PayBillsPage paybills;
	@BeforeTest
	public void beforeTest()
	{
		basetest=new BaseTest("chrome","http://zero.webappsecurity.com");
		BasePage basepage=new BasePage(basetest.driver);
		HomePage home=new HomePage();
		home.clickSignInButton();
		//Assert.assertEquals(driver.getTitle(), "Zero - Log in");
		LoginPage login=new LoginPage();
		Assert.assertEquals(login.getPageTitle(), "Zero - Log in");
		login.doLogin("username", "password");
		AccountSummaryPage accpage=new AccountSummaryPage();
		accpage.navigateToTab("Pay Bills");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		paybills=new PayBillsPage();
		paybills.navigateToTab("Add New Payee");	
	}
	
@Test
  public void addNewPayee() {
	paybills.doAddNewPayee("Prem","", "", "");
  }

@AfterTest
public void afterTest()
{
	basetest.quitDriver();
}
}
