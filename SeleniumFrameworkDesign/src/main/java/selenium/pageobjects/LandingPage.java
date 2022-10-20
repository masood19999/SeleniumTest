package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.AbstractComponents.AbstractComponent;

//Implementing Landing page functionality
public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		System.out.println("Constructor called");
		this.driver=driver;
		PageFactory.initElements(driver,this); 
	}
	
	//	WebElement userEmailEle=dr.findElement(By.id("userEmail"));
	//	WebElement userPasswordEle=dr.findElement(By.id("userPassword"));
	//	WebElement userLoginEle=dr.findElement(By.id("login"));
	
	//same as above can be achieved through Page Factory
	@FindBy(id="userEmail")
	WebElement userEmailEle;
	
	@FindBy(id="userPassword")
	WebElement userPasswordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalouge loginApplication(String email,String password) {
		userEmailEle.sendKeys(email);
		userPasswordEle.sendKeys(password);
		submit.click();
		return new ProductCatalouge(driver);
	}
	
	public String getErrorMessage() {
		visibilityOfAllElements(errorMessage);
		return errorMessage.getText();
	}
	
	public void gotTo() {
		driver.get("https://www.rahulshettyacademy.com/client/");
	}
}
