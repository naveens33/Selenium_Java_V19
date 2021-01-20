package testngexamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class AddNewPayeeScenarioWithDataProviderExcel {
	
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

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.findElement(By.xpath("//a[text()='Add New Payee']")).click();
	}
	  
	@Test(dataProvider="dp")
	public void test1(String pname,String paddrs,String pacc,String pdetails) {
		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("np_new_payee_name"))).sendKeys(pname);
		driver.findElement(By.id("np_new_payee_address")).sendKeys(paddrs);
		driver.findElement(By.id("np_new_payee_account")).sendKeys(pacc);
		driver.findElement(By.id("np_new_payee_details")).sendKeys(pdetails);
		driver.findElement(By.id("add_new_payee")).click();
		String confirmationmsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert_content"))).getText();
		//Assert.assertEquals(confirmationmsg, "The new payee sdfjg was successfully created.", "Validating confirmation msessage");
		//AssertJUnit.assertTrue(confirmationmsg.contains(pname), "Validating confirmation msessage");
		
		WebElement payeeele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sp_payee")));
		Select payee=new Select(payeeele);
		List<WebElement> options=payee.getOptions();
		List<String> optionstext=new ArrayList<String>();
		/*for(int i=0;i<options.size();i++)
		{
			optionstext.add(options.get(i).getText());
		}*/
		for(WebElement option:options)
		{
			optionstext.add(option.getText());
		}
		//AssertJUnit.assertTrue(optionstext.contains(pname),"Payee Name not found");
	}

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

  @DataProvider
  public Object[][] dp() throws IOException
  {
	  ReadExcelData obj=new ReadExcelData();
	  return obj.getdata();
  }
}
