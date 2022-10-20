package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test4 {

	
	@Test(dataProvider="getData")
	public void webLoginHomeLoan(String username,String password) {
		System.out.println("webLoginHomeLoan");
		System.out.println(username);
		System.out.println(password);
	}
	
	@Test(timeOut=4000)
	public void mobileLoginHomeLoan() {
		System.out.println("mobileLoginHomeLoan");
	}
	
	@Parameters({"URL"})
	@Test
	public void apiLoginHomeLoan(String uname) {
		System.out.println("apiLoginHomeLoan");
		System.out.println(uname);
	}
	
	@DataProvider
	public Object[][] getData() {
	
		Object[][] data=new Object[3][2];
		
		//first data username and password
		data[0][0]="firstdatausername";
		data[0][1]="firstdatapassword";
		
		//second data username and password
		data[1][0]="seconddatausername";
		data[1][1]="seconddatapassword";
		
		//third data username and password
		data[2][0]="thirddatausername";
		data[2][1]="thirddatapassword";
		
		return data;
	}
}
