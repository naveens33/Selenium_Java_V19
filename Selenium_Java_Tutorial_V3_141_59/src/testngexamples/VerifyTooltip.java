package testngexamples;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class VerifyTooltip {
	WebDriver driver;  
	@BeforeTest
	  public void beforeTest() {
		    System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.navigate().to("http://zero.webappsecurity.com/");
			driver.findElement(By.id("signin_button")).click();
	  }

	@Test
  public void LoginPageTooltip() {
	  Actions action=new Actions(driver);
	  action.moveToElement(driver.findElement(By.id("credentials"))).build().perform();
	  Assert.assertEquals(driver.findElement(By.cssSelector(".tooltip-inner")).getText(),"Login/Password - username/password");
	}
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
