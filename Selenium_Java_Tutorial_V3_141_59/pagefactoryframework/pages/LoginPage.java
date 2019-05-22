package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {


	 @FindBy(how=How.ID, using="user_login") 
	 WebElement LoginTextField;
	 
	 @FindBy(how=How.ID, using="user_password") 
	 WebElement PasswordTextField;
	 
	 @FindBy(how=How.NAME, using="submit") 
	 WebElement SignInButton;
	 
	 public void EnterCredential(String uname,String pword)
	 {
		 LoginTextField.sendKeys(uname);
		 PasswordTextField.sendKeys(pword);
	 }

	 public void ClickOnSignInButton()
	 {
		 SignInButton.click();
	 }

}
