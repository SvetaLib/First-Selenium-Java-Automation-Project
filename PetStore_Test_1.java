package petstore_Project_2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/** — Automation project —
 * 
 * Part One: Sign In into an existing account.
 * Confirm success by locating "Sign out".
 *
 * Site being tested:
 * https://petstore.octoperf.com/actions/Catalog.action
 * 
 * Account being used:
 * Username: SvetaTest
 * Password: 1Qwerty
 * 
 *  ** Includes Methods:**
 * -Pre-Test Setup
 * -Login
 * -Confirm Login by 'Sign out'
 * -Shortened implicitlyWait
 * 
 * @author Sveta
 */

public class PetStore_Test_1 {

	public static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		//Setup Test with a function
		preTestSetup();

		//Login
		PS_Login();

//		//POM Constructors
//		PS_Main_Page mainPage = new PS_Main_Page(driver);

		//Confirm Login by 'Sign out'
		loginConfirm();

		//close the window after a delay
		Thread.sleep(3000);
		driver.close();
	}

	//Pre-Test Setup
	public static void preTestSetup() {
		//Chrome Path
		System.setProperty("webdriver.chrome.driver", "D:\\QA stuff\\Selenium\\chromedriver.exe");
		//Object creation + Import
		driver = new ChromeDriver();
		//Maximize Window
		driver.manage().window().maximize();
		//Navigate to URL
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
		// Delay before Error
		set_ImplicitlyWait(10);	
	}

	public static void PS_Login() {

		//POM Constructors
		PS_Main_Page mainPage = new PS_Main_Page(driver);
		PS_SignIn_Page signInPage = new PS_SignIn_Page(driver);

		//Test variables
		String username = "SvetaTest";
		String password = "1Qwerty";

		//Input Login info
		mainPage.clickSignIn();
		signInPage.inputUsername(username);
		signInPage.inputPassword(password);
		signInPage.clickLogin();

		//Fail-safe - Login Check
		signInPage.loginCheck();

	}
	
	//Confirm Login by 'Sign out'
	public static void loginConfirm() {
		PS_Main_Page mainPage = new PS_Main_Page(driver);
		if(mainPage.loginConfirm())
			System.out.println("The 'Sign Out' is present in the Header Area— Sucessfull Login!");
		else
			System.out.println("The 'Sign Out' is missing from the Header Area— Failed Login!");
	}
	
	//Shortened implicitlyWait - Later Should be implemented in the other classes.
	public static void set_ImplicitlyWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/**Disclaimer: Version_2 of the project was written in a single evening, deep into the night*/
}
