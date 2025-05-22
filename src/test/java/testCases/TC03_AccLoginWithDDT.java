package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC03_AccLoginWithDDT extends BaseClass{
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDrivenTest")
	public void acc_login_DDT(String email, String pass, String expres) throws IOException
	
	{
	
		logger.info("*****Starting TC03_AccLogin *****");
		
		try
		{
			HomePage hp = new HomePage(driver);
			
			hp.clickMyAcc();
		    logger.info("Clicked on My Account Link");
		    hp.clickLogin();
		    logger.info("Clicked on Login");
		    
		    LoginPage lp = new LoginPage(driver);
		    
		    
		    logger.info("Sending Login Information");
		    lp.setupemail(email);
		    lp.setuppass(pass);
		    lp.clicklogin();
		    logger.info("Clicked on Login Button");	
		    
		    MyAccountPage mlp = new MyAccountPage(driver);
		    boolean targetpage =  mlp.checkname();
		    
		    if(expres.equalsIgnoreCase("Valid"))
		    {
		    	if(targetpage == true)
		    	{
		    		Assert.assertTrue(true);
		    		mlp.clicklogout();
		    	}
		    	else
		    	{
		    		Assert.assertTrue(false);
		    	}
		    	
		    }
		    
		    if(expres.equalsIgnoreCase("Invalid"))
		    {
		    	if(targetpage == true)
		    	{
		    		mlp.clicklogout();
		    		Assert.assertTrue(false);
		    		
		    	}
		    	else
		    	{
		    		Assert.assertTrue(true);
		    	}
		    	
		    }
		    
		    
		}
		catch(Exception c)
		{
			logger.error("Test FAILED");
			//logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("*****Finished TC03_AccLogin *****");
	}

}

