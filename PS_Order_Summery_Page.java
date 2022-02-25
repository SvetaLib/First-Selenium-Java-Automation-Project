package petstore_Project_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** — Automation project —
* The class of the Order Summery page:
* https://petstore.octoperf.com/actions/Order.action
** Includes Methods:**
* -Constructor
* -Confirm
* @author Sveta
*/

public class PS_Order_Summery_Page {
	WebDriver driver = null;
	
	//Locators setup
	By L_Confirm = By.className("Button");
	
	//Constructor
	public PS_Order_Summery_Page(WebDriver driver) {
		this.driver=driver;
	}
	
	//Confirm
	public void clickConfirm() {
		driver.findElement(L_Confirm).click();
	}
}
