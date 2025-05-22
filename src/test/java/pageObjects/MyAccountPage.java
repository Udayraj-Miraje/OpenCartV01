package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	//Constructor 
	public  MyAccountPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Locators
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement page_name;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement Link_Logout;
	
	//Actions
	public boolean checkname()
	{
		try {
			boolean status = page_name.isDisplayed();
			return status;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public void clicklogout()
	{
		Link_Logout.click();
	}
}
