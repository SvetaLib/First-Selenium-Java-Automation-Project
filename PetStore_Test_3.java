package petstore_Project_2;

public class PetStore_Test_3 {

	/** — Automation project —
	 * 
	 * Part Three: SignOut Test
	 * Log out of the site
	 * Confirm Logout by 'Sign in' 
	 * 
	 * Site being tested:
	 * https://petstore.octoperf.com/actions/Catalog.action
	 * 
	 * Account being used:
	 * Username: SvetaTest
	 * Password: 1Qwerty
	 *
	 ** Includes Methods:**
	 * -Confirm Logout by 'Sign in'
	 * @author Sveta
	 */

	public static void main(String[] args) throws Exception {

		//Setup Test with a function
		PetStore_Test_1.preTestSetup();

		//Login
		PetStore_Test_1.PS_Login();

		//POM Constructors
		PS_Main_Page mainPage = new PS_Main_Page(PetStore_Test_1.driver);

		//Logout
		mainPage.signOut();

		//Confirm Logout by 'Sign in'
		signOutConfirm();

		//close the window after a delay
		Thread.sleep(3000);
		PetStore_Test_1.driver.close();
	}

	//Confirm Logout by 'Sign in'
	public static void signOutConfirm() {
		
		PS_Main_Page mainPage = new PS_Main_Page(PetStore_Test_1.driver);
		
		if(mainPage.signOutConfirm())
			System.out.println("The 'Sign In' is present in the Header Area— Sucessfull Logout!");
		else
			System.out.println("The 'Sign In' is missing from the Header Area— Failed Logout!");
	}
}
