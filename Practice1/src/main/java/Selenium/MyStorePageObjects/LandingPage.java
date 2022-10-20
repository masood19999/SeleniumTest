package Selenium.MyStorePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbstractComponents.ReusableComponents;

public class LandingPage extends ReusableComponents{
	
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	@FindBy(css=".ac_results ul li")
	WebElement selectFromDropDown;
	
	public void goTo()
	{
		driver.get("http://automationpractice.com/index.php");
	}
	
	public void serchProduct(String product) {
		searchBox.sendKeys(product);
	}
	public ProductPage selectProduct()
	{
		elementToBeClickable(selectFromDropDown);
		selectFromDropDown.click();
		ProductPage productPage=new ProductPage(driver);
		return productPage;
	}
	
}
