package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	//Constructor
	public 	HomePage(WebDriver driver)
	{	
		super(driver);
		
	}
		
	
	//Locators
	
	@FindBy(xpath = "//a[@title='My Account']") WebElement link_My_Acc;
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement link_Registration;
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement link_login;

	
	//Actions
	
	public void clickMyAcc()
	{
		link_My_Acc.click();
	}
	
	public void clickRegistration()
	{
		link_Registration.click();
	}
	
	public void clickLogin()
	{
		link_login.click();
	}
	
	
}


