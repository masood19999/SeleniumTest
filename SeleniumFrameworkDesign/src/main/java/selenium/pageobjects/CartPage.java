package selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import selenium.AbstractComponents.AbstractComponent;

//Implementing Landing page functionality
public class CartPage extends AbstractComponent{

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this); 
	}
	
	@FindBy(css=".cartWrap h3")
	List<WebElement> orders;

	@FindBy(css="div[class='cart'] li h3")
	List<WebElement> ordersList;
	
	@FindBy(css=".totalRow button")
	WebElement button;

		
	 public boolean orderSearch(String productName) {
		 boolean res=orders.stream().anyMatch(order-> order.getText().equalsIgnoreCase(productName));
		 return res;
	 }
	 
	 public boolean orderList(String productName) {
		 boolean result=ordersList.stream().anyMatch(order->order.getText().equalsIgnoreCase(productName));
		 return result;
	 }
	 
	 public CheckOutPage clickCheckout()
	 {
		 elementToBeClickable(button);
		 
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("window.scroll(0,500)");
		 
		 elementToBeClickable(button);
		 
		 button.click();
		 
		 return new CheckOutPage(driver);
		 
	 }


	 
}
