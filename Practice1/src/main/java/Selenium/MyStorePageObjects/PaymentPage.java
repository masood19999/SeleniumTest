package Selenium.MyStorePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Selenium.AbstractComponents.ReusableComponents;

public class PaymentPage extends ReusableComponents{
	
	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[class='bankwire']")
	WebElement bankWire;
	
	public ConfirmOrder clickBankWirePaymentMode() {
		elementToBeClickable(bankWire);
		bankWire.click();
		ConfirmOrder confirmOrder=new ConfirmOrder(driver);
		return confirmOrder;
	}
	

}
