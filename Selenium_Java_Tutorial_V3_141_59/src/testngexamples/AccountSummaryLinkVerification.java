package testngexamples;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AccountSummaryLinkVerification {
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		    System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.navigate().to("http://zero.webappsecurity.com/");
			driver.findElement(By.id("signin_button")).click();
			
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.name("submit")).click();
			
			Assert.assertEquals("Zero - Account Summary",driver.getTitle());
	  }
	@Test(priority=1)
	  public void verifyInvestmentAccountsLinks() {
	  driver.findElement(By.xpath("//a[text()='Brokerage']")).click();
	  
	  WebDriverWait wait=new WebDriverWait(driver, 3);
	  
	  WebElement accountele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aa_accountId")));
	  Select account=new Select(accountele);
	  String selectedvalue=account.getFirstSelectedOption().getText();
	  Assert.assertEquals("Brokerage",selectedvalue);
	}
	
	@Test(priority=2, dataProvider="Link")
	  public void verifyCreditAccountsLinks(String Link) {
	  driver.findElement(By.xpath("//a[text()='"+Link+"']")).click();
	  
	  WebDriverWait wait=new WebDriverWait(driver, 3);
	  
	  WebElement accountele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aa_accountId")));
	  Select account=new Select(accountele);
	  String selectedvalue=account.getFirstSelectedOption().getText();
	  Assert.assertEquals(Link,selectedvalue);
	}
	
	@Test(priority=3)
	@Parameters("Link")
	  public void verifyLoanAccountsLinks(@Optional("Loan") String Link) {
		System.out.println(Link);
	  driver.findElement(By.xpath("//a[text()='"+Link+"']")).click();
	  
	  WebDriverWait wait=new WebDriverWait(driver, 3);
	  
	  WebElement accountele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aa_accountId")));
	  Select account=new Select(accountele);
	  String selectedvalue=account.getFirstSelectedOption().getText();
	  Assert.assertEquals(Link,selectedvalue);
	}
	
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
	  driver.navigate().back();
  }

  @AfterTest
  public void afterTest() {
	  //driver.quit();
  }

  @DataProvider(name="Link")
     public String[] getData(){
     return new String[]
     	{
     		 "Checking",
             "Credit Card"
         };
  }
}
