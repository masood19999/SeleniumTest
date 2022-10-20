package myTestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test {
    public static void main(String[] args) throws Exception {
        
        //Creating a driver object referencing WebDriver interface
        WebDriver driver;
        
        //Setting the webdriver.chrome.driver property to its executable's location
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\masood.d.ahmed\\eclipse-workspace\\Selenium\\Driver\\chromedriver\\chromedriver.exe");
	
        //Instantiating driver object
        driver = new ChromeDriver();
        
        //Using get() method to open a webpage
        driver.get("https://artoftesting.com/samplesiteforselenium");
        
        //locators
        WebElement findById=driver.findElement(By.id("fname"));
        findById.sendKeys("Hello");
        //
        WebElement findByTag=driver.findElement(By.tagName("h1"));
        String text=findByTag.getText();
        System.out.println(text);
        //findByTag.click();
        //Link Text
        /*
        WebElement findByLinkText=driver.findElement(By.linkText("This is a link"));
        findByLinkText.click();*/
        Thread.sleep(3000);
        //Partial Link Text
        WebElement findByPartialText=driver.findElement(By.partialLinkText("Selenium Sample Script"));
        System.out.println(findByPartialText.getText());
        findByPartialText.click();
        
        //Closing the browser
        //driver.quit();
 
    }
 
}