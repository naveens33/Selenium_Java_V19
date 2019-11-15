package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

	By SignInButton=By.id("signin_button");
	
	public void clickSignInButton()
	{
		click(SignInButton);	
	}
	
}
