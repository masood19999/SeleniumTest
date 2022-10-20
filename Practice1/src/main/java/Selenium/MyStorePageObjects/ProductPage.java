package Selenium.MyStorePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Selenium.AbstractComponents.ReusableComponents;

public class ProductPage extends ReusableComponents{
	
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class*='product_quantity_up']")
	WebElement incrementCount; 
	
	@FindBy(id="quantity_wanted")
	WebElement quantityWanted;
	
	@FindBy(css="[class*='product_quantity_down']")
	WebElement decrementCount;
	
	@FindBy(id="group_1")
	WebElement sizeElement;
	
	@FindBy(css="#color_to_pick_list li a[title='Blue']")
	WebElement blueColor;
	
	@FindBy(css="#color_to_pick_list li[class='selected'] a")
	WebElement fetchSelectedColor;
	
	@FindBy(css="[name='Submit']")
	WebElement addToCart;
	
	@FindBy(css="a[title='Proceed to checkout']")
	WebElement proceedCheckout;
	
	public void increaseQuantity(int productCount)
	{
		elementToBeClickable(incrementCount);
		for(int i=1;i<productCount;i++)
		{
			incrementCount.click();
		}
	}
	Select sizeValues=new Select(sizeElement);
	public void selectProductSize(String size)
	{
		
		sizeValues.selectByVisibleText(size);
	}
	
	public void selectBlueColor()
	{
		blueColor.click();
	}
	
	public String[] fetchProductAttributes() {
		
		String[] values = new String[3];
		values[0]=quantityWanted.getAttribute("value");
		values[1]=sizeValues.getFirstSelectedOption().getText();
		values[2]=fetchSelectedColor.getAttribute("name");
		
		return values;
	}
	
	public void addToCart() {
		addToCart.click();
	}
	
	public SummaryPage clickProceedCheckOutModal() {
		
		elementToBeClickable(proceedCheckout);
		
		proceedCheckout.click();
		
		SummaryPage summaryPage=new SummaryPage(driver);
		return summaryPage;
	}
}
