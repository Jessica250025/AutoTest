package automationFramework;

import com.thoughtworks.selenium.*;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class firstTest {
	 
	 public static void main(String[] args) throws Exception {
	 	 
		System.setProperty("webdriver.chrome.driver", "/Users/Summer/Documents/EclipseProj/AutoTest1/chromedriver");
	 
		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();
		  
		//Launch the Paypal Website
		driver.get("https://www.paypal.com/");
		// print a log of page title
		String Title = driver.getTitle();
		System.out.println("Successfully opened" + Title);
		
		Thread.sleep(500);  
		  
			// Go to log in page
		WebElement logInElem = driver.findElement(By.id("ul-btn"));
		logInElem.click();
		
		// Type in email
		WebElement element = driver.findElement(By.name("login_email"));  
		System.out.println("access login page...");
		
		element.sendKeys("ABCD_abcd");  
		System.out.println("input user name...");  
		
		// Type in password
		element = driver.findElement(By.name("login_password"));  
		element.sendKeys("123456");  
		System.out.println("input password");  
		
		// login
		Thread.sleep(500); 
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Loging in...");
		  
		Thread.sleep(500);  // Let the user actually see something!
		driver.quit();
	
	 }
}

