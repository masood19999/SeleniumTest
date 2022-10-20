package Selenium.MyStorePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Selenium.AbstractComponents.ReusableComponents;
import Selenium.MyStorePageObjects.OrderHistoryPage;

public class OrderConfirmationPage extends ReusableComponents{
	
	WebDriver driver;
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="p[class='cheque-indent'] strong")
	WebElement orderSuccess;
	
	@FindBy(css="a[title='Back to orders']")
	WebElement backToOrder;
	
	By locator=By.cssSelector("p[class='cheque-indent'] strong");
	
	public String getOrderSuccessMessage() {
		elementsToAppear(locator);
		return orderSuccess.getText();
	}
	
	public OrderHistoryPage  clickBackToOrder() {
		backToOrder.click();
		OrderHistoryPage orderHistory=new OrderHistoryPage(driver);
		return orderHistory;
	}
	

}
