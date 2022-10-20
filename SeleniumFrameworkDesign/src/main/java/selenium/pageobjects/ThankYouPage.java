package selenium.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import selenium.AbstractComponents.AbstractComponent;

//Implementing Landing page functionality
public class ThankYouPage extends AbstractComponent{

	WebDriver driver;
	
	public ThankYouPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this); 
	}
	
	@FindBy(css=".hero-primary")
	WebElement textElement;
	
	public String getContent() {
		String content=textElement.getText();
		return content;
		
	}
	
	 
}
