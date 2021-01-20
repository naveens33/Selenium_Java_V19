package testngsnippet;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class ParallelClass2 {
	WebDriver driver;
	@Test
  public void f() {
	  driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("class02 started: "+new Date());
	  System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
			
  }

  @AfterClass
  public void afterClass() {

		System.out.println("class02 finished: "+new Date());
		driver.quit();
  }

}
