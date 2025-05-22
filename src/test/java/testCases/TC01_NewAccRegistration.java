package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC01_NewAccRegistration extends BaseClass{
	
	
	@Test(groups = {"sanity", "master"})	
	public void verify_acc_registrations()
	{
		
		logger.info("*****Starting TC01_NewAccRegistration *****");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAcc();
		logger.info("Clicked on My Account Link");
		hp.clickRegistration();
		logger.info("Clicked on Registration Link");
		
		RegistrationPage regpage = new RegistrationPage(driver);
		
		logger.info("Providing all the details required for Registration");
		
		regpage.setupfirstname(randomeString().toUpperCase());
		regpage.setuplastname(randomeString().toUpperCase());
		regpage.setupemail(randomeString()+"@gmail.com");
		regpage.setupphone(randomeNumbers());
		
		String pass = randomePass();		
		
		regpage.setuppassword(pass);
		regpage.setupcpass(pass);
		regpage.clickIagree();
		logger.info("Clicked on Continue button");
		regpage.clickContinue();
		
		logger.info("Validating Confirmation Message");
		String confmsg = regpage.getconfirmationmsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test FAILED");
			//logger.debug("Debug logs...");
			Assert.fail();
			
		}
		logger.info("*****Finished TC01_NewAccRegistration *****");
	}
	
	
}
