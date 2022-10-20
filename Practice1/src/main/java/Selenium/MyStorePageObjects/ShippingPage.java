package Selenium.MyStorePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Selenium.AbstractComponents.ReusableComponents;

public class ShippingPage extends ReusableComponents{
	
	WebDriver driver;
	public ShippingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#cgv")
	WebElement checkBox;
	
	@FindBy(css="button[name='processCarrier']")
	WebElement proceedToCheckout;
	
	By locator=By.cssSelector("input#cgv");
	 
	public void clickTermsOfService() {
		scrolDown();
		checkBox.click();
		
	}
	
	public PaymentPage clickProceedToCheckOut()
	{
		proceedToCheckout.click();
		PaymentPage paymentPage=new PaymentPage(driver);
		return paymentPage;
	}
}
