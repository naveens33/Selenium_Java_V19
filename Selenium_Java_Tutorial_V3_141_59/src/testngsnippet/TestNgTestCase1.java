package testngsnippet;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.NoSuchElementException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

public class TestNgTestCase1 {
	@BeforeGroups("important")
	public void beforeGroups()
	{
		System.out.println("-----BeforeGroups");
	}
	@AfterGroups("important")
	public void afterGroups()
	{
		System.out.println("-----AfterGroups");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("--BeforeTest");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("--AfterTest");
	}
  @BeforeClass
  public void beforeClass()
  {
	  System.out.println("---BeforeClass");
  }
	
  @AfterClass
  public void afterClass()
  {
	  System.out.println("---AfterClass");
  }
  
	@Test
  public void f1() {
	  System.out.println("-----Test1");
  }
  @Test
  public void f2() {
	  System.out.println("-----Test2");
  }
  @Test(groups="important")
  public void f3() {
	  System.out.println("-----Test3");
  }
  @Test(groups="important")
  public void f4() {
	  System.out.println("-----Test4");
  }
  @Test(enabled=false)
  public void f5() {
	  System.out.println("-----Test5");
  }
  @Test(expectedExceptions=NoSuchElementException.class)
  public void f6() {
	  System.out.println("-----Test6");
	  throw new NoSuchElementException();
  }
  @Test(timeOut=1000)
  public void f7() throws InterruptedException {
	  System.out.println("-----Test7");
	  Thread.sleep(1001);
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
