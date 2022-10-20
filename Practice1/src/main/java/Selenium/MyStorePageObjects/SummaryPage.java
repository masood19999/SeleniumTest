package Selenium.MyStorePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Selenium.AbstractComponents.ReusableComponents;

public class SummaryPage extends ReusableComponents{
	
	WebDriver driver;
	public SummaryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cart_description .product-name")
	WebElement productName;
	
	@FindBy(css="p[class*='cart_navigation'] a[title='Proceed to checkout']")
	WebElement proceedCheckout;
	
	By locator=By.cssSelector(".cart_description .product-name");
	
	public String getProductName() {
		elementsToAppear(locator);
		return productName.getText();
	}

	public AuthenticationPage clickProceedCheckOut() {
		
		scrolDown();
		elementToBeClickable(proceedCheckout);

		proceedCheckout.click();
		
		AuthenticationPage authenticationPage = new AuthenticationPage(driver);
		return authenticationPage;
	}
}
