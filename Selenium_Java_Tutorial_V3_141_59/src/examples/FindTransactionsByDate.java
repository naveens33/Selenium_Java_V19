package examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindTransactionsByDate {
	static WebDriver driver;
	public static void main(String[] args) throws ParseException {
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		//driver.navigate().to("http://zero.webappsecurity.com/");
		driver.get("http://zero.webappsecurity.com/");
		WebElement signin=driver.findElement(By.id("signin_button"));
		signin.click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//a[text()='Account Activity']")).click();
		driver.findElement(By.xpath("//a[text()='Find Transactions']")).click();

		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aa_fromDate"))).click();
		selectdate("20-May-2018");
	}
	
	public static void selectdate(String date) throws ParseException {
		Date m = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(date.split("-")[1]);
		Calendar cal = Calendar.getInstance();
		cal.setTime(m);
		int month = cal.get(Calendar.MONTH);
		gotoyear(Integer.parseInt(date.split("-")[2]));
		gotomonth(month);
		date=date.split("-")[0];
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='"+date+"']")).click();
	
	}
	
	private static void gotomonth(int month) throws ParseException {

		while(true)
		{
			Date d = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().substring(0, 3));
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			int Month = cal.get(Calendar.MONTH);
			
			if(month<Month)
			{
				driver.findElement(By.xpath("//span[text()='Prev']")).click();				
			}
			else if (month>Month)
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			else
			{
				break;
			}
		}
		
	}

	public static void gotoyear(int year)
	{
		while(true)
		{
			int Year=Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());
			if(year<Year)
			{
				driver.findElement(By.xpath("//span[text()='Prev']")).click();				
			}
			else if (year>Year)
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			else
			{
				break;
			}
		}
	}
}
