package testngsnippet;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestNgDataProvider {
  @Test(dataProvider = "dp")
  public void f(String uname, String pword) {
	  System.out.println(uname+" "+pword);
  }

  @DataProvider(name="dp")
  public String[][] data() {
    return new String[][] {
      { "Test0109", "PW0109" },
      { "Test0210", "PW0210" },
    };
  }
}
