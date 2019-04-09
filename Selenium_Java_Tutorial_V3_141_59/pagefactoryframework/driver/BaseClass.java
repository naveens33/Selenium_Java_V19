package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public WebDriver driver = null;
	
	public BaseClass(){
			
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();		
        driver.manage().window().maximize();
        driver.navigate().to("http://zero.webappsecurity.com/");
	}
}
