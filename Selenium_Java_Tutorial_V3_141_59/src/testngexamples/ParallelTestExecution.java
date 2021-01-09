package testngexamples;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class ParallelTestExecution {
    @Test    
    public void executSessionOne(){
            //First session of WebDriver
        System.setProperty("webdriver.chrome.driver","D:\\Naveen\\Selenium\\chromedriver_win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            //Goto guru99 site
            driver.get("http://demo.guru99.com/V4/");
        }
        
    @Test    
        public void executeSessionTwo(){
            //Second session of WebDriver
        System.setProperty("webdriver.chrome.driver","D:\\\\Naveen\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            //Goto guru99 site
        driver.get("http://zero.webappsecurity.com/");
        
        }
        
    @Test    
        public void executSessionThree(){
            //Third session of WebDriver
        System.setProperty("webdriver.chrome.driver","D:\\\\Naveen\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            //Goto guru99 site
        driver.get("https://www.google.com/");
        //find user name text box and fill it
        driver.findElement(By.name("uid")).sendKeys("Driver 3");
        
        }        
}