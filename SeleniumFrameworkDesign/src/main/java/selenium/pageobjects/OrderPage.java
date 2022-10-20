package selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import selenium.AbstractComponents.AbstractComponent;

//Implementing Landing page functionality
public class OrderPage extends AbstractComponent{

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this); 
	}
	

	@FindBy(xpath="//tr/td[2]")
	List<WebElement> productNames;
	
		
	 public boolean verifyDisplay(String productName) {
		 boolean res=productNames.stream().anyMatch(order-> order.getText().equalsIgnoreCase(productName));
		 return res;
	 }	 
	 
}
