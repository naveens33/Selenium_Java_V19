package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	
	public BasePage() {}
	
	public BasePage(WebDriver driver)
	{
		BasePage.driver=driver;
	}
	
	public void click(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public void enterText(By locator,String text, boolean applywait)
	{
		if(applywait ==true)
			waitForElement(locator,"visibility").sendKeys(text);
		else
			driver.findElement(locator).sendKeys(text);
	}
	
	public WebElement getElementByText(By locator, String text)
	{
		List <WebElement> tabs=driver.findElements(locator);
		for(WebElement tab: tabs)
		{
			if(tab.getText().equals(text))
			{
				return tab;
			}
		}
		return null;
	}
	
	
	public void selectFromDropDown(By locator,String text,boolean applywait)
	{
		if(applywait==true)
		{
			Select select=new Select(waitForElement(locator,"visibility"));
			select.selectByVisibleText(text);			
		}
		else
		{
			Select select=new Select(driver.findElement(locator));
			select.selectByVisibleText(text);
		}
	}
	
	public WebElement waitForElement(By locator,String condition)
	{
		WebDriverWait wait=new WebDriverWait(driver,3);
		switch(condition)
		{
		case "visibility":
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
		}
		
		return null;
	}
}
