package testngsnippet;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class ParallelDataProviders {
  @Test(dataProvider = "dp")
  public void f(String searchTerm, String count) {
	  System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/");
	  WebElement search = driver.findElement(By.id("searchTerm"));
	    search.clear();
	    search.sendKeys(searchTerm);
	    search.sendKeys(Keys.ENTER);
		List<WebElement> links= driver.findElements(By.xpath("//a[starts-with(text(),'Zero -')]"));
		Assert.assertEquals((int)Double.parseDouble(count), links.size());
  }

  @DataProvider(parallel=true)
  public Object[][] dp() throws IOException { 
      ReadExcelData obj = new ReadExcelData();
  	  return obj.getData();
    
  }
}
