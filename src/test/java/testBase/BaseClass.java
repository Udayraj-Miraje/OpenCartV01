package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;	
	public Properties p;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups = {"sanity","regression","master","DataDrivenTest"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		//loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);	
		
		
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();	
			
			//OS
			
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching OS");
				return;
			}
			
			//browser
			
			switch(br.toLowerCase())
			{
				case "chrome" : cap.setBrowserName("chrome");break;
				case "edge" : cap.setBrowserName("MicrosoftEdge");break;
				default : System.out.println("Invalid Browser Selection");return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444"),cap);
			
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
				case "chrome" : driver = new ChromeDriver();break;
				case "edge" : driver = new EdgeDriver();break;
				default : System.out.println("Invalid Browser Selection");return;	
			}
			
		}
		
	

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.get(p.getProperty("app_URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups = {"sanity","regression","master","DataDrivenTest"})
	public void teardown() 
	{
		driver.quit();
		
	}
	
	public String randomeString()
	{
		
		String genstring = RandomStringUtils.randomAlphabetic(5);
		return genstring;
	}
	
	public String randomeNumbers()
	{
		
		String genstring = RandomStringUtils.randomNumeric(10);
		return genstring;
	}

	public String randomePass()
	{
		
		String genstring1 = RandomStringUtils.randomAlphabetic(5);
		String genstring2 = RandomStringUtils.randomNumeric(10);
		return (genstring1 +"@" + genstring2);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
		File sourceFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname + "_"+timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
			
	}
}
