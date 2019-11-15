package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	public WebDriver driver;
	public BaseTest() {}
	
	public BaseTest(String browser,String url)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	public void quitDriver()
	{
		driver.quit();
	}
}
