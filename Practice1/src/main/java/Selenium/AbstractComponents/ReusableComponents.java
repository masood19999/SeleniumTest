package Selenium.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents {
  
	WebDriver driver;
	WebDriverWait waitObject;
	public ReusableComponents(WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitObject=new WebDriverWait(driver,Duration.ofSeconds(7));
	}
	
	@FindBy(css="[class*='product_quantity_up']")
	WebElement incrementCount; 
	
	public void elementToBeClickable(WebElement element) {
		waitObject.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void elementsToAppear(By locator) {
		waitObject.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void scrolDown() {
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("window.scrollBy(0,500)");
	}
}
