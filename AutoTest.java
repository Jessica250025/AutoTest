import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
 
public class AutoTest{
 
  public static final String USERNAME = "Jessica_ca";
  public static final String ACCESS_KEY = "84007bad-7d4d-430c-938f-9c0e663f13c0";
  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
 
  public static void main(String[] args) throws Exception {
 
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "OS X 10.11");
		caps.setCapability("version", "46.0");
		 
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
 
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
