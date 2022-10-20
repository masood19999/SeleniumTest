package Selenium.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingObject;
	public WebDriver initializeDriver() throws IOException {
		
		//properties class
		Properties prop=new Properties();
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Selenium\\resources\\GlobalData.properties");
		prop.load(fs);
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//setup the chrome
			WebDriverManager.chromedriver().setup(); 
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//firefox driver setup
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			//edge driver setup
		}
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//maximize the window
		driver.manage().window().maximize();
		
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage lauchApplication() throws IOException {
		driver=initializeDriver();
		//Login Page class initiate and invoke its functionality
		landingObject = new LandingPage(driver);
		landingObject.gotTo();
		return landingObject;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
}
