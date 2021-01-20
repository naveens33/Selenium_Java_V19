package testngsnippet;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class ParallelClass1 {
	WebDriver driver;
	@Test
  public void f() {
	  driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("class01 started: "+new Date());
	  System.setProperty("webdriver.gecko.driver", "D:\\Naveen\\Selenium\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() {

		System.out.println("class01 finished: "+new Date());
		driver.quit();
  }

}
