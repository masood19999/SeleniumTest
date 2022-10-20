package myTestPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test1 {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		
		//Initiating the object
		WebDriver driver;
		//System Set
		System.setProperty("webdriver.chrome.driver","C:\\Users\\masood.d.ahmed\\eclipse-workspace\\Selenium\\Driver\\chromedriver\\chromedriver.exe");
		//creating the object
		driver = new ChromeDriver();
		//launching the URL
		driver.get("http://demo.guru99.com/test/newtours/");
		//maximizing the window
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("Welcome: Mercury Tours"))
		{
			System.out.println("True  : Tittle is matching");
		}
		else
		{
			System.out.println("False : Tittle is not matching");
		}
		//closing the window
		driver.close();
		//closing the entire program
		System.exit(0);
		
	}

}
