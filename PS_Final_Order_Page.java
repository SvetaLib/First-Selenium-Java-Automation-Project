package petstore_Project_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** — Automation project —
* The class of the Final Order Page page:
* https://petstore.octoperf.com/actions/Order.action?newOrder=&confirmed=true
** Includes Methods:**
* -Constructor
* -Return the total price
* @author Sveta
*/

public class PS_Final_Order_Page {
	WebDriver driver = null;
	WebElement element = null;
	
	//Locators setup
	By L_Total = By.cssSelector("[colspan='5']");
	
	//Constructor
	public PS_Final_Order_Page (WebDriver driver) {
		this.driver=driver;
	}
	
	//Return the total price
	public String cleanTotal() {
		String total = driver.findElement(L_Total).getText();
		total = total.substring(7);
		return total;
	}

}
