package selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.AbstractComponents.AbstractComponent;

//Implementing Landing page functionality
public class ProductCatalouge extends AbstractComponent{

	WebDriver driver;
	
	public ProductCatalouge(WebDriver driver) {
		super(driver);
		System.out.println("Constructor called");
		this.driver=driver;
		PageFactory.initElements(driver,this); 
	}
	

	//Page Factory to initialize the webelements
	//add cart zara coat
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	
	By findByProduct=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector("button:nth-of-type(2)");
	By toastMessage=By.cssSelector("#toast-container");
	
	public WebElement getProduct(String productName) {
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
		
	public void addToProduct(String productName) {
		
		visiblityOfElement(findByProduct);
		
		WebElement prod=getProduct(productName);
		prod.findElement(addToCart).click();
		
		visiblityOfElement(toastMessage);
		elementToDisapper(spinner);
		
	}
	
}
