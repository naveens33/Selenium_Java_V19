package examples;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MediaLinkVerfication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("http://zero.webappsecurity.com/");
		String parentwindow=driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[contains(text(),'http')])[1]")).click();
		//System.out.println(driver.getTitle());
		//driver.findElement(By.xpath("//a[text()='Free Trials']")).click();
		Set<String> handles= driver.getWindowHandles();
		/*for(String handle:handles)
		{
			System.out.print(handle+" - ");
			driver.switchTo().window(handle);
			System.out.println(driver.getTitle());			
		}
		*/
		for(String handle:handles)
		{
			driver.switchTo().window(handle);
			if(driver.getTitle().equals("Legal - About | Micro Focus"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//a[text()='Free Trials']")).click();
		driver.close();
		driver.switchTo().window(parentwindow);
		driver.findElement(By.id("signin_button")).click();
	}
	

}
