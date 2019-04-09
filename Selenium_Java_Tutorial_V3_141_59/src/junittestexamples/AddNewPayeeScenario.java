package junittestexamples;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AddNewPayeeScenario {

	
	String payeename="";
	String payeeaddress="";
	String account="";
	String payeedetails="";
	
	public AddNewPayeeScenario(String m1, String m2,String m3, String m4)
	{
		 payeename=m1;
		 payeeaddress=m2;
		 account=m3;
		 payeedetails=m4;
	}
	
    @Parameters
    public static Collection<String[]> data() throws IOException {
    	ReadExcelData obj=new ReadExcelData();
        String[][] data = obj.getData();
        return Arrays.asList(data);
    }

	
	@Test
	public void test() {
		System.out.println(payeename+" "+payeeaddress+" "+account+" "+payeedetails);
	}
	

	
}
