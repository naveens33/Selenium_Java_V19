package extentreportexample;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
	
public class ExtentDemo {
	
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports report;
	public ExtentTest test;
	

	@BeforeTest
	public void beforeTest() {
		//Configure the location to save the report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/TestReport.html");
        // Create an object of Extent Reports
		report = new ExtentReports();
		//Attach the ExtentHtmlReporter object to ExtentReports class and provide dashboard details
		report.attachReporter(htmlReporter);
		report.setSystemInfo("User Name", "Naveen S");
        report.setSystemInfo("Environment", "Production");
		report.setSystemInfo("OS", "Windows 10");
		//Provide report properties like title, report name and theme
		htmlReporter.config().setDocumentTitle("Test Report"); 
		htmlReporter.config().setReportName("Zero Bank- Regression Test"); 
		htmlReporter.config().setTheme(Theme.STANDARD);			
	}
	
	public static String takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
		//Capture the screenshot and return the path of the screenshot.
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/");
	}
	
	@Test
	public void Login() {
		//Create the test by providing test name
		test = report.createTest("Do login to Zero Bank site");
	}
	
	@Test
	public void FeedBack() {
		//Create the test by providing test name
		test = report.createTest("Send the feedback of user experience");
		driver.findElement(By.id("invalid_id"));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE){
			//MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			//To capture screenshot path and store the path of the screenshot in the string "screenshotpath"
			//Calling takeScreenShot method to take screenshot
			String screenshotpath = takeScreenShot(driver, result.getName());
			//Add it in report using fail method and add screenshot using addScreenCaptureFromPath method
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotpath));
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		} 
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
	}

	@AfterClass
	public static void afterClass()
	{
		driver.quit();
	}
	
	@AfterTest
	public void endReport() {
		report.flush();
	}
}

