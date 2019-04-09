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

	
	String uname="";
	String pword="";
	
	public JUnitParaTest(String m1, String m2)
	{
		uname=m1;
		pword=m2;
	}
	
    @Parameters
    public static Collection<String[]> data() {
        String[][] data = new String[][] { { "Test123" ,"PW123" },{"Test345","PW345"} };
        return Arrays.asList(data);
    }

	
	@Test
	public void test() {
		System.out.println("----Test parameter1: "+uname+" parameter2: "+pword);
	}
}
