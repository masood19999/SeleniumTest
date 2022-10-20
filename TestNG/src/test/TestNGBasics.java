package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGBasics {

	
	@AfterTest
	public void method3() {
		System.out.println("I will execute after all test in personal loan folder");
	}
	
	@Test
	public void method1() {
		
		System.out.println("Hello World testng basics");
		Assert.assertTrue(false);
	}
	
	@Test
	public void method2() {
		
		System.out.println("Hii");
	}
	
	@AfterSuite
	public void executeLast() {
		System.out.println("I will execute last");
	}
}
