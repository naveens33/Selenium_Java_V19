package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

	By username=By.id("user_login");
	By password=By.id("user_password");
	By SignInButton=By.name("submit");
	
	public void doLogin(String username,String password)
	{
		enterText(this.username,username);
		enterText(this.password,password);
		click(SignInButton);
	}
}
