package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import driver.BaseClass;
import org.junit.Assert;

import pages.HomePage;
import pages.LoginPage;

public class AddNewPayee{

	@BeforeClass
	public static void setUpBeforeClass(){
		BaseClass baseclass=new BaseClass();
		HomePage homepage= PageFactory.initElements(baseclass.driver, HomePage.class);
		homepage.clickOnSignInButton();
		LoginPage loginpage=PageFactory.initElements(baseclass.driver, LoginPage.class);
		Assert.assertEquals("Zero - Log in", baseclass.driver.getTitle());
		loginpage.EnterCredential("username", "password");
		loginpage.ClickOnSignInButton();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("Hello");
	}

}
