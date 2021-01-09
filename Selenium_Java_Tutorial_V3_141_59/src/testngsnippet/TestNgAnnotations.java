package testngsnippet;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

public class TestNgAnnotations {
  
  @BeforeClass
  public void beforeClass()
  {
	  System.out.println("----BeforeClass");
  }
  @AfterClass
  public void afterClass()
  {
	  System.out.println("----AfterClass");
  }
  @BeforeTest
  public void beforeTest()
  {
	  System.out.println("-----BeforeTest");
  }
  
  @AfterTest
  public void afterTest()
  {
	  System.out.println("-----AfterTest");
  }
  
	@BeforeGroups("Important")
	public void beforeGroups() {
		System.out.println("---BeforeGroups");
	}

	@AfterGroups("Important")
	public void afterGroups() {
		System.out.println("---AfterGroups");
	}
  
  @Test
  public void f1() {
	  System.out.println("-Test1");
  }
  @Test
  public void f2() {
	  System.out.println("-Test2");
  }

  @Test(groups = "Important")
  public void f3() {
	  System.out.println("-Test3");
  }

  @Test(enabled=false)
  public void f4() {
	  SoftAssert obj=new SoftAssert();
	  AssertJUnit.assertEquals(5, 6);
	  System.out.println("-Test4");
  }  
  
  @Test(expectedExceptions = NoSuchElementException.class)
  public void f5() {
	  System.out.println("-Test5");
	  throw(new NoSuchElementException(null));
  }  
  
  @Test(timeOut = 1000)
  public void f6() throws InterruptedException {
	  System.out.println("-Test6");
	  Thread.sleep(1001);
  } 
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("--BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("--AfterMethod");
  }
}
