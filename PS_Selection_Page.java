package petstore_Project_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** — Automation project —
 * The class of the Selection page:
 * https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-BD-01 (example)
 ** Includes Methods:**
 * -Constructor
 * -Add "Male Adult Bulldog" to cart
 * -Add "Green Adult Iguana" to cart
 * 
 * @author Sveta
 */
public class PS_Selection_Page {
	
	WebDriver driver = null;
	
	//Locators setup
	By L_MaleAdultBulldog = By.cssSelector(".Button[href*=EST-6]");
	By L_AdultIguana = By.cssSelector(".Button[href*=EST-13]");
	
	//Constructor
	public PS_Selection_Page (WebDriver driver){
		this.driver=driver;
	}
	
	//Should be List based TR/TD but it's 03:21
	//Add "Male Adult Bulldog" to cart
	public void addToCartAdultBullDog() {
		driver.findElement(L_MaleAdultBulldog).click();
	}
	
	//Add "Green Adult Iguana" to cart
	public void addToCartAdultIguana() {
		driver.findElement(L_AdultIguana).click();
	}

}
