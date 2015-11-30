import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
