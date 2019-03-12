package Examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PurchaseForeignCurrency {

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
			
			Thread.sleep(3000);
			
			WebElement currencyele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pc_currency']")));
			Select currencyselect=new Select(currencyele);
			currencyselect.selectByVisibleText("Denmark (krone)");
			
			driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("100");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		driver.quit();
	}

}
