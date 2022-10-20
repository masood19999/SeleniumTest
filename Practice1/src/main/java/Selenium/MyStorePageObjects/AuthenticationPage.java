package Selenium.MyStorePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Selenium.AbstractComponents.ReusableComponents;

public class AuthenticationPage extends ReusableComponents{
	
	WebDriver driver;
	public AuthenticationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email_create")
	WebElement emailId;
	
	@FindBy(id="SubmitCreate")
	WebElement createAccount;
	
	public void inputEmail(String emailId)
	{
		elementToBeClickable(this.emailId);
		this.emailId.sendKeys(emailId);
	}
	
	public CreateAccountPage clickCreateAccount()
	{
		createAccount.click();
		CreateAccountPage createAccountPage=new CreateAccountPage(driver);
		return createAccountPage;
	}
	
}
