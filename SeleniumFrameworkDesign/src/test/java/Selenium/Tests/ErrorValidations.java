package Selenium.Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.pageobjects.CartPage;
import selenium.pageobjects.CheckOutPage;
import selenium.pageobjects.LandingPage;
import selenium.pageobjects.ProductCatalouge;
import selenium.pageobjects.ThankYouPage;


public class ErrorValidations extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void loginFailureValidations() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		landingObject.loginApplication("masood@amazon.com","Amazon13");
		System.out.println(landingObject.getErrorMessage());
		Assert.assertEquals("Incorrect email or password.", landingObject.getErrorMessage());
	}
	
	@Test
	public void productNameErrorValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String productName="zara coat 33";
		
		ProductCatalouge productObject=landingObject.loginApplication("masood@amazon.com","Amazon123");
		
		//Product Functionality
		//select product ZARA COAT
		productObject.addToProduct(productName);
		CartPage cartObject=productObject.gotToCartPage();
		
		//cart page object
		//verify the selected cart is available or not
		boolean res=cartObject.orderSearch(productName);
		Assert.assertFalse(res);

		
	}
}
