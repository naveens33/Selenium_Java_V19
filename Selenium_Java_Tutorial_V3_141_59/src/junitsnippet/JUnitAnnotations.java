package junitsnippet;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitAnnotations {


	@BeforeClass
	public static void setupclass()
	{
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void teardownclass()
	{
		System.out.println("AfterClass");
	}
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After");
	}

	@Test
	public void test_01() {
		System.out.println("Test_01");
	}

	@Test
	public void test_02() {
		System.out.println("Test_02");
	}
	
	@Test
	@Ignore
	public void test_03() {
		System.out.println("Test_03");
	}
	
	@Test
	@Ignore("Joe is not fixed this issue yet")
	public void test_04() {
		System.out.println("Test_04");
	}
	
	
	@Test (expected = NoSuchElementException.class)
	public void test_05() {
		System.out.println("Test_05");
		throw(new NoSuchElementException());
	}
	
	@Test(timeout=100)
	public void test_06() throws InterruptedException {
		Thread.sleep(90);
		System.out.println("Test_06");
	}
}
