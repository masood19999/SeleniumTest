package Selenium.MyStorePageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Selenium.AbstractComponents.ReusableComponents;

public class CreateAccountPage extends ReusableComponents{
	
	WebDriver driver;
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".radio-inline label")
	List<WebElement> titles;
	
	@FindBy(id="account-creation_form")
	WebElement formId;
	
	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="optin")
	WebElement option2;
	
	@FindBy(id="firstname")
	WebElement fname;
	
	@FindBy(id="lastname")
	WebElement lname;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address1; 
	
	@FindBy(id="address2")
	WebElement address2; 
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement states;
	
	@FindBy(id="postcode")
	WebElement postCode;
	
	@FindBy(id="phone_mobile")
	WebElement mobileNumber;
	
	@FindBy(id="alias")
	WebElement alias;
	
	@FindBy(id="submitAccount")
	WebElement submitAccount;
	
	public void fillPersonalInformation(String titleName,String fname,String lname,String pswd,String day,String month,String year) {
		elementToBeClickable(formId);
		//select radio title
		WebElement elem=titles.stream().filter(title->title.getText().equalsIgnoreCase(titleName)).findFirst().orElse(null);
		elem.findElement(By.cssSelector("[name='id_gender']")).click();
		
		//send first name and last name
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		
		//password
		password.sendKeys(pswd);
		
		//DOB
		Select selectDays = new Select(days);
		Select selectMonths = new Select(months);
		Select selectYears = new Select(years);
		
		selectDays.selectByValue(day);
		selectMonths.selectByValue(month);
		selectYears.selectByValue(year);
		
		//Checkbox2
		option2.click();
		
	}
	
	public void fillAddressInfo(String companyName,String addressName1,String addressName2,String cityName,String stateName,String postCodeName,String phoneNumber,String AddressName) {
		System.out.println(fname.getAttribute("value"));
		System.out.println(lname.getAttribute("value"));
		
		company.sendKeys(companyName);
		address1.sendKeys(addressName1);
		address2.sendKeys(addressName2);
		city.sendKeys(cityName);
		//select state
		Select state=new Select(states); 
		state.selectByVisibleText(stateName);
		
		postCode.sendKeys(postCodeName);
		mobileNumber.sendKeys(phoneNumber);
		
		alias.clear();
		alias.sendKeys(AddressName);
	}
	
	public AddressPage submitAccount() {
		this.submitAccount.click();
		
		AddressPage addressPage=new AddressPage(driver);
		return addressPage;
		
	}
}
