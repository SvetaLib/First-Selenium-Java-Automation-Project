package petstore_Project_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** — Automation project —
 * The class of the Shopping Cart page:
 * https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-13
 ** Includes Methods:**
 * -Constructor
 * -Edit number of "Male Adult Bulldog"
 * -Edit number of "Green Adult Iguana"
 * -Click: Update Cart
 * -Return subtotal price
 * -Proceed
 * @author Sveta
 */
public class PS_ShoppingCart_Page {

	WebDriver driver = null;
	WebElement element = null;
	
	//Locators setup
	By L_Quantity_Bulldog = By.name("EST-6");
	By L_Quantity_Iguana = By.name("EST-13");
	By L_UpdateCartQuantities = By.name("updateCartQuantities");
	By L_subtotal = By.cssSelector("[colspan='7']");
	By L_Proceed = By.partialLinkText("Proceed");
	
	//Constructor
	public PS_ShoppingCart_Page(WebDriver driver){
		this.driver=driver;
	}

	//Should be List based TR/TD but it's 03:29
	//Edit number of "Male Adult Bulldog"
	public void editNumberOfBulldogs() {
		element = driver.findElement(L_Quantity_Bulldog);
		element.clear();
		element.sendKeys("5");
	}
	
	//Edit number of "Green Adult Iguana"
	public void editNumberOfIguanas() {
		element = driver.findElement(L_Quantity_Iguana);
		element.clear();
		element.sendKeys("3");
	}
	
	//Click: Update Cart
	public void updateCart() {
		driver.findElement(L_UpdateCartQuantities).click();
	}
	
	//Return subtotal price
	public String cleanSubtotal() {
		String subtotal = driver.findElement(L_subtotal).getText();
		subtotal = subtotal.substring(11);
		return subtotal;
	}
	
	//Proceed
	public void ProceedToCheckout() {
		driver.findElement(L_Proceed).click();
	}





}
