package petstore_Project_2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** — Automation project —
 * The class of the Main page:
 * https://petstore.octoperf.com/actions/Catalog.action
 ** Includes Methods:**
 * -Constructor
 * -Click: Sign In
 * -Click Sign Out
 * -A list of Category QuickLinks
 * -Click on a chosen category
 * -Is displayed: "Sign Out"
 * -Is displayed: "Sign In"
 * 
 * @author Sveta
 */
public class PS_Main_Page {

	WebDriver driver = null;

	//Locators setup
	By L_SignIn = By.linkText("Sign In");
	By L_Signout = By.linkText("Sign Out");
	By L_CategoryQuickLinks = By.cssSelector("#QuickLinks>a");

	//Constructor
	public PS_Main_Page (WebDriver driver) {
		this.driver=driver;
	}

	//Click: Sign In
	public void clickSignIn () {
		driver.findElement(L_SignIn).click();
	}
	
	//Click Sign Out
	public void signOut() {
		driver.findElement(L_Signout).click();	
	}

	//A list of Category QuickLinks
	public List<WebElement> categoryQuickLinks_List () {

		List<WebElement> categoryLinks = driver.findElements(L_CategoryQuickLinks);
		return categoryLinks;
	}

	//Click on a chosen category
	public void clickCategory (int num) {	
		categoryQuickLinks_List().get(num).click();
	}

	//Is displayed: "Sign Out"
	public boolean loginConfirm() {

		try {
			PetStore_Test_1.set_ImplicitlyWait(1);
			if (driver.findElement(L_Signout).isDisplayed()) 
				PetStore_Test_1.set_ImplicitlyWait(10);
			return true;
		}
		catch (Exception e)
		{
			PetStore_Test_1.set_ImplicitlyWait(10);
			return false;
		}
	}
	
	//Is displayed: "Sign In"
	public boolean signOutConfirm() {
		try {
			PetStore_Test_1.set_ImplicitlyWait(1);
			if(driver.findElement(L_SignIn).isDisplayed())
				PetStore_Test_1.set_ImplicitlyWait(10);
			return true;
		}
		catch (Exception e)
		{
			PetStore_Test_1.set_ImplicitlyWait(10);
			return false;
		}
	}
}
