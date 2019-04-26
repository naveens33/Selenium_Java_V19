package examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.Console;


public class PurchaseForeignCurrency1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		try
		{
			driver.navigate().to("http://zero.webappsecurity.com/");
			WebElement signin1=driver.findElement(By.id("signin_button"));
			signin1.click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.name("submit")).click();
			
			driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();
			driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
			
			//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			WebDriverWait wait=new WebDriverWait(driver, 3);
			
			//Thread.sleep(3000);
			
			WebElement currencyele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pc_currency']")));
			Select currencyselect=new Select(currencyele);
			currencyselect.selectByVisibleText("Denmark (krone)");
			
			WebElement sellrateele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sp_sell_rate")));
			double actualsellrate=Double.parseDouble(sellrateele.getText().split(" ")[4]);
			System.out.println(actualsellrate);
			
			double amount=100;
			
			double expectedval=actualsellrate*amount;
			
			driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys(""+amount);
			
			
			WebElement radiobutton =driver.findElement(By.id("pc_inDollars_false"));
			if(radiobutton.isSelected()==false)
			{
				radiobutton.click();
			}
			
			driver.findElement(By.id("pc_calculate_costs")).click();
			
			WebElement conversionamtele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pc_conversion_amount")));
			double convamt=Double.parseDouble(conversionamtele.getText().split(" ")[4]);
			
			System.out.println("Expected: "+expectedval+"\t"+"Actual: "+convamt);
			if(expectedval!=convamt)
			{
				System.out.println("TestCase failed");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			//driver.quit();	
		}
	}

}
