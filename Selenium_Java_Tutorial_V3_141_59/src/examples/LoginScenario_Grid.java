package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class LoginScenario_Grid {

   	  public static final String USERNAME = "kalyani37";
	  public static final String AUTOMATE_KEY = "yRmjMKVkAB56pKd3BV4M";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws MalformedURLException {

		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "Safari");
		    caps.setCapability("browser_version", "10.0");
		    caps.setCapability("os", "OS X");
		    caps.setCapability("os_version", "Sierra");
		    caps.setCapability("resolution", "1024x768");
		    caps.setCapability("name", "Bstack-[Java] Sample Test");
		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().window().maximize();
		
		driver.navigate().to("http://zero.webappsecurity.com/");
		WebElement signin1=driver.findElement(By.id("signin_button"));
		signin1.click();
		
		if("Zero - Log in".equals(driver.getTitle()))
		{
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.name("submit")).click();
			
		}
		else
		{
			System.out.println("You are in the wrong page");
		}
		driver.close();
	}

}
