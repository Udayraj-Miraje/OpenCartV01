package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC02_AccLogin extends BaseClass {
	
	
	@Test(groups = {"regression","master"})
	public void acc_login() throws IOException
	{
		
		logger.info("*****Starting TC02_AccLogin *****");
		
		try
		{
			HomePage hp = new HomePage(driver);
			
			hp.clickMyAcc();
		    logger.info("Clicked on My Account Link");
		    hp.clickLogin();
		    logger.info("Clicked on Login");
		    
		    LoginPage lp = new LoginPage(driver);
		    
		    
		    logger.info("Sending Login Information");
		    lp.setupemail(p.getProperty("email"));
		    lp.setuppass(p.getProperty("password"));
		    lp.clicklogin();
		    logger.info("Clicked on Login Button");	
		    
		    MyAccountPage mlp = new MyAccountPage(driver);
		    Assert.assertEquals(mlp.checkname(), true);
		    
		    
		    
		}
		catch(Exception c)
		{
			logger.error("Test FAILED");
			//logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("*****Finished TC02_AccLogin *****");
	}

	
	
}
