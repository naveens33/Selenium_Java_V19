package workingwithpopularbrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\Naveen\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
	}

}
