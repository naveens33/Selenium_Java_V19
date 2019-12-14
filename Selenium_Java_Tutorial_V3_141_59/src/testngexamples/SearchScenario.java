package testngexamples;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testng_snippets.ReadExcelData;

public class SearchScenario {
	
	WebDriver driver;
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://zero.webappsecurity.com/");
	}
	
	  @Test(dataProvider="dp")
	  public void f(String term,String count) {
		   driver.findElement(By.id("searchTerm")).sendKeys(term);
		   driver.findElement(By.id("searchTerm")).sendKeys(Keys.ENTER);
		   List<WebElement> elements=driver.findElements(By.xpath("//a[contains(text(),'Zero -')]"));
		   Assert.assertEquals(elements.size(), Integer.parseInt(count));
	  }
	  
	  @DataProvider
	  public Object[][] dp() throws IOException
	  {
		  ReadExcelData obj=new ReadExcelData();
		  return obj.getData();
	  }
}
