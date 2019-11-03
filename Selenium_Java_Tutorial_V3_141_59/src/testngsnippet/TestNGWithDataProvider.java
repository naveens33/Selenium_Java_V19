package testngsnippet;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGWithDataProvider {
	  @Test(dataProvider="dp")
	  public void f(Integer x,Integer y) {
		 
		    	System.err.println(x+" "+y);
		    	Assert.assertTrue(x<y);   		
		   
	  }
	  
	  @DataProvider
	  public Object[][] dp()
	  {
		  return new Object[][] {
		      new Object[] { 12,10},
		      new Object[] { 13,16},
		      new Object[] { 15,12},
		    };
	  }
}
