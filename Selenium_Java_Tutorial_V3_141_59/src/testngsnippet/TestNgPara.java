package testngsnippet;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgPara {
	
	@Parameters({"searchterm","browsername"})
	  @BeforeClass
	  public void beforeClass(@Optional("Loan") String value,String value2)
	  {
		
		  System.out.println("**************** "+value2);
	  }
  @Test
  @Parameters("searchterm")
  public void f(@Optional("Loan") String value) {
	  System.out.println("**************** "+"Nothing");
  }
  
  @Test(dataProvider = "dp")
  public void f(String uname, String pword) {
	  System.out.println(uname+" "+pword);
  }

  @DataProvider(name="dp")
  public String[][] data() {
	  System.out.println("*******************************************************From DataProvide");
    return new String[][] {
      { "Test0109", "PW0109" },
      { "Test0210", "PW0210" },
    };
  }
}
