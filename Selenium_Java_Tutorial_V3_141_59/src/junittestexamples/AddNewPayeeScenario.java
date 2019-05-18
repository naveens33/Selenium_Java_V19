package junittestexamples;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@RunWith(Parameterized.class)
public class AddNewPayeeScenario {

	
	String payeename="";
	String payeeaddress="";
	String account="";
	String payeedetails="";
	static WebDriver driver;
	
	public AddNewPayeeScenario(String m1, String m2,String m3, String m4)
	{
		 payeename=m1;
		 payeeaddress=m2;
		 account=m3;
		 payeedetails=m4;
	}
	
    @Parameters
    public static Collection<String[]> data() throws IOException {
    	ReadExcelData obj=new ReadExcelData();
        String[][] data = obj.getData();
        return Arrays.asList(data);
    }

	@BeforeClass
	public static void setupclass()
	{
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
	@Before
	public void setUp()
	{
		driver.findElement(By.xpath("//a[text()='Add New Payee']")).click();
	}
	
	@Test
	public void test() {
		WebDriverWait wait=new WebDriverWait(driver, 3);
		WebElement payeenameele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("np_new_payee_name")));
		payeenameele.sendKeys(payeename);
		driver.findElement(By.id("np_new_payee_address")).sendKeys(payeeaddress);
		driver.findElement(By.id("np_new_payee_account")).sendKeys(account);
		driver.findElement(By.id("np_new_payee_details")).sendKeys(payeedetails);
		driver.findElement(By.id("add_new_payee")).click();
		
		
		Assert.assertEquals(driver.findElement(By.id("alert_content")).getText().contains(payeename),true);
		
		WebElement payeeele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sp_payee")));
		Select payeesel=new Select(payeeele);
		List<WebElement> options=payeesel.getOptions();
		List<String> option_text = new ArrayList<String>();
		for(WebElement option : options)
		{
			option_text.add(option.getText());
		}
		
		Assert.assertEquals(true, option_text.contains(payeename));
	}
}
