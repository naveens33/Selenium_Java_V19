package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TransferFundScenario {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("http://zero.webappsecurity.com/");
		WebElement signin1=driver.findElement(By.id("signin_button"));
		signin1.click();
		
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
			
		driver.findElement(By.xpath("//*[@id=\"transfer_funds_tab\"]/a")).click();
			
		WebElement fromaccountele=driver.findElement(By.cssSelector("#tf_fromAccountId"));
		Select fromaccountselect=new Select(fromaccountele);
		//fromaccountselect.selectByIndex(4);
		//fromaccountselect.selectByValue("3");
		fromaccountselect.selectByVisibleText("Credit Card(Avail. balance = $ -265)");
		
		WebElement toaccountele=driver.findElement(By.cssSelector("#tf_toAccountId"));
		Select toaccountselect=new Select(toaccountele);
		toaccountselect.selectByVisibleText("Savings(Avail. balance = $ 1548)");
		
		driver.findElement(By.xpath("//*[@id=\"tf_amount\"]")).sendKeys("1000");
		driver.findElement(By.xpath("//*[@id=\"tf_description\"]")).sendKeys("payment");
		
		driver.findElement(By.cssSelector("#btn_submit")).click();
		
		TransferFundScenario obj=new TransferFundScenario();
		obj.verifyBool(false,driver.findElement(By.cssSelector("#tf_fromAccountId")).isEnabled());
	
		obj.verifyBool(false,driver.findElement(By.cssSelector("#tf_toAccountId")).isEnabled());
			
		driver.findElement(By.cssSelector("#btn_submit")).click();
		String text=driver.findElement(By.xpath("//*[@id=\"transfer_funds_content\"]/div/div/div[1]")).getText();
		obj.verifyText("You successfully submitted your transaction.", text);
	}
	
	void verifyBool(boolean expected, boolean actual)
	{
		if(expected!=actual)
		{
			System.err.println("Value Mismatch error(Bool): expected-"+expected+"\tactual-"+actual);
		}
	}
	
	void verifyText(String expected, String actual)
	{
		if(expected.equals(actual)==false)
		{
			System.err.println("Value Mismatch error(Text): expected-"+expected+"\tactual-"+actual);
		}
	}
}
