package Selenium.Tests;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			
		WebDriverManager.chromedriver().setup(); //setup the chrome
		WebDriver driver=new ChromeDriver();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Explicit wait
		WebDriverWait waitObject=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//Login Functionality
		driver.get("https://www.rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("masood@amazon.com");
		driver.findElement(By.id("userPassword")).sendKeys("Amazon123");
		driver.findElement(By.id("login")).click();
		
		//wait for element to be visible
		waitObject.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		//add cart zara coat
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("zara coat 3")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector("button:nth-of-type(2)")).click();
	
		waitObject.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		
		//wait animation
		waitObject.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
	//	Assert.assertTrue(driver.findElement(By.id("toast-container")).getText().contains("Add"));
		
		//click cart button
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//verify the selected cart is available or not
		
		List<WebElement> orders=driver.findElements(By.cssSelector(".cartWrap h3"));
		
		boolean res=orders.stream().anyMatch(order-> order.getText().equalsIgnoreCase("zara coat 3"));
		
		Assert.assertTrue(res);
		
		//verify added cart appeared in the order list 
		List<WebElement> ordersList =driver.findElements(By.cssSelector("div[class='cart'] li h3"));
		boolean result=ordersList.stream().anyMatch(order->order.getText().equalsIgnoreCase("zara coat 3"));
		Assert.assertTrue(result);
		System.out.println(result);
	
		// wait
		waitObject.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".totalRow button"))));
	
		// click checkout
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("window.scroll(0,500)");
		driver.findElement(By.cssSelector(".totalRow button")).click();
	
		//sendkeys
		Actions actions=new Actions(driver);
		actions.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		
		//wait for dropdown to appear
		waitObject.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("[class*='ta-results']"))));
		
		//select india option
		actions.moveToElement(driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]"))).click().build().perform();
		
		
		System.out.println(driver.getCurrentUrl());
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("window.scroll(0,5000)");
		
		waitObject.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".action__submit"))));
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String content=driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(content);
		Assert.assertTrue(content.contains("THANKYOU FOR THE ORDER."));
		
	}

}
