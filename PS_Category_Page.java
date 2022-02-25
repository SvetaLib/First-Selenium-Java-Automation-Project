package petstore_Project_2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/** — Automation project —
 * The class of the Breed page:
 * https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS (example)
 ** Includes Methods:**
 * -Constructor
 * -TR-Animal's Breeds
 * -TD-of a specific 'TR-Animal's Breeds'
 * -Click: row>column of Breeds
 * 
 * @author Sveta
 */

public class PS_Category_Page {

	WebDriver driver = null;

	//Locators setup
	By L_breedsTR = By.cssSelector("tbody>tr");
	By L_breedsTD = By.tagName("td");
	
	//Constructor
	public PS_Category_Page(WebDriver driver){
		this.driver=driver;
	}
	
	//TR-Animal's Breeds
	public List<WebElement> breedsTR_List() {
		List<WebElement> breedsTRs = driver.findElements(L_breedsTR);
		return breedsTRs;
	}

	//TD-of a specific 'TR-Animal's Breeds'
	public List<WebElement> breedsTD_List(int row){
		List<WebElement> breedsTD = breedsTR_List().get(row).findElements(L_breedsTD);
		return breedsTD;
	}

   //Click: row>column of Breeds
	public void chooseBreed(int row, int column) {
		breedsTD_List(row).get(column).click();
	}
	
}
