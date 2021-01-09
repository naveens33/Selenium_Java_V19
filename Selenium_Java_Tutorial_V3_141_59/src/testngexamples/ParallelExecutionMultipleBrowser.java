package testngexamples;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ParallelExecutionMultipleBrowser {
	static WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://zero.webappsecurity.com/");
  }
  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browserName) throws Exception {
	  if (browserName.equalsIgnoreCase("Firefox")) {
    	  System.setProperty("webdriver.gecko.driver", "D:\\Naveen\\Selenium\\geckodriver\\geckodriver.exe");
          driver = new FirefoxDriver();
      }
      else if (browserName.equalsIgnoreCase("Chrome")) {
    	  System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();  
      }
      else if (browserName.equalsIgnoreCase("ie")) {
    	  System.setProperty("webdriver.gecko.driver", "D:\\Naveen\\Selenium\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
      }
      else {
          throw new Exception("Browser is not correct");
      }
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

}
