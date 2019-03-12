package Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScenario {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
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
