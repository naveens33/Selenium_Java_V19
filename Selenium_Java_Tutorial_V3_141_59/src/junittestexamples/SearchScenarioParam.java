package junittestexamples;

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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

@RunWith(Parameterized.class)
public class SearchScenarioParam {

	static WebDriver driver;
	
	String searchterm;
	int count;
	
	public SearchScenarioParam(String p1,int p2)
	{
		searchterm=p1;
		count=p2;
	}
	
	
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "Account" ,2 },{"Map",1} };
        return Arrays.asList(data);
    }
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.navigate().to("http://zero.webappsecurity.com/");
	}


	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		driver.findElement(By.id("searchTerm")).sendKeys(searchterm);
		driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);
		List<WebElement> elements=driver.findElements(By.xpath("//a[contains(text(),'Zero - ')]"));
		Assert.assertEquals(count, elements.size());
	
		for(WebElement ele:elements)
		{
			highlight(driver,ele);
			Assert.assertTrue(ele.getText().contains(searchterm));
		}
	}
	
	public void highlight(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}
}
