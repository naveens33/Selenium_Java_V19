package testngsnippet;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgPara {
  @Test
  @Parameters("searchterm")
  public void f(@Optional("Loan") String value) {
	  System.out.println(value);
  }
}
