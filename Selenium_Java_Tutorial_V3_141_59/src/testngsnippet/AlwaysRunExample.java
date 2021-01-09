package testngsnippet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlwaysRunExample {
  @Test
  public void method1() {
	  Assert.fail();
	 System.out.println("Method 1");
  }
  @Test(dependsOnMethods="method1", alwaysRun=true)
  public void method2() {
	  System.out.println("Method 2");
  }
  @Test(dependsOnMethods="method1")
  public void method3() {
	  System.out.println("Method 3");
  }
}
