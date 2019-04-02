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
public class JUnitParaTest {

	/*
	String uname="";
	String pword="";
	
	public JUnitParaTest(String m1, String m2)
	{
		uname=m1;
		pword=m2;
	}
	
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "Test123" ,"PW123" },{"Test345","PW345"} };
        return Arrays.asList(data);
    }
    */
	String data1;
	String data2;
	public JUnitParaTest(String p1,String p2)
	{
		System.out.println(p1);
	}
    @Parameters
    public static Collection<String[]> data() {
        Collection<String[]> obj=new ArrayList<String[]>();
        String[] str=new String[4];
        str[0]="hello";
        str[1]="prem";
        str[2]="hello";
        str[3]="prem";
        obj.add(str);
        return obj;
    }
    
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//System.out.println("----Test parameter1: "+data[0]+" parameter2: "+data[1]);
	}
	
/*	@Test
	public void test() {
		System.out.println("----Test parameter1: "+uname+" parameter2: "+pword);
	}
*/
}
