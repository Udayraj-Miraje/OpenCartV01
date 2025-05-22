package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	

	//Constructor
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//Locators
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement txt_first_name;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txt_last_name;
	@FindBy(xpath = "//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement txt_phone;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txt_pass;
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txt_confirm_pass;
	//@FindBy(name = "newsletter")WebElement radio_yes;
	@FindBy(xpath = "//input[@name='agree']") WebElement radio_I_Agree;
	@FindBy(xpath = "//input[@value='Continue']") WebElement btn_Continue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgconfirmation;
	
	//Actions
	
	public void setupfirstname(String fname)
	{
		txt_first_name.sendKeys(fname);
	}
	
	public void setuplastname(String lname)
	{
		txt_last_name.sendKeys(lname);
	}
	
	public void setupemail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setupphone(String phone)
	{
		txt_phone.sendKeys(phone);
	}
	
	public void setuppassword(String pass)
	{
		txt_pass.sendKeys(pass);
	}
	
	public void setupcpass(String cpass)
	{
		txt_confirm_pass.sendKeys(cpass);
	}
	
	public void clickIagree()
	{
		radio_I_Agree.click();
	}
	
	public void clickContinue()
	{
		btn_Continue.click();
	}
	
	public String getconfirmationmsg()
	{
			try {
				return (msgconfirmation.getText());
			}
			catch (Exception e)
			{
				return (e.getMessage());
			}
	}
	
}
