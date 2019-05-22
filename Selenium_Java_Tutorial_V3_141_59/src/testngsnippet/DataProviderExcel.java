package testngsnippet;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderExcel {

  @Test(dataProvider = "dp2")
  public void f2(String p1, String p2,String p3,String p4 ) {
	  System.out.println(p1+"/"+p2+"/"+p3+"/"+p4);
  }
  
  @DataProvider
  public Object[][] dp2() throws IOException {
	  ReadExcelData obj=new ReadExcelData();
	  String[][] data = obj.getData();
      return data;
    }
}
