package selenium.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.pageobjects.CartPage;
import selenium.pageobjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;

	@FindBy(css="[routerlink*='myorders']")
	WebElement myOrders;
	
	public void visiblityOfElement(By findBy) {
		
		//Explicit wait
		WebDriverWait waitObject=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		waitObject.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void visibilityOfAllElements(WebElement element) {
		
		WebDriverWait waitObject=new WebDriverWait(driver,Duration.ofSeconds(5));
		waitObject.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	
	public void elementToDisapper(WebElement element) {
		
		//wait animation
		WebDriverWait waitObject=new WebDriverWait(driver,Duration.ofSeconds(5));
		waitObject.until(ExpectedConditions.invisibilityOf(element));

	}
	
	public void elementToBeClickable(WebElement element) {
		WebDriverWait waitObject=new WebDriverWait(driver,Duration.ofSeconds(5));
		waitObject.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public CartPage gotToCartPage() {
		cart.click();
		return new CartPage(driver);
	}
	
	public OrderPage gotoOrdersPage() {
		myOrders.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}
	
	
}
