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
import selenium.pageobjects.OrderPage;
import selenium.pageobjects.ProductCatalouge;
import selenium.pageobjects.ThankYouPage;


public class PageObjectModel extends BaseTest {

	@Test
	public void submitOrder() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String productName="zara coat 3";
		String country="India";
		
		ProductCatalouge productObject=landingObject.loginApplication("masood@amazon.com","Amazon123");
		
		//Product Functionality
		//select product ZARA COAT
		productObject.addToProduct(productName);
		CartPage cartObject=productObject.gotToCartPage();
		
		//cart page object
		//verify the selected cart is available or not
		boolean res=cartObject.orderSearch(productName);
		Assert.assertTrue(res);
		//verify added cart appeared in the order list 
		boolean result=cartObject.orderList(productName);
		Assert.assertTrue(result);
		//click checkout
		CheckOutPage checkOutObject=cartObject.clickCheckout();

		//CheckOut Page
		checkOutObject.SearchCountry(country);
		ThankYouPage thankYouPageObject=checkOutObject.clickPlaceOrder();
		
		//ThankYou Page
		String content=thankYouPageObject.getContent();
		Assert.assertTrue(content.contains("THANKYOU FOR THE ORDER."));
		
	}
	
	@Test(dependsOnMethods={"submitOrder"})
	public void ordersHistoryTest() {
		String productName="zara coat 3";
		ProductCatalouge productObject=landingObject.loginApplication("masood@amazon.com","Amazon123");
		OrderPage orderPage=productObject.gotoOrdersPage();
		Assert.assertTrue(orderPage.verifyDisplay(productName));
		
	}
}
