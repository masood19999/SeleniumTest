package Selenium.MyStore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Selenium.MyStorePageObjects.AddressPage;
import Selenium.MyStorePageObjects.AuthenticationPage;
import Selenium.MyStorePageObjects.ConfirmOrder;
import Selenium.MyStorePageObjects.CreateAccountPage;
import Selenium.MyStorePageObjects.LandingPage;
import Selenium.MyStorePageObjects.OrderConfirmationPage;
import Selenium.MyStorePageObjects.OrderHistoryPage;
import Selenium.MyStorePageObjects.PaymentPage;
import Selenium.MyStorePageObjects.ProductPage;
import Selenium.MyStorePageObjects.ShippingPage;
import Selenium.MyStorePageObjects.SummaryPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyStorePageObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyStorePageObject mainObject=new MyStorePageObject();
		
		//ChromeDriver Setup
		WebDriverManager.chromedriver().setup();
		
		//WebDriver initialize
		WebDriver driver=new ChromeDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Global values
		String productName="shirt";
		String emailId="mm15@amazon.com";
		
		//Launch the app and search the product and select it
		LandingPage landingObject=new LandingPage(driver);
		landingObject.goTo();
		landingObject.serchProduct(productName);
		ProductPage productPage=landingObject.selectProduct();
		
		//Product Page
		productPage.increaseQuantity(5);
		productPage.selectProductSize("M");
		productPage.selectBlueColor();
		//verify and quantity , size and color as expected
		mainObject.verifyProductAttributes(productPage.fetchProductAttributes());
		productPage.addToCart();
		SummaryPage summaryPage=productPage.clickProceedCheckOutModal();
		
		//SummaryPage
		Assert.assertTrue(summaryPage.getProductName().contains(productName));		
		AuthenticationPage authenticationPage=summaryPage.clickProceedCheckOut();
		
		//Authentication Page
		authenticationPage.inputEmail(emailId);
		CreateAccountPage createAccountPage=authenticationPage.clickCreateAccount(); 
		
		//Create Account Page
		createAccountPage.fillPersonalInformation("Mr.","Masood","Ahmed","masood","15","11","1999");
		
		createAccountPage.fillAddressInfo("Amazon","Orlando Streets","High Feets Flat","Miami","Florida","90099","97797989","Home");
		
		AddressPage addressPage=createAccountPage.submitAccount();
		ShippingPage shippingPage=addressPage.proccedToAddress();
		
		//Shipping Page
		shippingPage.clickTermsOfService();
		PaymentPage paymentPage= shippingPage.clickProceedToCheckOut();
		
		//Payment Page
		ConfirmOrder confirmOrder=paymentPage.clickBankWirePaymentMode();
		
		//Comfirmation Page
		OrderConfirmationPage orderConfirmation=confirmOrder.clickConfirmOrder();
		orderConfirmation.getOrderSuccessMessage();
		OrderHistoryPage orderHistory=orderConfirmation.clickBackToOrder();
		
		//OrderHistory Page
		mainObject.verifyOrderHistoryValues(orderHistory.getOrderHistory());
		orderHistory.clickHome();
	}
	
	public void verifyProductAttributes(String values[]) {
		System.out.println(values[0]+" "+values[1]+" "+values[2]);
		
		//verify quanitity
		Assert.assertEquals(values[0], "5");
		//verfiy product size
		Assert.assertEquals(values[1],"M");
		//verify selected color
		Assert.assertEquals(values[2],"Blue");
		
	}
	
	public void verifyOrderHistoryValues(String values[]) {
		System.out.println(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]);
		
		//verify quanitity
		//Assert.assertEquals(values[0], "FUMNMTBVG");
		//verfiy product size
		Assert.assertEquals(values[1],"09/22/2022");
		//verify selected color
		Assert.assertEquals(values[2],"$84.55");
		
		Assert.assertEquals(values[3],"Bank wire");
		
		Assert.assertEquals(values[4],"On backorder");
	}
}
