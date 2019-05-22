package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	 @FindBy(how=How.ID, using="signin_button") 
	 WebElement signInButton;
	 @FindBy(how=How.XPATH, using="//strong[text()='Online Banking']") 
	 WebElement onlineBankingLink;
	 
	 public void clickOnSignInButton()
	 {
		 signInButton.click();
	 }	
}
