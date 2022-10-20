package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test2 {

	@Test(enabled=false)
	public void method1() {
		System.out.println("Class test 2");
	}
	
	@BeforeTest
	public void  method2() {
		System.out.println("I will execute first after suite");
	}
}
