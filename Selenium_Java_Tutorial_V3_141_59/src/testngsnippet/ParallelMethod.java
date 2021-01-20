package testngsnippet;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class ParallelMethod {
  @Test
  public void test01() {
	System.out.println("test01 started: "+new Date());
	System.setProperty("webdriver.gecko.driver", "D:\\Naveen\\Selenium\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://zero.webappsecurity.com/");
	System.out.println("test01 finished: "+new Date());
  }
  @Test
  public void test02() throws InterruptedException {
		System.out.println("test02 started: "+new Date());
  	System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	System.out.println("test02 Going to Sleep: "+new Date());
	//Thread.sleep(3000);
	driver.get("http://zero.webappsecurity.com/");
	System.out.println("test02 finished: "+new Date());
  }
  @Test
  public void test03() {
		System.out.println("test03 started: "+new Date());
		System.setProperty("webdriver.ie.driver", "D:\\Naveen\\Selenium\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
	driver.get("http://zero.webappsecurity.com/");
	System.out.println("test03 finished: "+new Date());
  }
}
