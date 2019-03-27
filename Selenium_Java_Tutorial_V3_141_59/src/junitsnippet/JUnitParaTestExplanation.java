package junitsnippet;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JUnitParaTestExplanation {

	int d;
	
	public JUnitParaTestExplanation(int p)
	{
		d=p;
	}
	
	
	@Parameters
    public static List<Integer> data() {
         Integer[] data = new Integer[] {32,43,15,76 };
         return Arrays.asList(data);
    }
  
	@Test
	public void test() {
			assert true == d>30;
			System.out.println(d);
	/*Integer[] d = new Integer[] {32,43,15,76 };
	for(int i=0;i<d.length;i++)
		System.out.println(d[i]);*/
	}

}
