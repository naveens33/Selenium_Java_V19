package workingwithpopularbrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "D:\\Naveen\\Selenium\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		
		WebDriver driver=new InternetExplorerDriver();
		
	}

}
