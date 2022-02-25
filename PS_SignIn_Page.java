package petstore_Project_2;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** — Automation project —
 * The class of the sign in page:
 * https://petstore.octoperf.com/actions/Account.action?signonForm=
 ** Includes Methods:**
 * -Constructor
 * -Input: Username
 * -Input: Password
 * -Click: login
 * -Incorrect Login: Manual Fail-safe 
 * 
 * @author Sveta
 */

public class PS_SignIn_Page {

	WebDriver driver = null;

	//Locators setup
	By L_username = By.name("username");
	By L_password = By.cssSelector("[type='password']");
	By L_loginButton = By.name("signon");
	By L_loginErrorMessage = By.xpath("//ul[@class='messages']/li");

	//Constructor
	public PS_SignIn_Page (WebDriver driver) {
		this.driver=driver;
	}
	
	//Input: Username
	public void inputUsername (String username) {
		driver.findElement(L_username).clear();
		driver.findElement(L_username).sendKeys(username);
	}

	//Input: Password
	public void inputPassword (String password) {
		driver.findElement(L_password).clear();
		driver.findElement(L_password).sendKeys(password);
	}

	//Click: login
	public void clickLogin () {
		driver.findElement(L_loginButton).click();
	}

	
	// Incorrect Login: Manual Fail-safe 
	public void loginCheck() {
		Scanner s = new Scanner(System.in);
		try {
			PetStore_Test_1.set_ImplicitlyWait(1);
			while (driver.findElement(L_loginErrorMessage).isDisplayed()) {

				//Failed Login Error
				System.out.println(driver.findElement(L_loginErrorMessage).getText());

				//Manual Tester Reset & Input: username
				System.out.println("Enter the username:");
				String correctUsername = s.nextLine();
				inputUsername(correctUsername);	

				//Manual Tester Reset & Input: password
				System.out.println("Enter the password:");
				String correctPassword = s.nextLine();
				inputPassword(correctPassword);

				//Retry Login
				clickLogin();
			}
			PetStore_Test_1.set_ImplicitlyWait(10);
		}
		catch(Exception e)
		{
			PetStore_Test_1.set_ImplicitlyWait(10);
		}
	}	


}
