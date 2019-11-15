package base;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {
	
	public WebDriver driver;
	
  public BaseTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.navigate().to("http://zero.webappsecurity.com/");
  }
  
  public WebDriver getDriver()
  {
	  return driver;
  }
  
  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

}
