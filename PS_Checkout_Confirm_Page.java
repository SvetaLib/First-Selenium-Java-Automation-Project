package petstore_Project_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** — Automation project —
* The class of the Checkout Confirm page:
* https://petstore.octoperf.com/actions/Order.action?newOrderForm=
** Includes Methods:**
* -Constructor
* -Continue
* @author Sveta
*/
public class PS_Checkout_Confirm_Page {
	
	WebDriver driver = null;
	
	//Locators setup
	By L_Continue = By.cssSelector("[name='newOrder']");
	
	//Constructor
	public PS_Checkout_Confirm_Page(WebDriver driver) {
		this.driver=driver;
	}
	
	//Continue
	public void clickContinue() {
		driver.findElement(L_Continue).click();
	}

	
}
