package SeleniumPractice.Practice1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CURA_Healthcare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//setup the chrome driver
		WebDriverManager.chromedriver().setup(); 
		
		//initiate chromedriver
		WebDriver driver=new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		//wait object
		WebDriverWait waitObject=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//click make appointment button
		driver.findElement(By.id("btn-make-appointment")).click();
		
		//waitObject
		waitObject.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
		
		//fetch the username and password
		String  userName=driver.findElement(By.cssSelector("input[aria-describedby='demo_username_label']")).getAttribute("value");
		String  password=driver.findElement(By.cssSelector("input[aria-describedby='demo_password_label']")).getAttribute("value");
		System.out.println("userName:"+userName+" password:"+password);
		
		//send keys of username and password and then submit
		driver.findElement(By.id("txt-username")).sendKeys(userName);
		driver.findElement(By.id("txt-password")).sendKeys(password);
		driver.findElement(By.id("btn-login")).click();
		
		//wait for next page
		waitObject.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#combo_facility")));
		
		WebElement ele=driver.findElement(By.cssSelector("#combo_facility"));
		
		//select option 2
		Select options = new Select(ele);
		options.selectByValue("Hongkong CURA Healthcare Center");
		
		//click the checkbox
		driver.findElement(By.name("hospital_readmission")).click();
		
		//select 3rd radio button
		driver.findElement(By.id("radio_program_none")).click();
		
		//send keys to text area
		driver.findElement(By.tagName("textarea")).sendKeys("I need appointment on the given date .so kindly help to confirm the availability of the appointment");
		
		//Action class
		Actions actions =new Actions(driver);
		actions.moveToElement(driver.findElement(By.cssSelector("#txt_visit_date"))).click().build().perform();
		
		//select 1st as date
		driver.findElement(By.cssSelector(".datepicker-days tbody tr td[class='day']")).click();
		
		//click submit
		driver.findElement(By.id("btn-book-appointment")).click();
		
		
		//confirmation page
		waitObject.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h2")));
		Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains("Appointment Confirmation"));
		
		//Facility assertion
		Assert.assertTrue(driver.findElement(By.cssSelector("#facility")).getText().equalsIgnoreCase("Hongkong CURA Healthcare Center"));
		
		//hospital redmission checked
		Assert.assertTrue(driver.findElement(By.id("hospital_readmission")).getText().equalsIgnoreCase("Yes"));
		
		//healtcare program as none
		Assert.assertTrue(driver.findElement(By.cssSelector("#program")).getText().equalsIgnoreCase("None"));
		
		//visit date as visit_date
		Assert.assertTrue(driver.findElement(By.id("visit_date")).getText().equalsIgnoreCase("01/09/2022"));
		
		//verify comment content
		Assert.assertTrue(driver.findElement(By.id("comment")).getText().equalsIgnoreCase("I need appointment on the given date .so kindly help to confirm the availability of the appointment"));
		
		//go to homepage
		driver.findElement(By.xpath("//*[text()='Go to Homepage']")).click();
		
		//click toggle
		driver.findElement(By.cssSelector("#menu-toggle")).click();
		
		//menu toggle sub webdriver
		WebElement wb=driver.findElement(By.cssSelector(".sidebar-nav"));
		
		//verify all the links present in the toggle are navigating
		List<WebElement> linkList=wb.findElements(By.cssSelector("li"));
		
		System.out.println("Links Count: "+linkList.size());
		
		int linkCount=linkList.size();
		
		for(int i=0;i<linkCount;i++) {
			
			String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			System.out.println(linkList.get(i).getTagName());
			System.out.println(wb.findElements(By.cssSelector("li a")).get(i).getAttribute("href"));
			
			wb.findElements(By.cssSelector("li a")).get(i).sendKeys(clickOnLink);
			
			//click toggle
			driver.findElement(By.cssSelector("#menu-toggle")).click();
			waitObject.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-toggle")));
			
			
		}
		
	}
}
