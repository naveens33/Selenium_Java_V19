package testngsnippet;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class TestNgTestCase2 {
	@Parameters("suite-param")
	@BeforeSuite
	public void beforeSuite(String para)
	{
		System.out.println("-BeforeSuite"+para);
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("-AfterSuite");
	}
  @Test
  public void f8() {
	  System.out.println("-----Test8");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("----BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("----AfterMethod"); 
  }

}
