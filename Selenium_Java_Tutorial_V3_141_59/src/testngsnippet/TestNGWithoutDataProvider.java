package testngsnippet;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGWithoutDataProvider {
  @Test
  public void f() {
	  int s[][]= new int[][] {
	      new int[] { 12,10},
	      new int[] { 13,16},
	      new int[] { 15,12},
	    };
	    for(int i=0;i<3;i++)
	    {
	    	System.err.println(s[i][0]+"  "+s[i][1]);
	    	AssertJUnit.assertTrue(s[i][0] < s[i][1]);   		
	    }
  }
}
