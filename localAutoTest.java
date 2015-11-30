package automationFramework;

import com.thoughtworks.selenium.*;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class localAutoTest {
	 
	 public static void main(String[] args) throws Exception {
	 	 
		System.setProperty("webdriver.chrome.driver", "/Users/Summer/Documents/EclipseProj/AutoTest1/chromedriver");
	 
		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();
		  
		//Launch the Paypal Website
		driver.get("https://www.paypal.com/");
		
		// print a log of page title
		String Title = driver.getTitle();
		System.out.println("Successfully opened: " + Title);
		  
		// Go to log in page
		driver.findElement(By.id("ul-btn")).click();
		System.out.println("access login page...");
	    ExpectedCondition<Boolean> pageLoadCondition = new
	            ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver driver) {
	                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                }
	            };
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(pageLoadCondition);
		
	    // Type in email
		WebElement element = driver.findElement(By.name("login_email"));  
		element.sendKeys("ABCD_abcd");  
		System.out.println("input user name...");  
		
		// Type in password
		element = driver.findElement(By.name("login_password"));  
		element.sendKeys("123456");  
		System.out.println("input password");  
		
		// login
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("Loging in...");
 
        // Wait for notifications to be present
        element = wait.until(
        	    ExpectedConditions.visibilityOfElementLocated(By.id("notifications")));
		String alertText = element.getText();
		System.out.println("Notification text: " + alertText);
		
		driver.quit();
	
	 }
}

