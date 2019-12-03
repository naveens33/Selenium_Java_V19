package examples;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class AddExtensionChrome {

	public static void main(String[] args) {

			System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("D:\\Naveen\\Selenium\\Google Translate(2.0.7)2019-09-23.crx"));
			ChromeDriver driver = new ChromeDriver(options);			
	}
}
