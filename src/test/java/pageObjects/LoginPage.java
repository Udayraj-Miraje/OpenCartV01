package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	//Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Locators
	@FindBy(xpath = "//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txt_pass;
	@FindBy(xpath = "//input[@value='Login']") WebElement btn_login;
	
	//Actions
	
	public void setupemail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setuppass(String pass)
	{
		txt_pass.sendKeys(pass);
	}

	public void clicklogin()
	{
		btn_login.click();
		
		
	}
	
}
