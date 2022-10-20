package Selenium.MyStorePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Selenium.AbstractComponents.ReusableComponents;

public class AddressPage extends ReusableComponents{
	
	WebDriver driver;
	public AddressPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="button[name='processAddress']")
	WebElement proceedCheckout;
	
	public ShippingPage proccedToAddress() {
		proceedCheckout.click();
		ShippingPage shippingPage=new ShippingPage(driver);
		return shippingPage;
	}
	
}
