package testngexamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AddNewPayeeScenario {
	
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("http://zero.webappsecurity.com/");
			WebElement signin1=driver.findElement(By.id("signin_button"));
			signin1.click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();
			driver.findElement(By.xpath("//a[text()='Add New Payee']")).click();
	}

	@BeforeMethod
	public void beforeMethod() {
	  }
	  
	@Test
	public void test1() {
		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("np_new_payee_name"))).sendKeys("Prem Kumar");
		driver.findElement(By.id("np_new_payee_address")).sendKeys("Bangalore");
		driver.findElement(By.id("np_new_payee_account")).sendKeys("56464894564");
		driver.findElement(By.id("np_new_payee_details")).sendKeys("Brother");
		driver.findElement(By.id("add_new_payee")).click();
		String confirmationmsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert_content"))).getText();
		//Assert.assertEquals(confirmationmsg, "The new payee sdfjg was successfully created.", "Validating confirmation msessage");
		AssertJUnit.assertTrue(confirmationmsg.contains("Prem Kumar"), "Validating confirmation msessage");
	}

  @AfterMethod
  public void afterMethod() {
  }

  @AfterClass
  public void afterClass() {
  }

}
