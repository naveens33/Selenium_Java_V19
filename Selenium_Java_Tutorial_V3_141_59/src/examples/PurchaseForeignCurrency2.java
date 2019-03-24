package examples;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseForeignCurrency2 {

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
			WebElement calculate_button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pc_calculate_costs")));
			calculate_button.click();
			

        
			Alert alertbox=driver.switchTo().alert();
			
			String message=alertbox.getText();
			verifyText("Please, ensure that you have filled all the required fields with valid values.12",message);
			alertbox.accept();
			TakesScreenshot scrShot=((TakesScreenshot)driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File("D:\\screenshotjava.png");
            
            FileUtils.copyFile(SrcFile, DestFile);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		//driver.quit();
	}

	private static void verifyText(String string, String message) {
		if(string.equals(message)==false) {
			System.err.println("Message is wrong");
		}
		
	}

}
