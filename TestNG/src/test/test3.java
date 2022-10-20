package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test3 {

	@BeforeMethod
	public void executeBeforeMethod() {
		System.out.println("excute before method");
	}
	@AfterMethod
	public void executeAfterMethod() {
		System.out.println("excute after method");
	}
	
	@Parameters({"URL"})
	@Test
	public void webLoginCarLoan(String uname) {
		System.out.println("webLoginCarLoan");
		System.out.println("car Level URL : "+uname);
	}
	
	@Test(groups= {"smoke"})
	public void mobileLoginCarLoan() {
		System.out.println("mobileLoginCarLoan");
	}
	
	@Test(groups= {"smoke"})
	public void mobileSignInCarLoan() {
		System.out.println("mobileSignInCarLoan");
	}
	
	@Test(groups= {"smoke"})
	public void mobileSignOutCarLoan() {
		System.out.println("mobileSignOutCarLoan");
	}
	
	@Test(dependsOnMethods={"webLoginCarLoan"}) //will run only after weblogincar method is executed
	public void apiLoginCarLoan() {
		System.out.println("apiLoginCarLoan");
	}
	
	@BeforeSuite
	public void executeFirst() {
		System.out.println("I will execute first");
	}
}
