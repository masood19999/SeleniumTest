package Selenium.MyStorePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.ReusableComponents;

public class OrderHistoryPage extends ReusableComponents{
	
	
	WebDriver driver;
	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class*='history_link'] a")
	WebElement orderRefrence;
	
	@FindBy(css="[class*='history_date']")
	WebElement date;
	
	@FindBy(css="[class='history_price'")
	WebElement price;
	
	@FindBy(css="[class='history_method']")
	WebElement paymentMethod;
	
	@FindBy(css="[class='history_state'] span")
	WebElement status;
	
	@FindBy(css="ul[class*='footer_links'] li:nth-child(2) a")
	WebElement home;
	
	public String[] getOrderHistory() {
		elementToBeClickable(orderRefrence);
		String orderHistory[]=new String[5];
		orderHistory[0]= orderRefrence.getText();
		orderHistory[1]=date.getText();
		orderHistory[2]=price.getText();
		orderHistory[3]=paymentMethod.getText();
		orderHistory[4]=status.getText();
		return orderHistory;
	}
	
	public void clickHome() {
		home.click();
	}
}
