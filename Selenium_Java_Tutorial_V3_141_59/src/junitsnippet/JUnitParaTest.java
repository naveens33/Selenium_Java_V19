package junitsnippet;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

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
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "Test123" ,"PW123" },{"Test345","PW345"} };
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
		System.out.println("----Test parameter1: "+uname+" parameter2: "+pword);
	}

}
