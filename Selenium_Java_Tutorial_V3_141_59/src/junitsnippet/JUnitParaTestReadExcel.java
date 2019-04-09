package junitsnippet;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JUnitParaTestReadExcel {

	String payeename="";
	String payeeaddress="";
	String account="";
	String payeedetails="";
	
	public JUnitParaTestReadExcel(String m1, String m2,String m3,String m4)
	{
		 payeename=m1;
		 payeeaddress=m2;
		 account=m3;
		 payeedetails=m4;
	}
	
    @Parameters
    public static Collection<String[]> data() {
    	POIReadExcel obj=new POIReadExcel();
        String[][] data = obj.getData();
        return Arrays.asList(data);
    }
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("payeename: "+payeename);
		System.out.println("payeeaddress: "+payeeaddress);
		System.out.println("account: "+account);
		System.out.println("payeedetails: "+payeedetails);
	}
	

}
