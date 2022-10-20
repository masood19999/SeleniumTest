package selenium.pageobjects;




import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import selenium.AbstractComponents.AbstractComponent;

//Implementing Landing page functionality
public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this); 
	}
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectDropDown;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css="[class*='ta-results']")
	WebElement dropDownElement;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	public void SearchCountry(String country) {
		
		Actions actions=new Actions(driver);
		actions.sendKeys(selectCountry, country).build().perform();
		visibilityOfAllElements(dropDownElement);	
		
		//select india option
		actions.moveToElement(selectDropDown).click().build().perform();
				
	}
	
	public ThankYouPage clickPlaceOrder() throws InterruptedException {
		
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("window.scroll(0,5000)");
		
		elementToBeClickable(placeOrder);
		
		Thread.sleep(1000);
		
		placeOrder.click();
		
		return new ThankYouPage(driver);
	}
	
}
