package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import driver.BaseClass;
import pages.HomePage;

public class AddNewPayee extends BaseClass {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseClass baseclass=new BaseClass();
		HomePage homepage= PageFactory.initElements(baseclass.driver, HomePage.class);
		homepage.clickOnSignInButton();
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
