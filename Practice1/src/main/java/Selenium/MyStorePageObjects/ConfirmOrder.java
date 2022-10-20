package Selenium.MyStorePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Selenium.AbstractComponents.ReusableComponents;

public class ConfirmOrder extends ReusableComponents{
	
	WebDriver driver;
	public ConfirmOrder(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#cart_navigation button[type='submit']")
	WebElement confirmOrder;
	
	public OrderConfirmationPage clickConfirmOrder() {
		elementToBeClickable(confirmOrder);
		confirmOrder.click();
		OrderConfirmationPage confirmationPage=new OrderConfirmationPage(driver);
		return confirmationPage;
				
	}
	
	

}
