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

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		try {
			driver.manage().window().maximize();
			
			driver.navigate().to("http://zero.webappsecurity.com/");
			WebElement signin1=driver.findElement(By.id("signin_button"));
			signin1.click();
			
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.name("submit")).click();
				
			driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();
			driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
			
			/*
			 * Unconditional Wait- will make the tool to wait until certain amount of time and then proceed further
			 */
			//Thread.sleep(5000);
			
			/*
			 * Conditional Wait- 
			 * 1. Implicit Wait
			 * 2. Explicit Wait
			 * 3. Fluent Wait
			 */
			
			/*
			 * Implicit Wait
			 * - apply globally to every find element call
			 * - will ping the application by default frequency to find the element 
			 * - only check for the existence of an object i.e. Only presence of the element 
			 * - ***Best practice is to not use implicit waits if possible
			 */
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			/*
			 * Fluent Wait
			 * - only apply on a per transaction basis.
			 * - require that you define the wait between checks of the application for an object/condition as well as the overall timeout of the transaction.  
			 * Additionally you must tell fluent waits not to throw an exception when they don’t find an object as best practice.
			 */
			/*
			Wait wait = new FluentWait(driver)
					.withTimeout(Duration.ofSeconds(6))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(Exception.class);
			WebElement currele=(WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pc_currency")));
			*/
			
			/*
			 * Explicit Wait
			 * - only apply on a per transaction basis
			 * - ping the application every 500ms checking for the condition of the wait to be true
			 * - wait by using predefined expected conditions
			 * - like fluent wait we can control the polling time in Explicit wait using the below constructor,
			 */
			//WebDriverWait wait=new WebDriverWait(driver, 5, 2000);
			
			WebDriverWait wait=new WebDriverWait(driver, 5);
			WebElement currele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pc_currency")));
			
			Select currency=new Select(currele);
			currency.selectByVisibleText("Denmark (krone)");
			
			String text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sp_sell_rate"))).getText();
			
			double sellrate=Double.parseDouble(text.split(" ")[4]);
			double amount=100;
			double expected=sellrate*amount;
			
			driver.findElement(By.id("pc_amount")).sendKeys(""+amount);
			WebElement selected_currency_checkbox=driver.findElement(By.id("pc_inDollars_false"));
			if(selected_currency_checkbox.isSelected()==false)
			{
				selected_currency_checkbox.click();
			}
			driver.findElement(By.id("pc_calculate_costs")).click();
			text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pc_conversion_amount"))).getText();
			
			double converted_amount=Double.parseDouble(text.split(" ")[4]);
			verifyDouble(expected,converted_amount,"Incorrect converted amount");
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
	
	public static void verifyDouble(double expected,double actual,String message)
	{
		if(expected!=actual)
		{
			System.out.println(message+"\nVerfication Error- Expected: "+expected+" Actual: "+actual);
		}
	}

}
