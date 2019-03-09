package Examples;

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
		assert("Zero - Account Summary"==driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"transfer_funds_tab\"]/a")).click();
		
		WebElement fromaccountele=driver.findElement(By.cssSelector("#tf_fromAccountId"));
		Select fromaccountsele=new Select(fromaccountele);
		//fromaccountsele.selectByIndex(4);
		//fromaccountsele.selectByValue("5");
		fromaccountsele.selectByVisibleText("Credit Card(Avail. balance = $ -265)");
		
		WebElement toaccountele=driver.findElement(By.xpath("//*[@id=\"tf_toAccountId\"]"));
		Select toaccountsele=new Select(toaccountele);
		toaccountsele.selectByVisibleText("Checking(Avail. balance = $ -500.2)");
		
		driver.findElement(By.cssSelector("#tf_amount")).sendKeys("1000");
		driver.findElement(By.cssSelector("#tf_description")).sendKeys("Payment");
		
		driver.findElement(By.xpath("//*[@id=\"btn_submit\"]")).click();
		
		boolean fromaccountbool=driver.findElement(By.cssSelector("#tf_fromAccountId")).isEnabled();
		
		assert(false==fromaccountbool);
		
		boolean toaccountbool=driver.findElement(By.xpath("//*[@id=\"tf_toAccountId\"]")).isEnabled();
		
		assert(false==toaccountbool);
		
		assert(false==driver.findElement(By.id("tf_amount")).isEnabled());
		
		assert(false==driver.findElement(By.id("tf_description")).isEnabled());
		
		driver.findElement(By.id("btn_submit")).click();
		
		String message=driver.findElement(By.xpath("//*[@id=\"transfer_funds_content\"]/div/div/div[1]")).getText();

		assert("You successfully submitted your transaction.".equals(message));
		//driver.close();
	}

}
