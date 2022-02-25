package petstore_Project_2;

//import org.openqa.selenium.WebDriver;

/** — Automation project —
 * 
 * Part Two: Place an order in various quantities.
 * Example: '2' A units, 3 'B' units.
 * Do checkout.
 * Confirm that the Total equals Subtotal.
 * 
 * Site being tested:
 * https://petstore.octoperf.com/actions/Catalog.action
 * 
 * Account being used:
 * Username: SvetaTest
 * Password: 1Qwerty
 * 
 *  ** No Methods **
 * 
 * @author Sveta
 */

public class PetStore_Test_2 {

//public static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		//Setup Test with a function
		PetStore_Test_1.preTestSetup();

		//Login
		PetStore_Test_1.PS_Login();
		
		String subtotal, total;

		//POM Constructors
		PS_Main_Page mainPage = new PS_Main_Page(PetStore_Test_1.driver);
		PS_Category_Page categoryPage = new PS_Category_Page(PetStore_Test_1.driver);
		PS_Selection_Page selectBreed = new PS_Selection_Page(PetStore_Test_1.driver);
		PS_ShoppingCart_Page shoppingCart = new PS_ShoppingCart_Page(PetStore_Test_1.driver);
		PS_Checkout_Confirm_Page checkout_one = new PS_Checkout_Confirm_Page(PetStore_Test_1.driver);
		PS_Order_Summery_Page checkout_two = new PS_Order_Summery_Page(PetStore_Test_1.driver);
		PS_Final_Order_Page checkout_three = new PS_Final_Order_Page(PetStore_Test_1.driver);


		//First Item - (driver access through Test_1)

		//Choose Category
		mainPage.clickCategory(1);
		//Choose Breed
		categoryPage.chooseBreed(1, 0);
		//Add item to the chart
		selectBreed.addToCartAdultBullDog();
		//Edit number of items
		shoppingCart.editNumberOfBulldogs();
		//Update Cart
		shoppingCart.updateCart();

		//Second Item

		//Choose Category
		mainPage.clickCategory(2);
		//Choose Breed
		categoryPage.chooseBreed(2, 0);
		//Add item to the chart
		selectBreed.addToCartAdultIguana();
		//Edit number of items
		shoppingCart.editNumberOfIguanas();
		//Update Cart
		shoppingCart.updateCart();

		//Checkout

		//Save subtotal
		subtotal = shoppingCart.cleanSubtotal();

		//Proceed
		shoppingCart.ProceedToCheckout();
		//Continue
		checkout_one.clickContinue();
		//Confirm
		checkout_two.clickConfirm();

		//Save Total
		total= checkout_three.cleanTotal();

		//Compare Subtotal and Total
		if(total.equals(subtotal))
			System.out.println("The subtotal:\n"+subtotal+"\nThe total:\n"+total+"\nThey are equal!");
		else
			System.out.println("The subtotal and total are not equal!!");

		//close the window after a delay
		Thread.sleep(5000);
		PetStore_Test_1.driver.close();

	}

}
